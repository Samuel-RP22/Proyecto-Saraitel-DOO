package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class ClienteEntidad {

	private UUID id;
	private boolean esActivo;

	public ClienteEntidad() {
		super();
	}

	private ClienteEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setEsActivo(builder.esActivo);
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

	public boolean isEsActivo() {
		return esActivo;
	}

	public void setEsActivo(final boolean esActivo) {
		this.esActivo = esActivo;
	}

	public static class Builder {

		private UUID id;
		private boolean esActivo;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder esActivo(final boolean esActivo) {
			this.esActivo = esActivo;
			return this;
		}

		public ClienteEntidad build() {
			return new ClienteEntidad(this);
		}
	}
}