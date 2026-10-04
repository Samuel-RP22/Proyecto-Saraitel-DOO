package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class EmpleadoDominio {

	private UUID id;
	private SedeDominio sede;
	private PersonaDomino persona;
	private boolean esActiva;
	
	private EmpleadoDominio(Builder builder) {
		this.id = builder.id;
		this.sede = builder.sede;
		this.persona = builder.persona;
		this.esActiva = builder.esActiva;

	}

	public UUID getId() {
		return id;
	}
	
	public SedeDominio getSede() {
		return sede;
	}
	public PersonaDomino getPersona() {
		return persona;
	}
	
	public boolean getEsActiva() {
		return esActiva;
	}
	

	
	public static class Builder {
		private UUID id;
		private SedeDominio sede;
		private PersonaDomino persona;
		
		private boolean esActiva;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIA;¨
			sede = ;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder ciudad(CiudadDominio ciudad) {
			this.ciudad = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(ciudad, new CiudadDominio.Builder().build());
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
			return this;
		}
		
		public Builder nit(String nit) {
			this.nit = UtilTexto.quitarEspaciosEnBlanco(nit);
			return this;
		}
		
		public Builder direccion(String direccion) {
			this.direccion = UtilTexto.quitarEspaciosEnBlanco(direccion);
			return this;
		}
		
		public Builder esActiva(boolean esActiva) {
			this.esActiva = esActiva;
			return this;
		}

		public EmpleadoDominio build() {
			return new EmpleadoDominio(this);
		}
	}
}