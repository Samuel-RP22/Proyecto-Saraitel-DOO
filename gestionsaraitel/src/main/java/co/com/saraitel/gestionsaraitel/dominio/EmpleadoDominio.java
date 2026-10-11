package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class EmpleadoDominio {

    private UUID id;
    private SedeDominio sede;
    private PersonaDominio persona;
    private boolean esActiva;

    public EmpleadoDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.sede = new SedeDominio();
        this.persona = new PersonaDominio();
        this.esActiva = true;
    }

    public EmpleadoDominio(final UUID id, final SedeDominio sede,
            final PersonaDominio persona, final boolean esActiva) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                sede, new SedeDominio());
        this.persona = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                persona, new PersonaDominio());
        this.esActiva = esActiva;
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