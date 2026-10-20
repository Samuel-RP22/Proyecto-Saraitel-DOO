package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteNoRegistradoDominio {

	private final UUID id;
	private final ClienteDominio cliente;

	public ClienteNoRegistradoDominio(final UUID id, final ClienteDominio cliente) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente,
				ClienteDominio.obtenerValorDefecto());
	}

	public static ClienteNoRegistradoDominio obtenerValorDefecto() {
		return new ClienteNoRegistradoDominio(UtilUUID.obtenerUUIDDefecto(), ClienteDominio.obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public ClienteDominio getCliente() {
		return cliente;
	}
}