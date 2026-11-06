package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.PersonaNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.PersonaEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarCorreoNuevaPersonaNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarCorreoPersonaNoExistaEnOtraPersonaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarNumeroDocumentoNuevaPersonaNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarNumeroDocumentoPersonaNoExistaEnOtraPersonaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarPersonaExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarPersonaNoEsteSiendoUtilizadaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarTelefonoNuevaPersonaNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarTelefonoPersonaNoExistaEnOtraPersonaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.ValidarDatosConsultarPersonasPorFiltroRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.ValidarDatosModificarInformacionPersonaExistenteRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.ValidarDatosRegistrarInformacionNuevaPersonaRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PersonaNegocioImpl implements PersonaNegocio {

	private final DAOFactory daoFactory;

	public PersonaNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevaPersona(final PersonaDominio datos) {
		ValidarDatosRegistrarInformacionNuevaPersonaRule.obtenerInstancia().ejecutar(datos);
		AsegurarNumeroDocumentoNuevaPersonaNoExistaRule.obtenerInstancia().ejecutar(datos.getNumeroDocumento(),
				daoFactory);
		AsegurarTelefonoNuevaPersonaNoExistaRule.obtenerInstancia().ejecutar(datos.getTelefono(), daoFactory);
		AsegurarCorreoNuevaPersonaNoExistaRule.obtenerInstancia().ejecutar(datos.getCorreo(), daoFactory);
		var personaEntidad = PersonaEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);
		personaEntidad.setId(UtilUUID.generarIdUnico(id -> daoFactory.obtenerPersonaDao().consultarPorId(id).getId()));
		daoFactory.obtenerPersonaDao().crear(personaEntidad);
	}

	@Override
	public void modificarInformacionPersonaExistente(final UUID id, final PersonaDominio datos) {
		AsegurarPersonaExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		ValidarDatosModificarInformacionPersonaExistenteRule.obtenerInstancia().ejecutar(datos);
		AsegurarNumeroDocumentoPersonaNoExistaEnOtraPersonaRule.obtenerInstancia().ejecutar(id,
				datos.getNumeroDocumento(), daoFactory);
		AsegurarTelefonoPersonaNoExistaEnOtraPersonaRule.obtenerInstancia().ejecutar(id, datos.getTelefono(),
				daoFactory);
		AsegurarCorreoPersonaNoExistaEnOtraPersonaRule.obtenerInstancia().ejecutar(id, datos.getCorreo(), daoFactory);
		var personaEntidad = PersonaEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);
		daoFactory.obtenerPersonaDao().actualizar(id, personaEntidad);
	}

	@Override
	public void darBajaInformacionPersonaExistente(final UUID id) {
		AsegurarPersonaExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		AsegurarPersonaNoEsteSiendoUtilizadaRule.obtenerInstancia().ejecutar(id, daoFactory);
		daoFactory.obtenerPersonaDao().eliminar(id);
	}

	@Override
	public List<PersonaDominio> consultarPorFiltro(final PersonaDominio filtro) {
		ValidarDatosConsultarPersonasPorFiltroRule.obtenerInstancia().ejecutar(filtro);
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
		AsegurarPersonaExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		var entidad = daoFactory.obtenerPersonaDao().consultarPorId(id);
		return PersonaEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}
}
