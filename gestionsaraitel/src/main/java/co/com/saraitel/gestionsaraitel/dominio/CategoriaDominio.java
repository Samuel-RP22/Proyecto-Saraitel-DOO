package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class CategoriaDominio {
	
	private UUID id;
	private String nombre;
	private UUID categoriaPadre;
	private int nivel;
	
	
	private CategoriaDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.categoriaPadre = builder.categoriaPadre;
		this.nivel = builder.nivel;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public UUID getCategoriaPadre() {
		return categoriaPadre;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public static class Builder {
		private UUID id;
		private String nombre;
		private UUID categoriaPadre;
		private int nivel;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIA;
			categoriaPadre = null;
			nivel = 1;
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
			return this;
		}
		
		public Builder categoriaPadre(UUID categoriaPadre) {
			this.categoriaPadre = categoriaPadre;
			return this;
		}
		

		public CategoriaDominio build() {
			return new CategoriaDominio(this);
		}
	}
}

