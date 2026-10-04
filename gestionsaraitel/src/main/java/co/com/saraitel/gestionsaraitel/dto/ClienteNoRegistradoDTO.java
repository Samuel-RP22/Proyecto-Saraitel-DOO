package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteNoRegistradoDTO {

	private UUID id;
	private ClienteDTO cliente;

	public ClienteNoRegistradoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteDTO());
	}

	public ClienteNoRegistradoDTO(final UUID id, final ClienteDTO cliente) {
		setId(id);
		setCliente(cliente);
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
		this.cliente = UtilObjeto.esNulo(cliente) ? new ClienteDTO() : cliente;
	}
}