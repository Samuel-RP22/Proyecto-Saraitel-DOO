package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoDominio {

	private UUID id;
	private ClienteDominio cliente;
	private boolean clienteNaturalDefecto;

	private ClienteRegistradoDominio(Builder builder) {
		this.id = builder.id;
		this.cliente = builder.cliente;
		this.clienteNaturalDefecto = builder.clienteNaturalDefecto;
	}

	public UUID getId() {
		return id;
	}

	public ClienteDominio getCliente() {
		return cliente;
	}
	
	public boolean getClienteNaturalDefecto() {
		return clienteNaturalDefecto;
	}
	

	public static class Builder {
		private UUID id;
		private ClienteDominio cliente;
		private boolean clienteNaturalDefecto;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cliente = new ClienteDominio.Builder().build();
			clienteNaturalDefecto = false;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder cliente(ClienteDominio cliente) {
			this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteDominio.Builder().build());
			return this;
		}
		
		public Builder clienteNaturalDefecto(boolean clienteNaturalDefecto) {
			this.clienteNaturalDefecto = clienteNaturalDefecto ;
			return this;
		}

		public ClienteRegistradoDominio build() {
			return new ClienteRegistradoDominio(this);
		}
	}
}