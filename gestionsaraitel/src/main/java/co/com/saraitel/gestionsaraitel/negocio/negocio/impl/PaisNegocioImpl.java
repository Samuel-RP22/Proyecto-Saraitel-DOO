
package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.PaisDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.PaisNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.PaisEntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PaisNegocioImpl implements PaisNegocio {

	private final DAOFactory daoFactory;

	public PaisNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<PaisDominio> consultarPorFiltro(final PaisDominio filtro) {
		var entidadFiltro = PaisEntidadAssembler.getInstance().convertirAEntidad(filtro);

		return daoFactory.obtenerPaisDao().consultarPorFiltro(entidadFiltro).stream()
				.map(PaisEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public List<PaisDominio> consultarTodos() {
		return daoFactory.obtenerPaisDao().consultarTodos().stream()
				.map(PaisEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public PaisDominio consultarPorId(final UUID id) {
		var entidad = daoFactory.obtenerPaisDao().consultarPorId(id);

		if (entidad.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return PaisDominio.obtenerValorDefecto();
		}

		return PaisEntidadAssembler.getInstance().convertirADominio(entidad);
	}
}