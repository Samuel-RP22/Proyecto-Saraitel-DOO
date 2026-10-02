package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DepartamentoEntidad {

    private UUID id;
    private String nombre;

    public DepartamentoEntidad() {
        setId(UtilUUID.obtenerUUIDDefecto());
        setNombre(UtilTexto.VACIA);
    }

    public DepartamentoEntidad(final UUID id, final String nombre) {
        setId(id);
        setNombre(nombre);
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
}