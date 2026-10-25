package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.EstadoProcesoCompraDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.EstadoProcesoCompraNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.EstadoProcesoCompraEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.estadoprocesocompra.AsegurarCodigoNuevoEstadoProcesoCompraNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.estadoprocesocompra.AsegurarNombreNuevoEstadoProcesoCompraNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.estadoprocesocompra.ValidarDatosRegistrarInformacionNuevoEstadoProcesoCompraRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class EstadoProcesoCompraNegocioImpl implements EstadoProcesoCompraNegocio {

	private final DAOFactory daoFactory;

	public EstadoProcesoCompraNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoEstadoProcesoCompra(final EstadoProcesoCompraDominio datos) {
		ValidarDatosRegistrarInformacionNuevoEstadoProcesoCompraRule.obtenerInstancia().ejecutar(datos);

		AsegurarCodigoNuevoEstadoProcesoCompraNoExistaRule.obtenerInstancia().ejecutar(datos.getCodigo(), daoFactory);
		AsegurarNombreNuevoEstadoProcesoCompraNoExistaRule.obtenerInstancia().ejecutar(datos.getNombre(), daoFactory);

		var estadoProcesoCompraEntidad = EstadoProcesoCompraEntidadAssembler.getInstance().convertirAEntidad(datos);

		estadoProcesoCompraEntidad.setId(generarIdEstadoProcesoCompraUnico());

		daoFactory.obtenerEstadoProcesoCompraDao().crear(estadoProcesoCompraEntidad);
	}

	private UUID generarIdEstadoProcesoCompraUnico() {
		UUID id;
		boolean existe;

		do {
			id = UUID.randomUUID();
			var estadoExistente = daoFactory.obtenerEstadoProcesoCompraDao().consultarPorId(id);
			existe = !estadoExistente.getId().equals(UtilUUID.obtenerUUIDDefecto());
		} while (existe);

		return id;
	}

	@Override
	public List<EstadoProcesoCompraDominio> consultarPorFiltro(final EstadoProcesoCompraDominio filtro) {
		var entidadFiltro = EstadoProcesoCompraEntidadAssembler.getInstance().convertirAEntidad(filtro);

		return daoFactory.obtenerEstadoProcesoCompraDao().consultarPorFiltro(entidadFiltro).stream()
				.map(EstadoProcesoCompraEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public List<EstadoProcesoCompraDominio> consultarTodos() {
		return daoFactory.obtenerEstadoProcesoCompraDao().consultarTodos().stream()
				.map(EstadoProcesoCompraEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public EstadoProcesoCompraDominio consultarPorid(final UUID id) {
		var entidad = daoFactory.obtenerEstadoProcesoCompraDao().consultarPorId(id);

		if (entidad.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return EstadoProcesoCompraDominio.obtenerValorDefecto();
		}

		return EstadoProcesoCompraEntidadAssembler.getInstance().convertirADominio(entidad);
	}
}
