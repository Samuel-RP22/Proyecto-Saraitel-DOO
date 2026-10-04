package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoNDTO {

	private UUID id;
	private ClienteRegistradoDTO clienteRegistrado;
	private PersonaDTO persona;

	public ClienteRegistradoNDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setClienteRegistrado(new ClienteRegistradoDTO());
		setPersona(new PersonaDTO());
	}

	public ClienteRegistradoNDTO(final UUID id, final ClienteRegistradoDTO clienteRegistrado, 
			final PersonaDTO persona) {
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

	public ClienteRegistradoDTO getClienteRegistrado() {
		return clienteRegistrado;
	}

	public void setClienteRegistrado(final ClienteRegistradoDTO clienteRegistrado) {
		this.clienteRegistrado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(clienteRegistrado, new ClienteRegistradoDTO());
	}

	public PersonaDTO getPersona() {
		return persona;
	}

	public void setPersona(final PersonaDTO persona) {
		this.persona = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(persona, new PersonaDTO());
	}
}