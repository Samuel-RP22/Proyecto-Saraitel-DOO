package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.PersonaNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.PersonaEntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PersonaNegocioImpl implements PersonaNegocio {

	private final DAOFactory daoFactory;

	public PersonaNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevaPersona(final PersonaDominio datos) {
		var personaEntidad = PersonaEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);

		personaEntidad.setId(UtilUUID.generarIdUnico(id -> daoFactory.obtenerPersonaDao().consultarPorId(id).getId()));

		daoFactory.obtenerPersonaDao().crear(personaEntidad);
	}

	@Override
	public void modificarInformacionPersonaExistente(final UUID id, final PersonaDominio datos) {
		var personaExistente = daoFactory.obtenerPersonaDao().consultarPorId(id);

		if (UtilUUID.esValorDefecto(personaExistente.getId())) {
			return;
		}

		var entidadActualizada = PersonaEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);

		entidadActualizada.setId(id);

		daoFactory.obtenerPersonaDao().actualizar(id, entidadActualizada);
	}

	@Override
	public void darBajaInformacionPersonaExistente(final UUID id) {
		var personaExistente = daoFactory.obtenerPersonaDao().consultarPorId(id);

		if (UtilUUID.esValorDefecto(personaExistente.getId())) {
			return;
		}

		daoFactory.obtenerPersonaDao().eliminar(id);
	}

	@Override
	public List<PersonaDominio> consultarPorFiltro(final PersonaDominio filtro) {
		var entidadFiltro = PersonaEntidadAssembler.obtenerInstancia().convertirAEntidad(filtro);

		return daoFactory.obtenerPersonaDao().consultarPorFiltro(entidadFiltro).stream()
				.map(PersonaEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public List<PersonaDominio> consultarTodos() {
		return daoFactory.obtenerPersonaDao().consultarTodos().stream()
				.map(PersonaEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public PersonaDominio consultarPorId(final UUID id) {
		var entidad = daoFactory.obtenerPersonaDao().consultarPorId(id);

		if (UtilUUID.esValorDefecto(entidad.getId())) {
			return PersonaDominio.obtenerValorDefecto();
		}

		return PersonaEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}
}