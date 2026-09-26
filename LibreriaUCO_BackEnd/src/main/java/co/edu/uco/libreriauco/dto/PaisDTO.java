package co.edu.uco.libreriauco.dto;

import java.util.UUID;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PaisDTO {

    private UUID id;
    private String nombre;

    public PaisDTO() {
        setId(UtilUUID.obtenerUUIDDefecto());
        setNombre(UtilTexto.VACIA);
    }

    public PaisDTO(final UUID id, final String nombre) {
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
        this.nombre = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
    }
}