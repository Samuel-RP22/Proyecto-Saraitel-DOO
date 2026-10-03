package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PersonaEntidad {

	private UUID id;
	private TipoDocumentoEntidad tipoDocumento;
	private PrefijoEntidad prefijo;
	private String numeroDocumento;
	private String telefono;
	private String nombre;
	private String apellido;
	private String correo;
	private boolean telefonoConfirmado;
	private boolean correoConfirmado;

	public PersonaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setTipoDocumento(new TipoDocumentoEntidad());
		setPrefijo(new PrefijoEntidad());
		setNumeroDocumento(UtilTexto.VACIA);
		setTelefono(UtilTexto.VACIA);
		setNombre(UtilTexto.VACIA);
		setApellido(UtilTexto.VACIA);
		setCorreo(UtilTexto.VACIA);
		setTelefonoConfirmado(false);
		setCorreoConfirmado(false);
	}

	public PersonaEntidad(final UUID id, final TipoDocumentoEntidad tipoDocumento, final PrefijoEntidad prefijo,
			final String numeroDocumento, final String telefono, final String nombre, final String apellido, 
			final String correo, final boolean telefonoConfirmado, final boolean correoConfirmado) {
		setId(id);
		setTipoDocumento(tipoDocumento);
		setPrefijo(prefijo);
		setNumeroDocumento(numeroDocumento);
		setTelefono(telefono);
		setNombre(nombre);
		setApellido(apellido);
		setCorreo(correo);
		setTelefonoConfirmado(telefonoConfirmado);
		setCorreoConfirmado(correoConfirmado);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public TipoDocumentoEntidad getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(final TipoDocumentoEntidad tipoDocumento) {
		this.tipoDocumento = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoDocumento, new TipoDocumentoEntidad());
	}

	public PrefijoEntidad getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(final PrefijoEntidad prefijo) {
		this.prefijo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(prefijo, new PrefijoEntidad());
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