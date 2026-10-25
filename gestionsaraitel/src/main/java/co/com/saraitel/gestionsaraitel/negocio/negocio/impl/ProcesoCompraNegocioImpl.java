package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.ProcesoCompraDominio;
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
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarEstadoDelProcesoCompraExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra.ValidarDatosRegistrarInformacionNuevoProcesoCompraRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProcesoCompraNegocioImpl implements ProcesoCompraNegocio {

	private final DAOFactory daoFactory;

	public ProcesoCompraNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoProcesoCompra(final ProcesoCompraDominio datos) {
		ValidarDatosRegistrarInformacionNuevoProcesoCompraRule.obtenerInstancia().ejecutar(datos);

		var idCliente = datos.getCliente().getId();
		var idEmpleado = datos.getEmpleado().getId();

		AsegurarClienteProcesoCompraExistaRule.obtenerInstancia().ejecutar(idCliente, daoFactory);
		AsegurarEmpleadoProcesoCompraExistaRule.obtenerInstancia().ejecutar(idEmpleado, daoFactory);
		AsegurarEmpleadoProcesoCompraEsteActivoRule.obtenerInstancia().ejecutar(idEmpleado, daoFactory);
		AsegurarEstadoDelProcesoCompraExistaRule.obtenerInstancia().ejecutar(datos.getEstado().getId(), daoFactory);

		AsegurarClienteNoTengaProcesoCompraConMismaFechaInicioRule.obtenerInstancia().ejecutar(idCliente,
				datos.getFechaInicio(), daoFactory);
		AsegurarEmpleadoNoTengaProcesoCompraConMismaFechaInicioRule.obtenerInstancia().ejecutar(idEmpleado,
				datos.getFechaInicio(), daoFactory);
		AsegurarClienteNoTengaProcesoCompraConMismaFechaActualizacionRule.obtenerInstancia().ejecutar(idCliente,
				datos.getFechaActualizacion(), daoFactory);
		AsegurarEmpleadoNoTengaProcesoCompraConMismaFechaActualizacionRule.obtenerInstancia().ejecutar(idEmpleado,
				datos.getFechaActualizacion(), daoFactory);

		var procesoCompraEntidad = ProcesoCompraEntidadAssembler.getInstance().convertirAEntidad(datos);

		procesoCompraEntidad.setId(generarIdProcesoCompraUnico());

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

		return ProcesoCompraEntidadAssembler.getInstance().convertirADominio(anularSiSuperoTiempoMaximoEnProceso(entidad));
	}

	private ProcesoCompraEntidad anularSiSuperoTiempoMaximoEnProceso(final ProcesoCompraEntidad entidad) {
		AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule.obtenerInstancia().ejecutar(entidad, daoFactory);

		return entidad;
	}
}
