package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class CiudadEntidad {

	private UUID id;
	private String nombre;
	private DepartamentoEntidad departamento;

	public CiudadEntidad() {
		super();
	}

	private CiudadEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setNombre(builder.nombre);
		setDepartamento(builder.departamento);
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

	public DepartamentoEntidad getDepartamento() {
		return departamento;
	}

	public void setDepartamento(final DepartamentoEntidad departamento) {
		this.departamento = departamento;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private DepartamentoEntidad departamento;

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

		public Builder departamento(final DepartamentoEntidad departamento) {
			this.departamento = departamento;
			return this;
		}

		public CiudadEntidad build() {
			return new CiudadEntidad(this);
		}
	}
}