package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.ProcesoCompraDominio;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteNoRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EstadoProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.ProcesoCompraNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.ProcesoCompraEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarClienteNoTengaProcesoCompraConMismaFechaActualizacionRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarClienteNoTengaProcesoCompraConMismaFechaInicioRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarClienteProcesoCompraExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarEmpleadoNoTengaProcesoCompraConMismaFechaActualizacionRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarEmpleadoNoTengaProcesoCompraConMismaFechaInicioRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarEmpleadoProcesoCompraEsteActivoRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarEmpleadoProcesoCompraExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.ValidarDatosRegistrarInformacionNuevoProcesoCompraRule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProcesoCompraNegocioImpl implements ProcesoCompraNegocio {

	private static final String CODIGO_ESTADO_INICIAL = "EP";

	private final DAOFactory daoFactory;

	public ProcesoCompraNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoProcesoCompra(final ProcesoCompraDominio datos) {
		ValidarDatosRegistrarInformacionNuevoProcesoCompraRule.obtenerInstancia().ejecutar(datos);

		var idEmpleado = datos.getEmpleado().getId();

		AsegurarEmpleadoProcesoCompraExistaRule.obtenerInstancia().ejecutar(idEmpleado, daoFactory);
		AsegurarEmpleadoProcesoCompraEsteActivoRule.obtenerInstancia().ejecutar(idEmpleado, daoFactory);

		var idCliente = datos.getCliente().getId();

		if (idCliente.equals(UtilUUID.obtenerUUIDDefecto())) {
			idCliente = registrarClienteNoRegistrado();
		} else {
			AsegurarClienteProcesoCompraExistaRule.obtenerInstancia().ejecutar(idCliente, daoFactory);
		}

		var ahora = UtilFecha.obtenerFechaHoraActual();

		AsegurarClienteNoTengaProcesoCompraConMismaFechaInicioRule.obtenerInstancia().ejecutar(idCliente, ahora,
				daoFactory);
		AsegurarEmpleadoNoTengaProcesoCompraConMismaFechaInicioRule.obtenerInstancia().ejecutar(idEmpleado, ahora,
				daoFactory);
		AsegurarClienteNoTengaProcesoCompraConMismaFechaActualizacionRule.obtenerInstancia().ejecutar(idCliente, ahora,
				daoFactory);
		AsegurarEmpleadoNoTengaProcesoCompraConMismaFechaActualizacionRule.obtenerInstancia().ejecutar(idEmpleado,
				ahora, daoFactory);

		var cliente = new ClienteEntidad();
		cliente.setId(idCliente);

		var empleado = new EmpleadoEntidad();
		empleado.setId(idEmpleado);

		var procesoCompraEntidad = new ProcesoCompraEntidad(generarIdProcesoCompraUnico(), cliente, empleado,
				obtenerEstadoInicial(), ahora, ahora, UtilNumero.CERO_DECIMAL);

		daoFactory.obtenerProcesoCompraDao().crear(procesoCompraEntidad);
	}

	private UUID generarIdProcesoCompraUnico() {
		UUID id;
		boolean existe;

		do {
			id = UUID.randomUUID();
			var procesoCompraExistente = daoFactory.obtenerProcesoCompraDao().consultarPorId(id);
			existe = !procesoCompraExistente.getId().equals(UtilUUID.obtenerUUIDDefecto());
		} while (existe);

		return id;
	}

	private UUID registrarClienteNoRegistrado() {
		UUID idCliente;

		do {
			idCliente = UUID.randomUUID();
		} while (!daoFactory.obtenerClienteDao().consultarPorId(idCliente).getId()
				.equals(UtilUUID.obtenerUUIDDefecto()));

		UUID idClienteNoRegistrado;

		do {
			idClienteNoRegistrado = UUID.randomUUID();
		} while (!daoFactory.obtenerClienteNoRegistradoDao().consultarPorId(idClienteNoRegistrado).getId()
				.equals(UtilUUID.obtenerUUIDDefecto()));

		var cliente = new ClienteEntidad(idCliente, false);
		daoFactory.obtenerClienteDao().crear(cliente);
		daoFactory.obtenerClienteNoRegistradoDao()
				.crear(new ClienteNoRegistradoEntidad(idClienteNoRegistrado, cliente));

		return idCliente;
	}

	private EstadoProcesoCompraEntidad obtenerEstadoInicial() {
		var filtro = new EstadoProcesoCompraEntidad();
		filtro.setCodigo(CODIGO_ESTADO_INICIAL);
		var estados = daoFactory.obtenerEstadoProcesoCompraDao().consultarPorFiltro(filtro);

		if (estados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraNegocioImpl.ESTADO_INICIAL_PROCESO_COMPRA_NO_CONFIGURADO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
		return estados.get(0);
	}

	@Override
	public List<ProcesoCompraDominio> consultarPorFiltro(final ProcesoCompraDominio filtro) {
		var entidadFiltro = ProcesoCompraEntidadAssembler.getInstance().convertirAEntidad(filtro);
		return daoFactory.obtenerProcesoCompraDao().consultarPorFiltro(entidadFiltro).stream()
				.map(this::anularSiSuperoTiempoMaximoEnProceso)
				.map(ProcesoCompraEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public List<ProcesoCompraDominio> consultarTodos() {
		return daoFactory.obtenerProcesoCompraDao().consultarTodos().stream()
				.map(this::anularSiSuperoTiempoMaximoEnProceso)
				.map(ProcesoCompraEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public ProcesoCompraDominio consultarPorid(final UUID id) {
		var entidad = daoFactory.obtenerProcesoCompraDao().consultarPorId(id);
		if (entidad.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return ProcesoCompraDominio.obtenerValorDefecto();
		}
		return ProcesoCompraEntidadAssembler.getInstance()
				.convertirADominio(anularSiSuperoTiempoMaximoEnProceso(entidad));
	}

	private ProcesoCompraEntidad anularSiSuperoTiempoMaximoEnProceso(final ProcesoCompraEntidad entidad) {
		AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule.obtenerInstancia().ejecutar(entidad, daoFactory);

		return entidad;
	}
}
