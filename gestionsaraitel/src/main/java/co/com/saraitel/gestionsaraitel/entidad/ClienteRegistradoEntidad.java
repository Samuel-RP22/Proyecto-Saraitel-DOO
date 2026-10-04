package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoEntidad {

	private UUID id;
	private ClienteEntidad cliente;
	private boolean clienteNaturalDefecto;

	public ClienteRegistradoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteEntidad());
		setClienteNaturalDefecto(true);
	}

	public ClienteRegistradoEntidad(final UUID id, final ClienteEntidad cliente, 
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

	public ClienteEntidad getCliente() {
		return cliente;
	}

	public void setCliente(final ClienteEntidad cliente) {
		this.cliente = UtilObjeto.esNulo(cliente) ? 
				new ClienteEntidad() : cliente;
	}

	public boolean getClienteNaturalDefecto() {
		return clienteNaturalDefecto;
	}

	public void setClienteNaturalDefecto(final boolean clienteNaturalDefecto) {
		this.clienteNaturalDefecto = clienteNaturalDefecto;
	}
}