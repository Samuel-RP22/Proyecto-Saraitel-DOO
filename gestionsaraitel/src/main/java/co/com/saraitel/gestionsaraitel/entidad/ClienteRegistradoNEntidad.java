package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class ClienteRegistradoNEntidad {

	private UUID id;
	private ClienteRegistradoEntidad clienteregistrado;
	private PersonaEntidad persona;

	public ClienteRegistradoNEntidad() {
		super();
	}

	public ClienteRegistradoNEntidad(final UUID id, final ClienteRegistradoEntidad clienteregistrado, final PersonaEntidad persona) {
		super();
		setId(id);
		setClienteregistrado(clienteregistrado);
		setPersona(persona);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public ClienteRegistradoEntidad getClienteregistrado() {
		return clienteregistrado;
	}

	public void setClienteregistrado(final ClienteRegistradoEntidad clienteregistrado) {
		this.clienteregistrado = clienteregistrado;
	}

	public PersonaEntidad getPersona() {
		return persona;
	}

	public void setPersona(final PersonaEntidad persona) {
		this.persona = persona;
	}
}