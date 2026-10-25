package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteDominio {

	private final UUID id;
	private final boolean esClienteRegistrado;

	public ClienteDominio(final UUID id, final boolean esClienteRegistrado) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.esClienteRegistrado = esClienteRegistrado;
	}

	public static ClienteDominio obtenerValorDefecto() {
		return new ClienteDominio(UtilUUID.obtenerUUIDDefecto(), true);
	}

	public UUID getId() {
		return id;
	}

	public boolean getEsClienteRegistrado() {
		return esClienteRegistrado;
	}
}