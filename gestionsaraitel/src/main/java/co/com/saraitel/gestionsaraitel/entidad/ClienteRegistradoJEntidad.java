package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoJEntidad {

	private UUID id;
	private ClienteRegistradoEntidad clienteRegistrado;
	private PrefijoEntidad prefijo;
	private String telefono;
	private String nit;
	private String razonSocial;
	private String correo;
	private boolean correoConfirmado;
	private boolean telefonoConfirmado;

	public ClienteRegistradoJEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setClienteRegistrado(new ClienteRegistradoEntidad());
		setPrefijo(new PrefijoEntidad());
		setTelefono(UtilTexto.VACIA);
		setNit(UtilTexto.VACIA);
		setRazonSocial(UtilTexto.VACIA);
		setCorreo(UtilTexto.VACIA);
		setCorreoConfirmado(false);
		setTelefonoConfirmado(false);
	}

	private ClienteRegistradoJEntidad(final Builder builder) {
		setId(builder.id);
		setClienteRegistrado(builder.clienteRegistrado);
		setPrefijo(builder.prefijo);
		setTelefono(builder.telefono);
		setNit(builder.nit);
		setRazonSocial(builder.razonSocial);
		setCorreo(builder.correo);
		setCorreoConfirmado(builder.correoConfirmado);
		setTelefonoConfirmado(builder.telefonoConfirmado);
	}

	public static Builder build() {
		return new Builder();
	}

	public static final class Builder {

		private UUID id = UtilUUID.obtenerUUIDDefecto();
		private ClienteRegistradoEntidad clienteRegistrado = new ClienteRegistradoEntidad();
		private PrefijoEntidad prefijo = new PrefijoEntidad();
		private String telefono = UtilTexto.VACIA;
		private String nit = UtilTexto.VACIA;
		private String razonSocial = UtilTexto.VACIA;
		private String correo = UtilTexto.VACIA;
		private boolean correoConfirmado = false;
		private boolean telefonoConfirmado = false;

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder clienteRegistrado(final ClienteRegistradoEntidad clienteRegistrado) {
			this.clienteRegistrado = clienteRegistrado;
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

		public Builder razonSocial(final String razonSocial) {
			this.razonSocial = razonSocial;
			return this;
		}

		public Builder correo(final String correo) {
			this.correo = correo;
			return this;
		}

		public Builder correoConfirmado(final boolean correoConfirmado) {
			this.correoConfirmado = correoConfirmado;
			return this;
		}

		public Builder telefonoConfirmado(final boolean telefonoConfirmado) {
			this.telefonoConfirmado = telefonoConfirmado;
			return this;
		}

		public ClienteRegistradoJEntidad construir() {
			return new ClienteRegistradoJEntidad(this);
		}
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ClienteRegistradoEntidad getClienteRegistrado() {
		return clienteRegistrado;
	}

	public void setClienteRegistrado(final ClienteRegistradoEntidad clienteRegistrado) {
		this.clienteRegistrado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(clienteRegistrado, new ClienteRegistradoEntidad());
	}

	public PrefijoEntidad getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(final PrefijoEntidad prefijo) {
		this.prefijo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(prefijo, new PrefijoEntidad());
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(final String telefono) {
		this.telefono = UtilTexto.quitarEspaciosEnBlanco(telefono);
	}

	public String getNit() {
		return nit;
	}

	public void setNit(final String nit) {
		this.nit = UtilTexto.quitarEspaciosEnBlanco(nit);
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(final String razonSocial) {
		this.razonSocial = UtilTexto.quitarEspaciosEnBlanco(razonSocial);
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(final String correo) {
		this.correo = UtilTexto.quitarEspaciosEnBlanco(correo);
	}

	public boolean getCorreoConfirmado() {
		return correoConfirmado;
	}

	public void setCorreoConfirmado(final boolean correoConfirmado) {
		this.correoConfirmado = correoConfirmado;
	}

	public boolean getTelefonoConfirmado() {
		return telefonoConfirmado;
	}

	public void setTelefonoConfirmado(final boolean telefonoConfirmado) {
		this.telefonoConfirmado = telefonoConfirmado;
	}
}