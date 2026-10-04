package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class EmpleadoEntidad {

	private UUID id;
	private SedeEntidad sede;
	private PersonaEntidad persona;
	private boolean esActivo;

	public EmpleadoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setSede(new SedeEntidad());
		setPersona(new PersonaEntidad());
		setEsActivo(true);
	}

	public EmpleadoEntidad(final UUID id, final SedeEntidad sede, 
			final PersonaEntidad persona, final boolean esActivo) {
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

	public SedeEntidad getSede() {
		return sede;
	}

	public void setSede(final SedeEntidad sede) {
		this.sede = UtilObjeto.esNulo(sede) ? new SedeEntidad() : sede;
	}

	public PersonaEntidad getPersona() {
		return persona;
	}

	public void setPersona(final PersonaEntidad persona) {
		this.persona = UtilObjeto.esNulo(persona) ? 
				new PersonaEntidad() : persona;
	}

	public boolean getEsActivo() {
		return esActivo;
	}

	public void setEsActivo(final boolean esActivo) {
		this.esActivo = esActivo;
	}
}