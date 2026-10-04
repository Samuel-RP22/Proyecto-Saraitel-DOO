package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteEntidad {

	private UUID id;
	private boolean esClienteRegistrado;

	public ClienteEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setEsClienteRegistrado(true);
	}

	public ClienteEntidad(final UUID id, final boolean esClienteRegistrado) {
		setId(id);
		setEsClienteRegistrado(esClienteRegistrado);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public boolean getEsClienteRegistrado() {
		return esClienteRegistrado;
	}

	public void setEsClienteRegistrado(final boolean esClienteRegistrado) {
		this.esClienteRegistrado = esClienteRegistrado;
	}
}