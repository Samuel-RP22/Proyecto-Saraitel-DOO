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

	public ClienteRegistradoJEntidad(final UUID id, final ClienteRegistradoEntidad clienteRegistrado,
			final PrefijoEntidad prefijo, final String telefono, final String nit, final String razonSocial,
			final String correo, final boolean correoConfirmado, final boolean telefonoConfirmado) {
		setId(id);
		setClienteRegistrado(clienteRegistrado);
		setPrefijo(prefijo);
		setTelefono(telefono);
		setNit(nit);
		setRazonSocial(razonSocial);
		setCorreo(correo);
		setCorreoConfirmado(correoConfirmado);
		setTelefonoConfirmado(telefonoConfirmado);
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
		this.clienteRegistrado = UtilObjeto.esNulo(clienteRegistrado) ? 
				new ClienteRegistradoEntidad() : clienteRegistrado;
	}

	public PrefijoEntidad getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(final PrefijoEntidad prefijo) {
		this.prefijo = UtilObjeto.esNulo(prefijo) ? 
				new PrefijoEntidad() : prefijo;
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