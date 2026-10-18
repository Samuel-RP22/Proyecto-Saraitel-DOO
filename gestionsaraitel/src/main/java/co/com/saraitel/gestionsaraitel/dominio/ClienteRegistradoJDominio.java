package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoJDominio {

	private final UUID id;
	private final ClienteRegistradoDominio clienteRegistrado;
	private final PrefijoDominio prefijo;
	private final String telefono;
	private final String nit;
	private final String razonSocial;
	private final String correo;
	private final boolean correoConfirmado;
	private final boolean telefonoConfirmado;

	private ClienteRegistradoJDominio(final Builder builder) {
		this.id = UtilUUID.obtenerValorDefecto(builder.id);
		this.clienteRegistrado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(builder.clienteRegistrado,
				ClienteRegistradoDominio.obtenerValorDefecto());
		this.prefijo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(builder.prefijo,
				PrefijoDominio.obtenerValorDefecto());
		this.telefono = UtilTexto.quitarEspaciosEnBlanco(builder.telefono);
		this.nit = UtilTexto.quitarEspaciosEnBlanco(builder.nit);
		this.razonSocial = UtilTexto.quitarEspaciosEnBlanco(builder.razonSocial);
		this.correo = UtilTexto.quitarEspaciosEnBlanco(builder.correo);
		this.correoConfirmado = builder.correoConfirmado;
		this.telefonoConfirmado = builder.telefonoConfirmado;
	}

	public static final class Builder {

		private UUID id;
		private ClienteRegistradoDominio clienteRegistrado;
		private PrefijoDominio prefijo;
		private String telefono;
		private String nit;
		private String razonSocial;
		private String correo;
		private boolean correoConfirmado;
		private boolean telefonoConfirmado;

		public Builder() {
			this.id = UtilUUID.obtenerUUIDDefecto();
			this.clienteRegistrado = ClienteRegistradoDominio.obtenerValorDefecto();
			this.prefijo = PrefijoDominio.obtenerValorDefecto();
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

		public Builder clienteRegistrado(final ClienteRegistradoDominio clienteRegistrado) {
			this.clienteRegistrado = clienteRegistrado;
			return this;
		}

		public Builder prefijo(final PrefijoDominio prefijo) {
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

		public ClienteRegistradoJDominio construir() {
			return new ClienteRegistradoJDominio(this);
		}
	}

	public UUID getId() {
		return id;
	}

	public ClienteRegistradoDominio getClienteRegistrado() {
		return clienteRegistrado;
	}

	public PrefijoDominio getPrefijo() {
		return prefijo;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getNit() {
		return nit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getCorreo() {
		return correo;
	}

	public boolean getCorreoConfirmado() {
		return correoConfirmado;
	}

	public boolean getTelefonoConfirmado() {
		return telefonoConfirmado;
	}
}