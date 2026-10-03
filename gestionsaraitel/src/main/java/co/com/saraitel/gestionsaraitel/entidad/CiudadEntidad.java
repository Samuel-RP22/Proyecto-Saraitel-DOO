package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class CiudadEntidad {
    
    private UUID id;
    private String nombre;
    private DepartamentoEntidad departamento;

    public CiudadEntidad() {
        setId(UtilUUID.obtenerUUIDDefecto());
        setNombre(UtilTexto.VACIA);
        setDepartamento(new DepartamentoEntidad());
    }

    public CiudadEntidad(final UUID id, final String nombre, final DepartamentoEntidad departamento) {
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
        this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
    }

    public DepartamentoEntidad getDepartamento() {
        return departamento;
    }

    public void setDepartamento(final DepartamentoEntidad departamento) {
        this.departamento = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(departamento, new DepartamentoEntidad());
    }
}