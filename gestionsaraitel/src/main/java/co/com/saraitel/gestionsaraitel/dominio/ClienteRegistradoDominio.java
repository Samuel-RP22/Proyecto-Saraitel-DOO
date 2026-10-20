package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoDominio {

	private final UUID id;
	private final ClienteDominio cliente;
	private final boolean clienteNaturalDefecto;

	public ClienteRegistradoDominio(final UUID id, final ClienteDominio cliente, final boolean clienteNaturalDefecto) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente,
				ClienteDominio.obtenerValorDefecto());
		this.clienteNaturalDefecto = clienteNaturalDefecto;
	}

	public static ClienteRegistradoDominio obtenerValorDefecto() {
		return new ClienteRegistradoDominio(UtilUUID.obtenerUUIDDefecto(), ClienteDominio.obtenerValorDefecto(), true);
	}

	public UUID getId() {
		return id;
	}

	public ClienteDominio getCliente() {
		return cliente;
	}

	public boolean getClienteNaturalDefecto() {
		return clienteNaturalDefecto;
	}
}