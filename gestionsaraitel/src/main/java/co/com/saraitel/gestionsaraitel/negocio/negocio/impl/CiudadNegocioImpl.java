
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
		var entidadFiltro = CiudadEntidadAssembler.obtenerInstancia().convertirAEntidad(filtro);

		return daoFactory.obtenerCiudadDao().consultarPorFiltro(entidadFiltro).stream()
				.map(CiudadEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public List<CiudadDominio> consultarTodos() {
		return daoFactory.obtenerCiudadDao().consultarTodos().stream()
				.map(CiudadEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public CiudadDominio consultarPorId(final UUID id) {
		var entidad = daoFactory.obtenerCiudadDao().consultarPorId(id);

		if (UtilUUID.esValorDefecto(entidad.getId())) {
			return CiudadDominio.obtenerValorDefecto();
		}

		return CiudadEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}
}
