package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class ClienteRegistradoNEntidad {

	private UUID id;
	private ClienteRegistradoEntidad clienteregistrado;
	private PersonaEntidad persona;

	public ClienteRegistradoNEntidad() {
		super();
	}

	private ClienteRegistradoNEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setClienteregistrado(builder.clienteregistrado);
		setPersona(builder.persona);
	}

	public static Builder builder() {
		return new Builder();
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

	public static class Builder {

		private UUID id;
		private ClienteRegistradoEntidad clienteregistrado;
		private PersonaEntidad persona;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder clienteregistrado(final ClienteRegistradoEntidad clienteregistrado) {
			this.clienteregistrado = clienteregistrado;
			return this;
		}

		public Builder persona(final PersonaEntidad persona) {
			this.persona = persona;
			return this;
		}

		public ClienteRegistradoNEntidad build() {
			return new ClienteRegistradoNEntidad(this);
		}
	}
}