package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class TipoDocumentoEntidad {
    
    private UUID id;
    private String tipo;

    public TipoDocumentoEntidad() {
        super();
    }

    public TipoDocumentoEntidad(final UUID id, final String tipo) {
        super();
        setId(id);
        setTipo(tipo);
       
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(final String tipo) {
        this.tipo = tipo;
    }
}
   