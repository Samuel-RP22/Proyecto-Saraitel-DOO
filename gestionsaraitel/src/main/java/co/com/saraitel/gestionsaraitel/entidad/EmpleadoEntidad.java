package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class EmpleadoEntidad {

	private UUID id;
	private SedeEntidad sede;
	private PersonaEntidad persona;
	private boolean esactivo;

	public EmpleadoEntidad() {
		super();
	}

	public EmpleadoEntidad(final UUID id, final SedeEntidad sede, final PersonaEntidad persona, final boolean esactivo) {
		super();
		setId(id);
		setSede(sede);
		setPersona(persona);
		setEsactivo(esactivo);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public SedeEntidad getSede() {
		return sede;
	}

	public void setSede(final SedeEntidad sede) {
		this.sede = sede;
	}

	public PersonaEntidad getPersona() {
		return persona;
	}

	public void setPersona(final PersonaEntidad persona) {
		this.persona = persona;
	}

	public boolean isEsactivo() {
		return esactivo;
	}

	public void setEsactivo(final boolean esactivo) {
		this.esactivo = esactivo;
	}
}