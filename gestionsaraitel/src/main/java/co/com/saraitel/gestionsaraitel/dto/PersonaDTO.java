package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PersonaDTO {

	private UUID id;
	private TipoDocumentoDTO tipoDocumento;
	private PrefijoDTO prefijo;
	private String numeroDocumento;
	private String telefono;
	private String nombre;
	private String apellido;
	private String correo;
	private boolean telefonoConfirmado;
	private boolean correoConfirmado;

	public PersonaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setTipoDocumento(new TipoDocumentoDTO());
		setPrefijo(new PrefijoDTO());
		setNumeroDocumento(UtilTexto.VACIA);
		setTelefono(UtilTexto.VACIA);
		setNombre(UtilTexto.VACIA);
		setApellido(UtilTexto.VACIA);
		setCorreo(UtilTexto.VACIA);
		setTelefonoConfirmado(false);
		setCorreoConfirmado(false);
	}

	private PersonaDTO(final Builder builder) {
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

	public static Builder build() {
		return new Builder();
	}

	public static final class Builder {

		private UUID id = UtilUUID.obtenerUUIDDefecto();
		private TipoDocumentoDTO tipoDocumento = new TipoDocumentoDTO();
		private PrefijoDTO prefijo = new PrefijoDTO();
		private String numeroDocumento = UtilTexto.VACIA;
		private String telefono = UtilTexto.VACIA;
		private String nombre = UtilTexto.VACIA;
		private String apellido = UtilTexto.VACIA;
		private String correo = UtilTexto.VACIA;
		private boolean telefonoConfirmado = false;
		private boolean correoConfirmado = false;

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder tipoDocumento(final TipoDocumentoDTO tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
			return this;
		}

		public Builder prefijo(final PrefijoDTO prefijo) {
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

		public Builder telefonoConfirmado(final boolean telefonoConfirmado) {
			this.telefonoConfirmado = telefonoConfirmado;
			return this;
		}

		public Builder correoConfirmado(final boolean correoConfirmado) {
			this.correoConfirmado = correoConfirmado;
			return this;
		}

		public PersonaDTO construir() {
			return new PersonaDTO(this);
		}
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public TipoDocumentoDTO getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(final TipoDocumentoDTO tipoDocumento) {
		this.tipoDocumento = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(tipoDocumento, new TipoDocumentoDTO());
	}

	public PrefijoDTO getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(final PrefijoDTO prefijo) {
		this.prefijo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(prefijo, new PrefijoDTO());
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(final String numeroDocumento) {
		this.numeroDocumento = UtilTexto.quitarEspaciosEnBlanco(numeroDocumento);
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(final String telefono) {
		this.telefono = UtilTexto.quitarEspaciosEnBlanco(telefono);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(final String apellido) {
		this.apellido = UtilTexto.quitarEspaciosEnBlanco(apellido);
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(final String correo) {
		this.correo = UtilTexto.quitarEspaciosEnBlanco(correo);
	}

	public boolean getTelefonoConfirmado() {
		return telefonoConfirmado;
	}

	public void setTelefonoConfirmado(final boolean telefonoConfirmado) {
		this.telefonoConfirmado = telefonoConfirmado;
	}

	public boolean getCorreoConfirmado() {
		return correoConfirmado;
	}

	public void setCorreoConfirmado(final boolean correoConfirmado) {
		this.correoConfirmado = correoConfirmado;
	}
}