package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class CiudadEntidad {
    
    private UUID id;
    private String nombre;
    private DepartamentoEntidad departamento;

    public CiudadEntidad() {
        super();
    }

    public CiudadEntidad(final UUID id, final String nombre, final DepartamentoEntidad departamento) {
        super();
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public DepartamentoEntidad getDepartamento() {
        return departamento;
    }

    public void setDepartamento(final DepartamentoEntidad departamento) {
        this.departamento = departamento;
    }
}
