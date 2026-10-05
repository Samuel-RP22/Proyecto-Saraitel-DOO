package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoNDominio {

	private UUID id;
	private ClienteRegistradoDominio clienteRegistrado;
	private PersonaDominio persona;

	private ClienteRegistradoNDominio(Builder builder) {
		this.id = builder.id;
		this.clienteRegistrado = builder.clienteRegistrado;
		this.persona = builder.persona;
	}

	public UUID getId() {
		return id;
	}

	public ClienteRegistradoDominio getClienteRegistrado() {
		return clienteRegistrado;
	}
	
	public PersonaDominio getPersona() {
		return persona;
	}
	

	public static class Builder {
		private UUID id;
		private ClienteRegistradoDominio clienteRegistrado;
		private PersonaDominio persona;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			clienteRegistrado = new ClienteRegistradoDominio.Builder().build();
			persona =  new PersonaDominio.Builder().build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder clienteRegistrado(ClienteRegistradoDominio clienteRegistrado) {
			this.clienteRegistrado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(clienteRegistrado, new ClienteRegistradoDominio.Builder().build());
			return this;
		}
		
		public Builder persona(PersonaDominio persona) {
			this.persona = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(persona, new PersonaDominio.Builder().build());
			return this;
		}
		
		
		public ClienteRegistradoNDominio build() {
			return new ClienteRegistradoNDominio(this);
		}
	}
}