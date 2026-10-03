package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClientNoRegistradoEntidad {

	private UUID id;
	private ClienteEntidad cliente;

	public ClientNoRegistradoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteEntidad());
	}

	public ClientNoRegistradoEntidad(final UUID id, final ClienteEntidad cliente) {
		setId(id);
		setCliente(cliente);
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
}