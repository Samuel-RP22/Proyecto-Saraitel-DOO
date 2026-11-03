package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteNoRegistradoDTO {

	private UUID id;
	private ClienteDTO cliente;
	private String nombre;
	private String apellido;
	private String numeroDocumento;

	public ClienteNoRegistradoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteDTO());
		setNombre(UtilTexto.VACIA);
		setApellido(UtilTexto.VACIA);
		setNumeroDocumento(UtilTexto.VACIA);
	}

	public ClienteNoRegistradoDTO(final UUID id, final ClienteDTO cliente, final String nombre,
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

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(final ClienteDTO cliente) {
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteDTO());
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
