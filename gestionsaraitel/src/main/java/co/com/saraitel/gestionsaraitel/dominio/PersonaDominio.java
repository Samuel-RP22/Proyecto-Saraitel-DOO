package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilBoolean;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PersonaDominio {

	private final UUID id;
	private final TipoDocumentoDominio tipoDocumento;
	private final PrefijoDominio prefijo;
	private final String numeroDocumento;
	private final String telefono;
	private final String nombre;
	private final String apellido;
	private final String correo;
	private final boolean telefonoConfirmado;
	private final boolean correoConfirmado;

	private PersonaDominio(final Builder builder) {
		this.id = UtilUUID.obtenerValorDefecto(builder.id);
		this.tipoDocumento = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(builder.tipoDocumento,
				TipoDocumentoDominio.obtenerValorDefecto());
		this.prefijo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(builder.prefijo,
				PrefijoDominio.obtenerValorDefecto());
		this.numeroDocumento = UtilTexto.quitarEspaciosEnBlanco(builder.numeroDocumento);
		this.telefono = UtilTexto.quitarEspaciosEnBlanco(builder.telefono);
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(builder.nombre);
		this.apellido = UtilTexto.quitarEspaciosEnBlanco(builder.apellido);
		this.correo = UtilTexto.quitarEspaciosEnBlanco(builder.correo);
		this.telefonoConfirmado = UtilBoolean.obtenerValorDefectoFalso(builder.telefonoConfirmado);
		this.correoConfirmado = UtilBoolean.obtenerValorDefectoFalso(builder.correoConfirmado);
	}

	public static PersonaDominio obtenerValorDefecto() {
		return new Builder().construir();
	}

	public static final class Builder {

		private UUID id;
		private TipoDocumentoDominio tipoDocumento;
		private PrefijoDominio prefijo;
		private String numeroDocumento;
		private String telefono;
		private String nombre;
		private String apellido;
		private String correo;
		private Boolean telefonoConfirmado;
		private Boolean correoConfirmado;

		public Builder() {
			this.id = UtilUUID.obtenerUUIDDefecto();
			this.tipoDocumento = TipoDocumentoDominio.obtenerValorDefecto();
			this.prefijo = PrefijoDominio.obtenerValorDefecto();
			this.numeroDocumento = UtilTexto.VACIA;
			this.telefono = UtilTexto.VACIA;
			this.nombre = UtilTexto.VACIA;
			this.apellido = UtilTexto.VACIA;
			this.correo = UtilTexto.VACIA;
			this.telefonoConfirmado = false;
			this.correoConfirmado = false;
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder tipoDocumento(final TipoDocumentoDominio tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
			return this;
		}

		public Builder prefijo(final PrefijoDominio prefijo) {
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

		public PersonaDominio construir() {
			return new PersonaDominio(this);
		}
	}

	public UUID getId() {
		return id;
	}

	public TipoDocumentoDominio getTipoDocumento() {
		return tipoDocumento;
	}

	public PrefijoDominio getPrefijo() {
		return prefijo;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public boolean getTelefonoConfirmado() {
		return telefonoConfirmado;
	}

	public boolean getCorreoConfirmado() {
		return correoConfirmado;
	}
}