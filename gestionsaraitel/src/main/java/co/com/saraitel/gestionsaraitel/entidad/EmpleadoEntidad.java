package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class EmpleadoEntidad {

	private UUID id;
	private SedeEntidad sede;
	private PersonaEntidad persona;
	private boolean esactivo;

	public EmpleadoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setSede(new SedeEntidad());
		setPersona(new PersonaEntidad());
		setEsactivo(true);
	}

	public EmpleadoEntidad(final UUID id, final SedeEntidad sede, final PersonaEntidad persona, final boolean esactivo) {
		setId(id);
		setSede(sede);
		setPersona(persona);
		setEsactivo(esactivo);
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
		this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(sede, new SedeEntidad());
	}

	public PersonaEntidad getPersona() {
		return persona;
	}

	public void setPersona(final PersonaEntidad persona) {
		this.persona = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(persona, new PersonaEntidad());
	}

	public boolean getEsactivo() {
		return esactivo;
	}

	public void setEsactivo(final boolean esactivo) {
		this.esactivo = esactivo;
	}
}