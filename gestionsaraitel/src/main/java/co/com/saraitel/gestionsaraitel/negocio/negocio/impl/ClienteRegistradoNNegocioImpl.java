package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoNDominio;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoNEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.ClienteRegistradoNNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.ClienteRegistradoNEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.PersonaEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradon.AsegurarPersonaClienteNaturalExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradon.AsegurarPersonaNoSeaClienteNaturalRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarCorreoNuevaPersonaNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarNumeroDocumentoNuevaPersonaNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarTelefonoNuevaPersonaNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.ValidarDatosRegistrarInformacionNuevaPersonaRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoNNegocioImpl implements ClienteRegistradoNNegocio {

	private final DAOFactory daoFactory;

	public ClienteRegistradoNNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoClienteNatural(final ClienteRegistradoNDominio datos) {
		var persona = datos.getPersona();
		UUID idPersona;

		if (persona.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			// Persona nueva: se valida igual que en el registro de personas y se crea en esta transacción.
			ValidarDatosRegistrarInformacionNuevaPersonaRule.obtenerInstancia().ejecutar(persona);

			AsegurarNumeroDocumentoNuevaPersonaNoExistaRule.obtenerInstancia().ejecutar(persona.getNumeroDocumento(),
					daoFactory);
			AsegurarTelefonoNuevaPersonaNoExistaRule.obtenerInstancia().ejecutar(persona.getTelefono(), daoFactory);
			AsegurarCorreoNuevaPersonaNoExistaRule.obtenerInstancia().ejecutar(persona.getCorreo(), daoFactory);

			var personaEntidad = PersonaEntidadAssembler.getInstance().convertirAEntidad(persona);
			idPersona = generarIdUnico(id -> daoFactory.obtenerPersonaDao().consultarPorId(id).getId());
			personaEntidad.setId(idPersona);
			daoFactory.obtenerPersonaDao().crear(personaEntidad);
		} else {
			idPersona = persona.getId();
			AsegurarPersonaClienteNaturalExistaRule.obtenerInstancia().ejecutar(idPersona, daoFactory);
		}

		AsegurarPersonaNoSeaClienteNaturalRule.obtenerInstancia().ejecutar(idPersona, daoFactory);

		var personaReferencia = new PersonaEntidad();
		personaReferencia.setId(idPersona);

		var clienteRegistrado = registrarClienteRegistrado(true);

		var clienteNatural = new ClienteRegistradoNEntidad(
				generarIdUnico(id -> daoFactory.obtenerClienteRegistradoNDao().consultarPorId(id).getId()),
				clienteRegistrado, personaReferencia);

		daoFactory.obtenerClienteRegistradoNDao().crear(clienteNatural);
	}

	@Override
	public List<ClienteRegistradoNDominio> consultarPorFiltro(final ClienteRegistradoNDominio filtro) {
		var entidadFiltro = ClienteRegistradoNEntidadAssembler.getInstance().convertirAEntidad(filtro);

		return daoFactory.obtenerClienteRegistradoNDao().consultarPorFiltro(entidadFiltro).stream()
				.map(ClienteRegistradoNEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public List<ClienteRegistradoNDominio> consultarTodos() {
		return daoFactory.obtenerClienteRegistradoNDao().consultarTodos().stream()
				.map(ClienteRegistradoNEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public ClienteRegistradoNDominio consultarPorid(final UUID id) {
		var entidad = daoFactory.obtenerClienteRegistradoNDao().consultarPorId(id);

		return ClienteRegistradoNEntidadAssembler.getInstance().convertirADominio(entidad);
	}

	private UUID generarIdUnico(final Function<UUID, UUID> consultarIdExistente) {
		UUID id;

		do {
			id = UUID.randomUUID();
		} while (!consultarIdExistente.apply(id).equals(UtilUUID.obtenerUUIDDefecto()));

		return id;
	}

	private ClienteRegistradoEntidad registrarClienteRegistrado(final boolean esNatural) {
		var cliente = new ClienteEntidad(generarIdUnico(id -> daoFactory.obtenerClienteDao().consultarPorId(id).getId()),
				true);
		daoFactory.obtenerClienteDao().crear(cliente);

		var clienteRegistrado = new ClienteRegistradoEntidad(
				generarIdUnico(id -> daoFactory.obtenerClienteRegistradoDao().consultarPorId(id).getId()), cliente,
				esNatural);
		daoFactory.obtenerClienteRegistradoDao().crear(clienteRegistrado);

		return clienteRegistrado;
	}
}
