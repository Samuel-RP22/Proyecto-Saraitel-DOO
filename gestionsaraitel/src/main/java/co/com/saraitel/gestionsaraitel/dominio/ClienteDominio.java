package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteDominio {

	private UUID id;
	private boolean esClienteRegistrado;

	private ClienteDominio(Builder builder) {
		this.id = builder.id;
		this.esClienteRegistrado = builder.esClienteRegistrado;
	}

	public UUID getId() {
		return id;
	}

	public boolean getEsClienteRegistrado() {
		return esClienteRegistrado;
	}

	public static class Builder {
		private UUID id;
		private boolean esClienteRegistrado;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			esClienteRegistrado = true;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder esClienteRegistrado(boolean esClienteRegistrado) {
			this.esClienteRegistrado = esClienteRegistrado ;
			return this;
		}

		public ClienteDominio build() {
			return new ClienteDominio(this);
		}
	}
}