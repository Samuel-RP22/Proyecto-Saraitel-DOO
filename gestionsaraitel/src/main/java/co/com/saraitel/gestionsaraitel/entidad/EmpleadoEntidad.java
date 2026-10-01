package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class EmpleadoEntidad {

	private UUID id;
	private String nombre;
	private String apellido;
	private TipoDocumentoEntidad tipodocumento;
	private PrefijoEntidad prefijo;
	private String numerodocumento;
	private String telefono;
	private String correo;
	private boolean telefonoconfirmado;
	private boolean correoconfirmado;

	public EmpleadoEntidad() {
		super();
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	public TipoDocumentoEntidad getTipoDocumento() {
		return tipodocumento;
	}

	public void setTipoDocumento(final TipoDocumentoEntidad tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public PrefijoEntidad getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(final PrefijoEntidad prefijo) {
		this.prefijo = prefijo;
	}

	public String getNumeroDocumento() {
		return numerodocumento;
	}

	public void setNumeroDocumento(final String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(final String correo) {
		this.correo = correo;
	}

	public boolean isTelefonoConfirmado() {
		return telefonoconfirmado;
	}

	public void setTelefonoConfirmado(final boolean telefonoconfirmado) {
		this.telefonoconfirmado = telefonoconfirmado;
	}

	public boolean isCorreoConfirmado() {
		return correoconfirmado;
	}

	public void setCorreoConfirmado(final boolean correoconfirmado) {
		this.correoconfirmado = correoconfirmado;
	}
}