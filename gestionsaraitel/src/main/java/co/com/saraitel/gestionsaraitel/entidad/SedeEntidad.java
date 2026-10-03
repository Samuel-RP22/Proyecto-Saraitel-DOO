package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class SedeEntidad {

	private UUID id;
	private String nombre;
	private CiudadEntidad ciudad;
	private String nit;
	private String direccion;
	private boolean esactiva;

	public SedeEntidad() {
		super();
	}

	private SedeEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setNombre(builder.nombre);
		setCiudad(builder.ciudad);
		setNit(builder.nit);
		setDireccion(builder.direccion);
		setEsActiva(builder.esactiva);
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

	public CiudadEntidad getCiudad() {
		return ciudad;
	}

	public void setCiudad(final CiudadEntidad ciudad) {
		this.ciudad = ciudad;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(final String nit) {
		this.nit = nit;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}

	public boolean isEsActiva() {
		return esactiva;
	}

	public void setEsActiva(final boolean esactiva) {
		this.esactiva = esactiva;
	}

	public static class Builder {

		private UUID id;
		private String nombre;
		private CiudadEntidad ciudad;
		private String nit;
		private String direccion;
		private boolean esactiva;

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

		public Builder ciudad(final CiudadEntidad ciudad) {
			this.ciudad = ciudad;
			return this;
		}

		public Builder nit(final String nit) {
			this.nit = nit;
			return this;
		}

		public Builder direccion(final String direccion) {
			this.direccion = direccion;
			return this;
		}

		public Builder esactiva(final boolean esactiva) {
			this.esactiva = esactiva;
			return this;
		}

		public SedeEntidad build() {
			return new SedeEntidad(this);
		}
	}
}