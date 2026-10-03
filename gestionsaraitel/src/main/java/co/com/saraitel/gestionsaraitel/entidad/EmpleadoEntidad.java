package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class EmpleadoEntidad {

	private UUID id;
	private SedeEntidad sede;
	private PersonaEntidad persona;
	private boolean esactivo;

	public EmpleadoEntidad() {
		super();
	}

	private EmpleadoEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setSede(builder.sede);
		setPersona(builder.persona);
		setEsactivo(builder.esactivo);
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

	public SedeEntidad getSede() {
		return sede;
	}

	public void setSede(final SedeEntidad sede) {
		this.sede = sede;
	}

	public PersonaEntidad getPersona() {
		return persona;
	}

	public void setPersona(final PersonaEntidad persona) {
		this.persona = persona;
	}

	public boolean isEsactivo() {
		return esactivo;
	}

	public void setEsactivo(final boolean esactivo) {
		this.esactivo = esactivo;
	}

	public static class Builder {

		private UUID id;
		private SedeEntidad sede;
		private PersonaEntidad persona;
		private boolean esactivo;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder sede(final SedeEntidad sede) {
			this.sede = sede;
			return this;
		}

		public Builder persona(final PersonaEntidad persona) {
			this.persona = persona;
			return this;
		}

		public Builder esactivo(final boolean esactivo) {
			this.esactivo = esactivo;
			return this;
		}

		public EmpleadoEntidad build() {
			return new EmpleadoEntidad(this);
		}
	}
}