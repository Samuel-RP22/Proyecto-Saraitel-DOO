package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoNEntidad {

	private UUID id;
	private ClienteRegistradoEntidad clienteregistrado;
	private PersonaEntidad persona;

	public ClienteRegistradoNEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setClienteregistrado(new ClienteRegistradoEntidad());
		setPersona(new PersonaEntidad());
	}

	public ClienteRegistradoNEntidad(final UUID id, final ClienteRegistradoEntidad clienteregistrado, final PersonaEntidad persona) {
		setId(id);
		setClienteregistrado(clienteregistrado);
		setPersona(persona);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ClienteRegistradoEntidad getClienteregistrado() {
		return clienteregistrado;
	}

	public void setClienteregistrado(final ClienteRegistradoEntidad clienteregistrado) {
		this.clienteregistrado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(clienteregistrado, new ClienteRegistradoEntidad());
	}

	public PersonaEntidad getPersona() {
		return persona;
	}

	public void setPersona(final PersonaEntidad persona) {
		this.persona = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(persona, new PersonaEntidad());
	}
}