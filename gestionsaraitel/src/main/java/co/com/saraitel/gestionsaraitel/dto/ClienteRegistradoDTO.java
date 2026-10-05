package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoDTO {

	private UUID id;
	private ClienteDTO cliente;
	private boolean clienteNaturalDefecto;

	public ClienteRegistradoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteDTO());
		setClienteNaturalDefecto(true);
	}

	public ClienteRegistradoDTO(final UUID id, final ClienteDTO cliente, 
			final boolean clienteNaturalDefecto) {
		setId(id);
		setCliente(cliente);
		setClienteNaturalDefecto(clienteNaturalDefecto);
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
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(cliente, new ClienteDTO());
	}

	public boolean getClienteNaturalDefecto() {
		return clienteNaturalDefecto;
	}

	public void setClienteNaturalDefecto(final boolean clienteNaturalDefecto) {
		this.clienteNaturalDefecto = clienteNaturalDefecto;
	}
}