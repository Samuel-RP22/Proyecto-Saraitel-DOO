package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class CategoriaEntidad {

	private UUID id;
	private String nombre;
	private CategoriaEntidad categoriapadre;
	private int nivel;

	public CategoriaEntidad() {
		super();
	}

	private CategoriaEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setNombre(builder.nombre);
		setCategoriapadre(builder.categoriapadre);
		setNivel(builder.nivel);
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public CategoriaEntidad getCategoriapadre() {
		return categoriapadre;
	}

	public void setCategoriapadre(final CategoriaEntidad categoriapadre) {
		this.categoriapadre = categoriapadre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private CategoriaEntidad categoriapadre;
		private int nivel;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder nombre(final String nombre) {
			this.nombre = nombre;
			return this;
		}

		public Builder categoriapadre(final CategoriaEntidad categoriapadre) {
			this.categoriapadre = categoriapadre;
			return this;
		}

		public Builder nivel(final int nivel) {
			this.nivel = nivel;
			return this;
		}

		public CategoriaEntidad build() {
			return new CategoriaEntidad(this);
		}
	}
}