package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PersonaDominio {

	private UUID id;
	private TipoDocumentoDominio tipoDocumento;
	private PrefijoDominio prefijo;
	private String numeroDocumento;
	private String telefono;
	private String nombre;
	private String apellido;
	private String correo;
	private boolean telefonoConfirmado;
	private boolean correoConfirmado;
	
	private PersonaDominio(Builder builder) {
		this.id = builder.id;
		this.tipoDocumento = builder.tipoDocumento;
		this.prefijo = builder.prefijo;
		this.numeroDocumento = builder.numeroDocumento;
		this.telefono = builder.telefono;
		this.nombre = builder.nombre;
		this.apellido = builder.apellido;
		this.correo = builder.correo;
		this.telefonoConfirmado = builder.telefonoConfirmado;
		this.correoConfirmado = builder.correoConfirmado;
	}

	public UUID getId() {
		return id;
	}

	public TipoDocumentoDominio getTipoDocumento() {
		return tipoDocumento;
	}
	
	public PrefijoDominio getPrefijo() {
		return prefijo;
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
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
		private TipoDocumentoDominio tipoDocumento;
		private PrefijoDominio prefijo;
		private String numeroDocumento;
		private String telefono;
		private String nombre;
		private String apellido;
		private String correo;
		private boolean telefonoConfirmado;
		private boolean correoConfirmado;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			tipoDocumento = new TipoDocumentoDominio.Builder().build();
			prefijo = new PrefijoDominio.Builder().build();
			numeroDocumento = UtilTexto.VACIA;
			telefono = UtilTexto.VACIA;
			nombre = UtilTexto.VACIA;
			apellido = UtilTexto.VACIA;
			correo = UtilTexto.VACIA;
			telefonoConfirmado = false;
			correoConfirmado = false; 
		
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder tipoDocumento(TipoDocumentoDominio tipoDocumento) {
			this.tipoDocumento = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoDocumento, new TipoDocumentoDominio.Builder().build()) ;
			return this;
		}
		
		public Builder prefijo(PrefijoDominio prefijo) {
			this.prefijo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(prefijo, new PrefijoDominio.Builder().build()) ;
			return this;
		}
		
		public Builder numeroDocumento(String numeroDocumento) {
			this.numeroDocumento = UtilTexto.quitarEspaciosEnBlanco(numeroDocumento) ;
			return this;
		}
		
		public Builder telefono(String telefono) {
			this.telefono = UtilTexto.quitarEspaciosEnBlanco(telefono) ;
			return this;
		}
		
		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre) ;
			return this;
		}
		
		public Builder apellido(String apellido) {
			this.apellido = UtilTexto.quitarEspaciosEnBlanco(apellido) ;
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
		

		public PersonaDominio build() {
			return new PersonaDominio(this);
		}
	}
}