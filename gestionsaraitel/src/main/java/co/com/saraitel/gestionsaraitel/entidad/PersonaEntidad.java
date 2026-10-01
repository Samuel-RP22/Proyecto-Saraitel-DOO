package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class PersonaEntidad {

	private UUID id;
	private String tipoDocumento;
	private String prefijo;
	private String numeroDocumento;
	private String telefono;
	private String nombre;
	private String apellido;
	private String correo;
	private Boolean telefonoConfirmado;
	private Boolean correoConfirmado;

	public PersonaEntidad() {
		super();
	}

	private PersonaEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setTipoDocumento(builder.tipoDocumento);
		setPrefijo(builder.prefijo);
		setNumeroDocumento(builder.numeroDocumento);
		setTelefono(builder.telefono);
		setNombre(builder.nombre);
		setApellido(builder.apellido);
		setCorreo(builder.correo);
		setTelefonoConfirmado(builder.telefonoConfirmado);
		setCorreoConfirmado(builder.correoConfirmado);
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

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(final String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(final String prefijo) {
		this.prefijo = prefijo;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(final String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(final String correo) {
		this.correo = correo;
	}

	public boolean isTelefonoConfirmado() {
		return telefonoConfirmado;
	}

	public void setTelefonoConfirmado(final Boolean telefonoConfirmado) {
		this.telefonoConfirmado = telefonoConfirmado;
	}

	public boolean isCorreoConfirmado() {
		return correoConfirmado;
	}

	public void setCorreoConfirmado(final Boolean correoConfirmado) {
		this.correoConfirmado = correoConfirmado;
	}

	public static class Builder {

		private UUID id;
		private String tipoDocumento;
		private String prefijo;
		private String numeroDocumento;
		private String telefono;
		private String nombre;
		private String apellido;
		private String correo;
		private boolean telefonoConfirmado;
		private boolean correoConfirmado;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder tipoDocumento(final String tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
			return this;
		}

		public Builder prefijo(final String prefijo) {
			this.prefijo = prefijo;
			return this;
		}

		public Builder numeroDocumento(final String numeroDocumento) {
			this.numeroDocumento = numeroDocumento;
			return this;
		}

		public Builder telefono(final String telefono) {
			this.telefono = telefono;
			return this;
		}

		public Builder nombre(final String nombre) {
			this.nombre = nombre;
			return this;
		}

		public Builder apellido(final String apellido) {
			this.apellido = apellido;
			return this;
		}

		public Builder correo(final String correo) {
			this.correo = correo;
			return this;
		}

		public Builder telefonoConfirmado(final Boolean telefonoConfirmado) {
			this.telefonoConfirmado = telefonoConfirmado;
			return this;
		}

		public Builder correoConfirmado(final Boolean correoConfirmado) {
			this.correoConfirmado = correoConfirmado;
			return this;
		}

		public PersonaEntidad build() {
			return new PersonaEntidad(this);
		}
	}
}