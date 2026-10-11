package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class TipoDocumentoDominio {

    private UUID id;
    private String tipo;

    public TipoDocumentoDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.tipo = UtilTexto.VACIA;
    }

    public TipoDocumentoDominio(final UUID id, final String tipo) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.tipo = UtilTexto.quitarEspaciosEnBlanco(tipo);
    }

    public UUID getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}
