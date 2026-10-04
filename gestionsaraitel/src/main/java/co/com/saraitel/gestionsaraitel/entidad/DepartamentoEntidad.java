package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DepartamentoEntidad {

    private UUID id;
    private String nombre;
    private PaisEntidad pais;
    
    public DepartamentoEntidad() {
        setId(UtilUUID.obtenerUUIDDefecto());
        setNombre(UtilTexto.VACIA);
        setPais(new PaisEntidad());
    }

    public DepartamentoEntidad(final UUID id, final String nombre, final PaisEntidad pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
    }

    public PaisEntidad getPais() {
        return pais;
    }

    public void setPais(final PaisEntidad pais) {
        this.pais = UtilObjeto.esNulo(pais) ? new PaisEntidad() : pais;
    }
}