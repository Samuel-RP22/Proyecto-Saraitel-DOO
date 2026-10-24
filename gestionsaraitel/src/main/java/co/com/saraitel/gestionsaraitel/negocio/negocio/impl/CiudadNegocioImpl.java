
package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.CiudadDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.CiudadNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.CiudadEntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class CiudadNegocioImpl implements CiudadNegocio {

	private final DAOFactory daoFactory;

	public CiudadNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<CiudadDominio> consultarPorFiltro(final CiudadDominio filtro) {
		var entidadFiltro = CiudadEntidadAssembler.getInstance().convertirAEntidad(filtro);

		return daoFactory.obtenerCiudadDao().consultarPorFiltro(entidadFiltro).stream()
				.map(CiudadEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public List<CiudadDominio> consultarTodos() {
		return daoFactory.obtenerCiudadDao().consultarTodos().stream()
				.map(CiudadEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public CiudadDominio consultarPorid(final UUID id) {
		var entidad = daoFactory.obtenerCiudadDao().consultarPorId(id);

		if (entidad.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return CiudadDominio.obtenerValorDefecto();
		}

		return CiudadEntidadAssembler.getInstance().convertirADominio(entidad);
	}
}
