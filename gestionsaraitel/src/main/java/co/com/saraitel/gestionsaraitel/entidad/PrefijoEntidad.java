package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class PrefijoEntidad {
    
    private UUID id;
    private String codigo;

    public PrefijoEntidad() {
        super();
    }

    public PrefijoEntidad(final UUID id, final String codigo) {
        super();
        setId(id);
        setCodigo(codigo);
       
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(final String codigo) {
        this.codigo = codigo;
    }
}
   