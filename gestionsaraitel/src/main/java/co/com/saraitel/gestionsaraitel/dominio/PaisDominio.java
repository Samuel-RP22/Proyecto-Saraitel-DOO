package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PaisDominio {

    private UUID id;
    private String nombre;

    public PaisDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.nombre = UtilTexto.VACIA;
    }

    public PaisDominio(final UUID id, final String nombre) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
