package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class PrefijoEntidad {

	private UUID id;
	private String codigo;

	public PrefijoEntidad() {
		super();
	}

	private PrefijoEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setCodigo(builder.codigo);
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	public static class Builder {

		private UUID id;
		private String codigo;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder codigo(final String codigo) {
			this.codigo = codigo;
			return this;
		}

		public PrefijoEntidad build() {
			return new PrefijoEntidad(this);
		}
	}
}