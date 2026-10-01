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
	private Boolean correoconfirmado;
	private Boolean telefonoconfirmado;

	public ClienteRegistradoJEntidad() {
		super();
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
}