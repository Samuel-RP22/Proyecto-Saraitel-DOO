package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProductoDominio {

	private UUID id;
	private MarcaDominio marca;
	private CategoriaDominio categoria;
	private String modelo;
	private String nombre;
	private String descripcion;


	private ProductoDominio(Builder builder) {
		this.id = builder.id;
		this.marca = builder.marca;
		this.categoria = builder.categoria;
		this.modelo = builder.modelo;
		this.nombre = builder.nombre;
		this.descripcion = builder.descripcion;
	}

	public UUID getId() {
		return id;
	}
	
	public MarcaDominio getMarca() {
		return marca;
	}
	
	public CategoriaDominio getCategoria() {
		return categoria;
	}
	
	public String getModelo() {
		return modelo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static class Builder {
		private UUID id;
		private MarcaDominio marca;
		private CategoriaDominio categoria;
		private String modelo;
		private String nombre;
		private String descripcion;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			marca= new MarcaDominio.Builder().build();
			categoria= new CategoriaDominio.Builder().build();
			modelo= UtilTexto.VACIA;
			nombre = UtilTexto.VACIA;
			descripcion = UtilTexto.VACIA;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder marca(MarcaDominio marca) {
			this.marca = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(marca, new MarcaDominio.Builder().build());
			return this;
		}
		
		public Builder cateogira(CategoriaDominio categoria) {
			this.categoria = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(categoria, new CategoriaDominio.Builder().build());
			return this;
		}
		
		public Builder modelo(String modelo) {
			this.modelo = UtilTexto.quitarEspaciosEnBlanco(modelo);
			return this;
		}
		
		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
			return this;
		}

		public Builder descripcion(String descripcion) {
			this.descripcion = UtilTexto.quitarEspaciosEnBlanco(descripcion);
			return this;
		}

		public ProductoDominio build() {
			return new ProductoDominio(this);
		}
	}
}