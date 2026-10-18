package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class EmpleadoDominio {

	private final UUID id;
	private final SedeDominio sede;
	private final PersonaDominio persona;
	private final boolean esActiva;

	public EmpleadoDominio(final UUID id, final SedeDominio sede, final PersonaDominio persona,
			final boolean esActiva) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(sede, SedeDominio.obtenerValorDefecto());
		this.persona = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(persona,
				PersonaDominio.obtenerValorDefecto());
		this.esActiva = esActiva;
	}

	public static EmpleadoDominio obtenerValorDefecto() {
		return new EmpleadoDominio(UtilUUID.obtenerUUIDDefecto(), SedeDominio.obtenerValorDefecto(),
				PersonaDominio.obtenerValorDefecto(), true);
	}

	public UUID getId() {
		return id;
	}

	public SedeDominio getSede() {
		return sede;
	}

	public PersonaDominio getPersona() {
		return persona;
	}

	public boolean getEsActiva() {
		return esActiva;
	}
}