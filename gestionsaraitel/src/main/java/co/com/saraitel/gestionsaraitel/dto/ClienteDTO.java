package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteDTO {

	private UUID id;
	private boolean esClienteRegistrado;

	public ClienteDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setEsClienteRegistrado(true);
	}

	public ClienteDTO(final UUID id, final boolean esClienteRegistrado) {
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