package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoEntidad {

	private UUID id;
	private ClienteEntidad cliente;
	private boolean clienteRegistradoNatural;

	public ClienteRegistradoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteEntidad());
		setClienteRegistradoNatural(true);
	}

	public ClienteRegistradoEntidad(final UUID id, final ClienteEntidad cliente, 
			final boolean clienteRegistradoNatural) {
		setId(id);
		setCliente(cliente);
		setClienteRegistradoNatural(clienteRegistradoNatural);
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

	public boolean getClienteRegistradoNatural() {
		return clienteRegistradoNatural;
	}

	public void setClienteRegistradoNatural(final boolean clienteRegistradoNatural) {
		this.clienteRegistradoNatural = clienteRegistradoNatural;
	}
}