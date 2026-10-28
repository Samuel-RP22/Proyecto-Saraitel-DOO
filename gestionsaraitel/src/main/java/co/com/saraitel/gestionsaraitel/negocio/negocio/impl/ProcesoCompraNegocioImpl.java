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

		if (UtilUUID.esValorDefecto(idCliente)) {
			idCliente = obtenerClienteGenerico().getCliente().getId();
		} else {
			AsegurarClienteProcesoCompraExistaRule.obtenerInstancia().ejecutar(idCliente, daoFactory);
		}

		var esClienteGenerico = esClienteGenerico(idCliente);

		var ahora = UtilFecha.obtenerFechaHoraActual();

		if (!esClienteGenerico) {
			AsegurarClienteNoTengaProcesoCompraConMismaFechaInicioRule.obtenerInstancia().ejecutar(idCliente, ahora,
					daoFactory);
			AsegurarClienteNoTengaProcesoCompraConMismaFechaActualizacionRule.obtenerInstancia().ejecutar(idCliente,
					ahora, daoFactory);
		}

		AsegurarEmpleadoNoTengaProcesoCompraConMismaFechaInicioRule.obtenerInstancia().ejecutar(idEmpleado, ahora,
				daoFactory);
		AsegurarEmpleadoNoTengaProcesoCompraConMismaFechaActualizacionRule.obtenerInstancia().ejecutar(idEmpleado,
				ahora, daoFactory);

		var cliente = new ClienteEntidad();
		cliente.setId(idCliente);

		var empleado = new EmpleadoEntidad();
		empleado.setId(idEmpleado);

		var procesoCompraEntidad = new ProcesoCompraEntidad(UtilUUID.generarIdUnico(id -> daoFactory.obtenerProcesoCompraDao().consultarPorId(id).getId()), cliente, empleado,
				obtenerEstadoInicial(), ahora, ahora, UtilNumero.CERO_DECIMAL);

		daoFactory.obtenerProcesoCompraDao().crear(procesoCompraEntidad);
	}

	// Solo existe un cliente no registrado (el genérico, Consumidor final), creado con el script de la base de
	// datos. Aquí únicamente se consulta; nunca se crea.
	private ClienteNoRegistradoEntidad obtenerClienteGenerico() {
		var genericos = daoFactory.obtenerClienteNoRegistradoDao().consultarTodos();

		if (genericos.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraNegocioImpl.CLIENTE_GENERICO_NO_CONFIGURADO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
		return genericos.get(0);
	}

	private boolean esClienteGenerico(final UUID idCliente) {
		var cliente = new ClienteEntidad();
		cliente.setId(idCliente);

		var filtro = new ClienteNoRegistradoEntidad();
		filtro.setCliente(cliente);

		return !daoFactory.obtenerClienteNoRegistradoDao().consultarPorFiltro(filtro).isEmpty();
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
		var entidadFiltro = ProcesoCompraEntidadAssembler.obtenerInstancia().convertirAEntidad(filtro);
		return daoFactory.obtenerProcesoCompraDao().consultarPorFiltro(entidadFiltro).stream()
				.map(this::anularSiSuperoTiempoMaximoEnProceso)
				.map(ProcesoCompraEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public List<ProcesoCompraDominio> consultarTodos() {
		return daoFactory.obtenerProcesoCompraDao().consultarTodos().stream()
				.map(this::anularSiSuperoTiempoMaximoEnProceso)
				.map(ProcesoCompraEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public ProcesoCompraDominio consultarPorId(final UUID id) {
		var entidad = daoFactory.obtenerProcesoCompraDao().consultarPorId(id);
		if (UtilUUID.esValorDefecto(entidad.getId())) {
			return ProcesoCompraDominio.obtenerValorDefecto();
		}
		return ProcesoCompraEntidadAssembler.obtenerInstancia()
				.convertirADominio(anularSiSuperoTiempoMaximoEnProceso(entidad));
	}

	private ProcesoCompraEntidad anularSiSuperoTiempoMaximoEnProceso(final ProcesoCompraEntidad entidad) {
		AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule.obtenerInstancia().ejecutar(entidad, daoFactory);

		return entidad;
	}
}
