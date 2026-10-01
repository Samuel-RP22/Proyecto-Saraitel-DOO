package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class SedeEntidad {
    
    private UUID id;
    private String nombre;
    private CiudadEntidad ciudad;
    private String nit;
    private String direccion;
    private Boolean esactiva;
    
    public SedeEntidad() {
        super();
    }

    public SedeEntidad(final UUID id, final String nombre, final CiudadEntidad ciudad, final String nit,
    		final String direccion, final Boolean esactiva) {
        super();
        setId(id);
        setNombre(nombre);
        setCiudad(ciudad);
        setNit(nit);
        setDireccion(direccion);
        setEsActiva(esactiva);
        
        
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

    public CiudadEntidad getCiudad() {
        return ciudad;
    }

    public void setCiudad(final CiudadEntidad ciudad) {
        this.ciudad = ciudad;
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(final String direccion) {
        this.direccion = direccion;
    }
    
    public String getNit() {
        return nit;
    }

    public void setNit(final String nit) {
        this.nit = nit;
    }
    public Boolean getEsActiva() {
        return esactiva;
    }

    public void setEsActiva(final Boolean esactiva) {
        this.esactiva = esactiva;
    }
}
