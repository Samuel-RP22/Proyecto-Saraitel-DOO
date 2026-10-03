package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class DepartamentoEntidad {

	private UUID id;
	private String nombre;
	private PaisEntidad pais;

	public DepartamentoEntidad() {
		super();
	}

	private DepartamentoEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setNombre(builder.nombre);
		setPais(builder.pais);
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

	public PaisEntidad getPais() {
		return pais;
	}

	public void setPais(final PaisEntidad pais) {
		this.pais = pais;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private PaisEntidad pais;

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

		public Builder pais(final PaisEntidad pais) {
			this.pais = pais;
			return this;
		}

		public DepartamentoEntidad build() {
			return new DepartamentoEntidad(this);
		}
	}
}