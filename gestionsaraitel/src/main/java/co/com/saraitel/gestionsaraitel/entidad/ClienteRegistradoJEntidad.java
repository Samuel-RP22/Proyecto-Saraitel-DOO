package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

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
		setId(UtilUUID.obtenerUUIDDefecto());
		setClienteRegistrado(new ClienteRegistradoEntidad());
		setPrefijo(new PrefijoEntidad());
		setTelefono(UtilTexto.VACIA);
		setNit(UtilTexto.VACIA);
		setRazonSocial(UtilTexto.VACIA);
		setCorreo(UtilTexto.VACIA);
		setCorreoConfirmado(true);
		setTelefonoConfirmado(true);
	}

	public ClienteRegistradoJEntidad(final UUID id, final ClienteRegistradoEntidad clienteregistrado,
			final PrefijoEntidad prefijo, final String telefono, final String nit, final String razonsocial,
			final String correo, final boolean correoconfirmado, final boolean telefonoconfirmado) {
		setId(id);
		setClienteRegistrado(clienteregistrado);
		setPrefijo(prefijo);
		setTelefono(telefono);
		setNit(nit);
		setRazonSocial(razonsocial);
		setCorreo(correo);
		setCorreoConfirmado(correoconfirmado);
		setTelefonoConfirmado(telefonoconfirmado);
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
		this.clienteregistrado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(clienteregistrado, new ClienteRegistradoEntidad());
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
		return razonsocial;
	}

	public void setRazonSocial(final String razonsocial) {
		this.razonsocial = UtilTexto.quitarEspaciosEnBlanco(razonsocial);
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(final String correo) {
		this.correo = UtilTexto.quitarEspaciosEnBlanco(correo);
	}

	public Boolean getCorreoConfirmado() {
		return correoconfirmado;
	}

	public void setCorreoConfirmado(final boolean correoconfirmado) {
		this.correoconfirmado = correoconfirmado;
	}

	public Boolean getTelefonoConfirmado() {
		return telefonoconfirmado;
	}

	public void setTelefonoConfirmado(final boolean telefonoconfirmado) {
		this.telefonoconfirmado = telefonoconfirmado;
	}

}