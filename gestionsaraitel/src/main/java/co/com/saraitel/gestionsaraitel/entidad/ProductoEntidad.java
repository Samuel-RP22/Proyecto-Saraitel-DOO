package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class ProductoEntidad {

	private UUID id;
	private MarcaEntidad marca;
	private CategoriaEntidad categoria;
	private String modelo;
	private String nombre;
	private String descripcion;

	public ProductoEntidad() {
		super();
	}

	private ProductoEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setMarca(builder.marca);
		setCategoria(builder.categoria);
		setModelo(builder.modelo);
		setNombre(builder.nombre);
		setDescripcion(builder.descripcion);
	}

	public static Builder builder() {
		return new Builder();
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public MarcaEntidad getMarca() {
		return marca;
	}

	public void setMarca(final MarcaEntidad marca) {
		this.marca = marca;
	}

	public CategoriaEntidad getCategoria() {
		return categoria;
	}

	public void setCategoria(final CategoriaEntidad categoria) {
		this.categoria = categoria;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(final String modelo) {
		this.modelo = modelo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public static class Builder {

		private UUID id;
		private MarcaEntidad marca;
		private CategoriaEntidad categoria;
		private String modelo;
		private String nombre;
		private String descripcion;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder marca(final MarcaEntidad marca) {
			this.marca = marca;
			return this;
		}

		public Builder categoria(final CategoriaEntidad categoria) {
			this.categoria = categoria;
			return this;
		}

		public Builder modelo(final String modelo) {
			this.modelo = modelo;
			return this;
		}

		public Builder nombre(final String nombre) {
			this.nombre = nombre;
			return this;
		}

		public Builder descripcion(final String descripcion) {
			this.descripcion = descripcion;
			return this;
		}

		public ProductoEntidad build() {
			return new ProductoEntidad(this);
		}
	}
}