package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class CiudadEntidad {
    
    private UUID id;
    private String nombre;
    private DepartamentoEntidad departamento;

    public CiudadEntidad() {
        super();
    }

    public CiudadEntidad(final UUID id, final String nombre, final DepartamentoEntidad departamento, final UUID id2, final UUID id3, 
    		final UUID id4, final UUID id5, final UUID id6, final UUID id7) {
        super();
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
        setId(id2);
        setId(id3);
        setId(id4);
        setId(id5);
        setId(id6);
        setId(id7);
        setId(id2);
   
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
