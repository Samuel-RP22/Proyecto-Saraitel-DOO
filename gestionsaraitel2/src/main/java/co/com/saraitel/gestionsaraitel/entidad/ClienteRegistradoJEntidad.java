package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilBoolean;
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
		this(new Builder());
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

	public static final class Builder {

		private UUID id;
		private ClienteRegistradoEntidad clienteRegistrado;
		private PrefijoEntidad prefijo;
		private String telefono;
		private String nit;
		private String razonSocial;
		private String correo;
		private Boolean correoConfirmado;
		private Boolean telefonoConfirmado;

		public Builder() {
			this.id = UtilUUID.obtenerUUIDDefecto();
			this.clienteRegistrado = new ClienteRegistradoEntidad();
			this.prefijo = new PrefijoEntidad();
			this.telefono = UtilTexto.VACIA;
			this.nit = UtilTexto.VACIA;
			this.razonSocial = UtilTexto.VACIA;
			this.correo = UtilTexto.VACIA;
			this.correoConfirmado = false;
			this.telefonoConfirmado = false;
		}

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

		public Builder correoConfirmado(final Boolean correoConfirmado) {
			this.correoConfirmado = correoConfirmado;
			return this;
		}

		public Builder telefonoConfirmado(final Boolean telefonoConfirmado) {
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
		this.clienteRegistrado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(clienteRegistrado,
				new ClienteRegistradoEntidad());
	}

	public PrefijoEntidad getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(final PrefijoEntidad prefijo) {
		this.prefijo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(prefijo, new PrefijoEntidad());
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

	public void setCorreoConfirmado(final Boolean correoConfirmado) {
		this.correoConfirmado = UtilBoolean.obtenerValorDefectoFalso(correoConfirmado);
	}

	public boolean getTelefonoConfirmado() {
		return telefonoConfirmado;
	}

	public void setTelefonoConfirmado(final Boolean telefonoConfirmado) {
		this.telefonoConfirmado = UtilBoolean.obtenerValorDefectoFalso(telefonoConfirmado);
	}
}