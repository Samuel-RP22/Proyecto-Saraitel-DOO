package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class MarcaDominio {
	
	private UUID id;
	private String nombre;
	private boolean esActivo;
	
	
	private MarcaDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.esActivo = builder.esActivo;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean getEsActivo() {
		return esActivo;
	}
	
	public static class Builder {
		private UUID id;
		private String nombre;
		private boolean esActivo;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIA;
			esActivo = true;
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
			return this;
		}
		
		public Builder esActivo(boolean esActivo) {
			this.esActivo = esActivo;
			return this;
		}
		
		public MarcaDominio build() {
			return new MarcaDominio(this);
		}
	}
}

