package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class MotivoEntidad {

	private UUID id;
	private String nombre;

	public MotivoEntidad() {
		super();
	}

	private MotivoEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setNombre(builder.nombre);
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public static class Builder {

		private UUID id;
		private String nombre;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder nombre(final String nombre) {
			this.nombre = nombre;
			return this;
		}

		public MotivoEntidad build() {
			return new MotivoEntidad(this);
		}
	}
}