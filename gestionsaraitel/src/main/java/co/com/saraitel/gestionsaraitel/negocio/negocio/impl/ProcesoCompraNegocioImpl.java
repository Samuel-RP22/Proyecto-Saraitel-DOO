package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.ProcesoCompraDominio;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EstadoProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.ProcesoCompraNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.ProcesoCompraEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarClienteProcesoCompraExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarEmpleadoProcesoCompraEsteActivoRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarEmpleadoProcesoCompraExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarNuevoProcesoCompraNoEsteDuplicadoRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarProcesoCompraExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.ValidarDatosConsultarProcesosCompraPorFiltroRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.ValidarDatosRegistrarInformacionNuevoProcesoCompraRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProcesoCompraNegocioImpl implements ProcesoCompraNegocio {

	private static final String CODIGO_ESTADO_EN_PROCESO = "EP";

	private final DAOFactory daoFactory;

	public ProcesoCompraNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoProcesoCompra(final ProcesoCompraDominio datos) {
		ValidarDatosRegistrarInformacionNuevoProcesoCompraRule.obtenerInstancia().ejecutar(datos);
		AsegurarEmpleadoProcesoCompraExistaRule.obtenerInstancia().ejecutar(datos.getEmpleado().getId(), daoFactory);
		AsegurarEmpleadoProcesoCompraEsteActivoRule.obtenerInstancia().ejecutar(datos.getEmpleado().getId(),
				daoFactory);
		AsegurarClienteProcesoCompraExistaRule.obtenerInstancia().ejecutar(datos.getCliente().getId(), daoFactory);
		var procesoCompraEntidad = construirNuevoProcesoCompra(datos);
		AsegurarNuevoProcesoCompraNoEsteDuplicadoRule.obtenerInstancia().ejecutar(procesoCompraEntidad, daoFactory);
		daoFactory.obtenerProcesoCompraDao().crear(procesoCompraEntidad);
	}

	@Override
	public List<ProcesoCompraDominio> consultarPorFiltro(final ProcesoCompraDominio filtro) {
		ValidarDatosConsultarProcesosCompraPorFiltroRule.obtenerInstancia().ejecutar(filtro, daoFactory);
		var entidadFiltro = ProcesoCompraEntidadAssembler.obtenerInstancia().convertirAEntidad(filtro);
		return daoFactory.obtenerProcesoCompraDao().consultarPorFiltro(entidadFiltro).stream()
				.map(ProcesoCompraEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public List<ProcesoCompraDominio> consultarTodos() {
		return daoFactory.obtenerProcesoCompraDao().consultarTodos().stream()
				.map(ProcesoCompraEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public ProcesoCompraDominio consultarPorId(final UUID id) {
		AsegurarProcesoCompraExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		var entidad = daoFactory.obtenerProcesoCompraDao().consultarPorId(id);
		return ProcesoCompraEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}

	private ProcesoCompraEntidad construirNuevoProcesoCompra(final ProcesoCompraDominio datos) {
		var ahora = UtilFecha.obtenerFechaHoraActual();
		var procesoCompraEntidad = ProcesoCompraEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);
		procesoCompraEntidad
				.setId(UtilUUID.generarIdUnico(id -> daoFactory.obtenerProcesoCompraDao().consultarPorId(id).getId()));
		procesoCompraEntidad.setCliente(obtenerClienteProcesoCompra(procesoCompraEntidad.getCliente()));
		procesoCompraEntidad.setEstado(obtenerEstadoEnProceso());
		procesoCompraEntidad.setFechaInicio(ahora);
		procesoCompraEntidad.setFechaActualizacion(ahora);
		procesoCompraEntidad.setTotal(UtilNumero.CERO_DECIMAL);
		return procesoCompraEntidad;
	}

	private ClienteEntidad obtenerClienteProcesoCompra(final ClienteEntidad cliente) {
		if (UtilUUID.esValorDefecto(cliente.getId())) {
			return daoFactory.obtenerClienteNoRegistradoDao().consultarTodos().get(0).getCliente();
		}
		return cliente;
	}

	private EstadoProcesoCompraEntidad obtenerEstadoEnProceso() {
		var estadoFiltro = new EstadoProcesoCompraEntidad();
		estadoFiltro.setCodigo(CODIGO_ESTADO_EN_PROCESO);
		return daoFactory.obtenerEstadoProcesoCompraDao().consultarPorFiltro(estadoFiltro).get(0);
	}

	private List<ProcesoCompraEntidad> consultarProcesosCompraEnProceso() {
		var procesoCompraFiltro = new ProcesoCompraEntidad();
		procesoCompraFiltro.setEstado(obtenerEstadoEnProceso());
		return daoFactory.obtenerProcesoCompraDao().consultarPorFiltro(procesoCompraFiltro);
	}

	@Override
	public void anularProcesosCompraVencidos() {
		for (var procesoCompra : consultarProcesosCompraEnProceso()) {
			AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule.obtenerInstancia().ejecutar(procesoCompra,
					daoFactory);
		}
	}
}
