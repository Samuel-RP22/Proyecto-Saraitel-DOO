package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class ClienteRegistradoEntidad {

	private UUID id;
	private ClienteEntidad cliente;

	public ClienteRegistradoEntidad() {
		super();
	}

	public ClienteRegistradoEntidad(final UUID id, final ClienteEntidad cliente) {
		super();
		setId(id);
		setCliente(cliente);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public ClienteEntidad getCliente() {
		return cliente;
	}

	public void setCliente(final ClienteEntidad cliente) {
		this.cliente = cliente;
	}
}