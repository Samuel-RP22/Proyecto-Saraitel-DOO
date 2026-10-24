package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.PrefijoDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.PrefijoNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.PrefijoEntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PrefijoNegocioImpl implements PrefijoNegocio {

	private final DAOFactory daoFactory;

	public PrefijoNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<PrefijoDominio> consultarPorFiltro(final PrefijoDominio filtro) {
		var entidadFiltro = PrefijoEntidadAssembler.getInstance().convertirAEntidad(filtro);

		return daoFactory.obtenerPrefijoDao().consultarPorFiltro(entidadFiltro).stream()
				.map(PrefijoEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public List<PrefijoDominio> consultarTodos() {
		return daoFactory.obtenerPrefijoDao().consultarTodos().stream()
				.map(PrefijoEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public PrefijoDominio consultarPorid(final UUID id) {
		var entidad = daoFactory.obtenerPrefijoDao().consultarPorId(id);

		if (entidad.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return PrefijoDominio.obtenerValorDefecto();
		}

		return PrefijoEntidadAssembler.getInstance().convertirADominio(entidad);
	}
}