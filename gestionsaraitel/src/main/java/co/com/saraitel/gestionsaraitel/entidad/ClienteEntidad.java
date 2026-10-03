package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteEntidad {

	private UUID id;
	private boolean clientepordefecto;

	public ClienteEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setClientepordefecto(true);
	}

	public ClienteEntidad(final UUID id, final boolean clientepordefecto) {
		setId(id);
		setClientepordefecto(clientepordefecto);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public boolean getClientepordefecto() {
		return clientepordefecto;
	}

	public void setClientepordefecto(final boolean clientepordefecto) {
		this.clientepordefecto = clientepordefecto;
	}
}