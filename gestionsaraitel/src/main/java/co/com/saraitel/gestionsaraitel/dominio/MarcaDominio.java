package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class MarcaDominio {

    private UUID id;
    private String nombre;
    private boolean esActivo;

    public MarcaDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.nombre = UtilTexto.VACIA;
        this.esActivo = true;
    }

    public MarcaDominio(final UUID id, final String nombre,
            final boolean esActivo) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
        this.esActivo = esActivo;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getEsActivo() {
        return esActivo;
    }
}
