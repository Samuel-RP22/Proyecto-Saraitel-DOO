package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class ClientNoRegistradoEntidad {

	private UUID id;
	private ClienteEntidad cliente;

	public ClientNoRegistradoEntidad() {
		super();
	}

	private ClientNoRegistradoEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setCliente(builder.cliente);
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

	public ClienteEntidad getCliente() {
		return cliente;
	}

	public void setCliente(final ClienteEntidad cliente) {
		this.cliente = cliente;
	}

	public static class Builder {

		private UUID id;
		private ClienteEntidad cliente;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder cliente(final ClienteEntidad cliente) {
			this.cliente = cliente;
			return this;
		}

		public ClientNoRegistradoEntidad build() {
			return new ClientNoRegistradoEntidad(this);
		}
	}
}