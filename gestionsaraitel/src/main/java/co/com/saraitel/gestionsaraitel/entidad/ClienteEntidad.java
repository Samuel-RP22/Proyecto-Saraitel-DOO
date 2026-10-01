package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class ClienteEntidad {

	private UUID id;
	private Boolean clientepordefecto;

	public ClienteEntidad() {
		super();
	}

	public ClienteEntidad(final UUID id, final Boolean clientepordefecto) {
		super();
		setId(id);
		setClientepordefecto(clientepordefecto);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public Boolean getClientepordefecto() {
		return clientepordefecto;
	}

	public void setClientepordefecto(final Boolean clientepordefecto) {
		this.clientepordefecto = clientepordefecto;
	}
}