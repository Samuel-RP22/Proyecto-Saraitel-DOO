package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class ClienteRegistradoJEntidad {

	private UUID id;
	private ClienteRegistradoEntidad clienteregistrado;
	private PrefijoEntidad prefijo;
	private String telefono;
	private String nit;
	private String razonsocial;
	private String correo;
	private boolean correoconfirmado;
	private boolean telefonoconfirmado;

	public ClienteRegistradoJEntidad() {
		super();
	}

	private ClienteRegistradoJEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setClienteRegistrado(builder.clienteregistrado);
		setPrefijo(builder.prefijo);
		setTelefono(builder.telefono);
		setNit(builder.nit);
		setRazonSocial(builder.razonsocial);
		setCorreo(builder.correo);
		setCorreoConfirmado(builder.correoconfirmado);
		setTelefonoConfirmado(builder.telefonoconfirmado);
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

	public ClienteRegistradoEntidad getClienteRegistrado() {
		return clienteregistrado;
	}

	public void setClienteRegistrado(final ClienteRegistradoEntidad clienteregistrado) {
		this.clienteregistrado = clienteregistrado;
	}

	public PrefijoEntidad getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(final PrefijoEntidad prefijo) {
		this.prefijo = prefijo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(final String nit) {
		this.nit = nit;
	}

	public String getRazonSocial() {
		return razonsocial;
	}

	public void setRazonSocial(final String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(final String correo) {
		this.correo = correo;
	}

	public Boolean isCorreoConfirmado() {
		return correoconfirmado;
	}

	public void setCorreoConfirmado(final boolean correoconfirmado) {
		this.correoconfirmado = correoconfirmado;
	}

	public Boolean isTelefonoConfirmado() {
		return telefonoconfirmado;
	}

	public void setTelefonoConfirmado(final boolean telefonoconfirmado) {
		this.telefonoconfirmado = telefonoconfirmado;
	}

	public static class Builder {

		private UUID id;
		private ClienteRegistradoEntidad clienteregistrado;
		private PrefijoEntidad prefijo;
		private String telefono;
		private String nit;
		private String razonsocial;
		private String correo;
		private boolean correoconfirmado;
		private boolean telefonoconfirmado;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder clienteregistrado(final ClienteRegistradoEntidad clienteregistrado) {
			this.clienteregistrado = clienteregistrado;
			return this;
		}

		public Builder prefijo(final PrefijoEntidad prefijo) {
			this.prefijo = prefijo;
			return this;
		}

		public Builder telefono(final String telefono) {
			this.telefono = telefono;
			return this;
		}

		public Builder nit(final String nit) {
			this.nit = nit;
			return this;
		}

		public Builder razonsocial(final String razonsocial) {
			this.razonsocial = razonsocial;
			return this;
		}

		public Builder correo(final String correo) {
			this.correo = correo;
			return this;
		}

		public Builder correoconfirmado(final boolean correoconfirmado) {
			this.correoconfirmado = correoconfirmado; 
			return this;
		}

		public Builder telefonoconfirmado(final boolean telefonoconfirmado) {
			this.telefonoconfirmado = telefonoconfirmado;
			return this;
		}

		public ClienteRegistradoJEntidad build() {
			return new ClienteRegistradoJEntidad(this);
		}
	}
}