package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PrefijoEntidad {
    
    private UUID id;
    private String codigo;

    public PrefijoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCodigo(UtilTexto.VACIA);
    }

    public PrefijoEntidad(final UUID id, final String codigo) {
        setId(id);
        setCodigo(codigo);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(final String codigo) {
        this.codigo = UtilTexto.quitarEspaciosEnBlanco(codigo);
    }
}
   