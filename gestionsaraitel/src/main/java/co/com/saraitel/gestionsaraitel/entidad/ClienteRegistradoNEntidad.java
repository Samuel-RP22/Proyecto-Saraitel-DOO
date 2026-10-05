package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoNEntidad {

	private UUID id;
	private ClienteRegistradoEntidad clienteRegistrado;
	private PersonaEntidad persona;

	public ClienteRegistradoNEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setClienteRegistrado(new ClienteRegistradoEntidad());
		setPersona(new PersonaEntidad());
	}

	public ClienteRegistradoNEntidad(final UUID id, final ClienteRegistradoEntidad clienteRegistrado, 
			final PersonaEntidad persona) {
		setId(id);
		setClienteRegistrado(clienteRegistrado);
		setPersona(persona);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ClienteRegistradoEntidad getClienteRegistrado() {
		return clienteRegistrado;
	}

	public void setClienteRegistrado(final ClienteRegistradoEntidad clienteRegistrado) {
		this.clienteRegistrado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(clienteRegistrado, new ClienteRegistradoEntidad());
	}

	public PersonaEntidad getPersona() {
		return persona;
	}

	public void setPersona(final PersonaEntidad persona) {
		this.persona = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(persona, new PersonaEntidad());
	}
}