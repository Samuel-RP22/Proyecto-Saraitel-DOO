package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PrefijoDominio {

    private UUID id;
    private String codigo;

    public PrefijoDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.codigo = UtilTexto.VACIA;
    }

    public PrefijoDominio(final UUID id, final String codigo) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.codigo = UtilTexto.quitarEspaciosEnBlanco(codigo);
    }

    public UUID getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }
}
