package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoNDominio {

	private final UUID id;
	private final ClienteRegistradoDominio clienteRegistrado;
	private final PersonaDominio persona;

	public ClienteRegistradoNDominio(final UUID id, final ClienteRegistradoDominio clienteRegistrado,
			final PersonaDominio persona) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.clienteRegistrado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(clienteRegistrado,
				ClienteRegistradoDominio.obtenerValorDefecto());
		this.persona = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(persona,
				PersonaDominio.obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public ClienteRegistradoDominio getClienteRegistrado() {
		return clienteRegistrado;
	}

	public PersonaDominio getPersona() {
		return persona;
	}
}