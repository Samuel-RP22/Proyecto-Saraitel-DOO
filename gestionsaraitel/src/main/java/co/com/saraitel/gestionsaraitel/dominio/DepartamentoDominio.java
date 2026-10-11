package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DepartamentoDominio {

    private UUID id;
    private String nombre;
    private PaisDominio pais;

    public DepartamentoDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.nombre = UtilTexto.VACIA;
        this.pais = new PaisDominio();
    }

    public DepartamentoDominio(final UUID id, final String nombre,
            final PaisDominio pais) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
        this.pais = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
                (pais, new PaisDominio());
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public PaisDominio getPais() {
        return pais;
    }
}