package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteNoRegistradoEntidad {

	private UUID id;
	private ClienteEntidad cliente;
	private String nombre;
	private String apellido;
	private String numeroDocumento;

	public ClienteNoRegistradoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteEntidad());
		setNombre(UtilTexto.VACIA);
		setApellido(UtilTexto.VACIA);
		setNumeroDocumento(UtilTexto.VACIA);
	}

	public ClienteNoRegistradoEntidad(final UUID id, final ClienteEntidad cliente, final String nombre,
			final String apellido, final String numeroDocumento) {
		setId(id);
		setCliente(cliente);
		setNombre(nombre);
		setApellido(apellido);
		setNumeroDocumento(numeroDocumento);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ClienteEntidad getCliente() {
		return cliente;
	}

	public void setCliente(final ClienteEntidad cliente) {
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteEntidad());
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

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(final String numeroDocumento) {
		this.numeroDocumento = UtilTexto.quitarEspaciosEnBlanco(numeroDocumento);
	}
}
