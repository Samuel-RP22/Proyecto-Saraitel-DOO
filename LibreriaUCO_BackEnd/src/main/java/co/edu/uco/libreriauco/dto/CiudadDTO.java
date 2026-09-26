package co.edu.uco.libreriauco.dto;

import java.util.UUID;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class CiudadDTO {

    private UUID id;
    private String nombre;
    private DepartamentoDTO departamento;

    public CiudadDTO() {
        setId(UtilUUID.obtenerUUIDDefecto());
        setNombre(UtilTexto.VACIA);
        setDepartamento(new DepartamentoDTO());
    }

    public CiudadDTO(final UUID id, final String nombre, final DepartamentoDTO departamento) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
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

    public DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public void setDepartamento(final DepartamentoDTO departamento) {
        this.departamento = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(departamento, new DepartamentoDTO());
    }
}