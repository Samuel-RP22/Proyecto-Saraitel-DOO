package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class EmpleadoDTO {

	private UUID id;
	private SedeDTO sede;
	private PersonaDTO persona;
	private boolean esActivo;

	public EmpleadoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setSede(new SedeDTO());
		setPersona(new PersonaDTO());
		setEsActivo(true);
	}

	public EmpleadoDTO(final UUID id, final SedeDTO sede, 
			final PersonaDTO persona, final boolean esActivo) {
		setId(id);
		setSede(sede);
		setPersona(persona);
		setEsActivo(esActivo);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public SedeDTO getSede() {
		return sede;
	}

	public void setSede(final SedeDTO sede) {
		this.sede = UtilObjeto.esNulo(sede) ? new SedeDTO() : sede;
	}

	public PersonaDTO getPersona() {
		return persona;
	}

	public void setPersona(final PersonaDTO persona) {
		this.persona = UtilObjeto.esNulo(persona) ? 
				new PersonaDTO() : persona;
	}

	public boolean getEsActivo() {
		return esActivo;
	}

	public void setEsActivo(final boolean esActivo) {
		this.esActivo = esActivo;
	}
}