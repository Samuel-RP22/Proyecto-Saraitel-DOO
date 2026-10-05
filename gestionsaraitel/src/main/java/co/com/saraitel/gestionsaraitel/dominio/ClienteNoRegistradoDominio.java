package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteNoRegistradoDominio {

	private UUID id;
	private ClienteDominio cliente;

	private ClienteNoRegistradoDominio(Builder builder) {
		this.id = builder.id;
		this.cliente = builder.cliente;
	}

	public UUID getId() {
		return id;
	}

	public ClienteDominio getCliente() {
		return cliente;
	}

	public static class Builder {
		private UUID id;
		private ClienteDominio cliente;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cliente = new ClienteDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder cliente(ClienteDominio cliente) {
			this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteDominio.Builder().build());
			return this;
		}
		

		public ClienteNoRegistradoDominio build() {
			return new ClienteNoRegistradoDominio(this);
		}
	}
}