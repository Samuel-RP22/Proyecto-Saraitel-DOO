package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoJDTO {

	private UUID id;
	private ClienteRegistradoDTO clienteRegistrado;
	private PrefijoDTO prefijo;
	private String telefono;
	private String nit;
	private String razonSocial;
	private String correo;
	private boolean correoConfirmado;
	private boolean telefonoConfirmado;

	public ClienteRegistradoJDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setClienteRegistrado(new ClienteRegistradoDTO());
		setPrefijo(new PrefijoDTO());
		setTelefono(UtilTexto.VACIA);
		setNit(UtilTexto.VACIA);
		setRazonSocial(UtilTexto.VACIA);
		setCorreo(UtilTexto.VACIA);
		setCorreoConfirmado(false);
		setTelefonoConfirmado(false);
	}

	private ClienteRegistradoJDTO(final Builder builder) {
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

	public static Builder crear() {
		return new Builder();
	}

	public static final class Builder {

		private UUID id = UtilUUID.obtenerUUIDDefecto();
		private ClienteRegistradoDTO clienteRegistrado = new ClienteRegistradoDTO();
		private PrefijoDTO prefijo = new PrefijoDTO();
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

		public Builder clienteRegistrado(final ClienteRegistradoDTO clienteRegistrado) {
			this.clienteRegistrado = clienteRegistrado;
			return this;
		}

		public Builder prefijo(final PrefijoDTO prefijo) {
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

		public ClienteRegistradoJDTO construir() {
			return new ClienteRegistradoJDTO(this);
		}
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ClienteRegistradoDTO getClienteRegistrado() {
		return clienteRegistrado;
	}

	public void setClienteRegistrado(final ClienteRegistradoDTO clienteRegistrado) {
		this.clienteRegistrado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(clienteRegistrado, new ClienteRegistradoDTO());
	}

	public PrefijoDTO getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(final PrefijoDTO prefijo) {
		this.prefijo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(prefijo, new PrefijoDTO());
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