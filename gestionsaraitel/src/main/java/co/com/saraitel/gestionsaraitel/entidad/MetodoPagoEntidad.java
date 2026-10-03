package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class MetodoPagoEntidad {

	private UUID id;
	private String nombre;
	private boolean esactivo;

	public MetodoPagoEntidad() {
		super();
	}

	private MetodoPagoEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setNombre(builder.nombre);
		setEsActivo(builder.esactivo);
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

	public boolean isEsActivo() {
		return esactivo;
	}

	public void setEsActivo(final boolean esactivo) {
		this.esactivo = esactivo;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private boolean esactivo;

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

		public Builder esactivo(final boolean esactivo) {
			this.esactivo = esactivo;
			return this;
		}

		public MetodoPagoEntidad build() {
			return new MetodoPagoEntidad(this);
		}
	}
}