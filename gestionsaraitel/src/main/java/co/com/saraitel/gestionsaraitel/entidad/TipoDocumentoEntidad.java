package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class TipoDocumentoEntidad {

	private UUID id;
	private String tipo;

	public TipoDocumentoEntidad() {
		super();
	}

	private TipoDocumentoEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setTipo(builder.tipo);
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(final String tipo) {
		this.tipo = tipo;
	}

	public static class Builder {

		private UUID id;
		private String tipo;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder tipo(final String tipo) {
			this.tipo = tipo;
			return this;
		}

		public TipoDocumentoEntidad build() {
			return new TipoDocumentoEntidad(this);
		}
	}
}