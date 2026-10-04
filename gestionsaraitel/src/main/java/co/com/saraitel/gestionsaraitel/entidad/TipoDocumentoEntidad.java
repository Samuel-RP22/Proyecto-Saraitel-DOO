package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class TipoDocumentoEntidad {
    
    private UUID id;
    private String tipo;

    public TipoDocumentoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setTipo(UtilTexto.VACIA);
    }

    public TipoDocumentoEntidad(final UUID id, final String tipo) {
        setId(id);
        setTipo(tipo);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(final String tipo) {
        this.tipo = UtilTexto.quitarEspaciosEnBlanco(tipo);
    }
}