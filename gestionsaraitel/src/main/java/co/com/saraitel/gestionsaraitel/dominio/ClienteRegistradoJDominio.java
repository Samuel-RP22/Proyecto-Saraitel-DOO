package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoJDominio {

	private UUID id;
	private ClienteRegistradoDominio clienteRegistrado;
	private PrefijoDominio prefijo;
	private String telefono;
	private String nit;
	private String razonSocial;
	private String correo;
	private boolean telefonoConfirmado;
	private boolean correoConfirmado;
	
	private ClienteRegistradoJDominio(Builder builder) {
		this.id = builder.id;
		this.clienteRegistrado = builder.clienteRegistrado;
		this.prefijo = builder.prefijo;
		this.telefono = builder.telefono;
		this.nit = builder.nit;
		this.razonSocial = builder.razonSocial;
		this.correo = builder.correo;
		this.telefonoConfirmado = builder.telefonoConfirmado;
		this.correoConfirmado = builder.correoConfirmado;
	}

	public UUID getId() {
		return id;
	}

	public ClienteRegistradoDominio getClienteRegistrado() {
		return clienteRegistrado;
	}
	
	public PrefijoDominio getPrefijo() {
		return prefijo;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public String getNit() {
		return nit;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public boolean getTelefonoConfirmadoo() {
		return telefonoConfirmado;
	}
	
	public boolean getCorreoConfirmado() {
		return correoConfirmado;
	}

	public static class Builder {
		private UUID id;
		private ClienteRegistradoDominio clienteRegistrado;
		private PrefijoDominio prefijo;
		private String telefono;
		private String nit;
		private String razonSocial;
		private String correo;
		private boolean telefonoConfirmado;
		private boolean correoConfirmado;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			clienteRegistrado = new ClienteRegistradoDominio.Builder().build();
			prefijo = new PrefijoDominio.Builder().build();
			telefono = UtilTexto.VACIA;
			nit = UtilTexto.VACIA;
			razonSocial = UtilTexto.VACIA;
			correo = UtilTexto.VACIA;
			telefonoConfirmado = false;
			correoConfirmado = false; 
		
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder clienteRegistrado(ClienteRegistradoDominio clienteRegistrado) {
			this.clienteRegistrado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(clienteRegistrado, new ClienteRegistradoDominio.Builder().build()) ;
			return this;
		}
		
		public Builder prefijo(PrefijoDominio prefijo) {
			this.prefijo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(prefijo, new PrefijoDominio.Builder().build()) ;
			return this;
		}
		
		public Builder telefono(String telefono) {
			this.telefono = UtilTexto.quitarEspaciosEnBlanco(telefono) ;
			return this;
		}
		
		public Builder nit(String nombre) {
			this.nit = UtilTexto.quitarEspaciosEnBlanco(nombre) ;
			return this;
		}
		
		public Builder razonSocial(String razonSocial) {
			this.razonSocial = UtilTexto.quitarEspaciosEnBlanco(razonSocial) ;
			return this;
		}
		
		public Builder correo(String correo) {
			this.correo = UtilTexto.quitarEspaciosEnBlanco(correo) ;
			return this;
		}
		
		public Builder telefonoConfirmado(boolean telefonoConfirmado) {
			this.telefonoConfirmado = telefonoConfirmado;
			return this;
		}
		
		public Builder correoConfirmado(boolean correoConfirmado) {
			this.correoConfirmado = correoConfirmado;
			return this;
		}
		

		public ClienteRegistradoJDominio build() {
			return new ClienteRegistradoJDominio(this);
		}
	}
}