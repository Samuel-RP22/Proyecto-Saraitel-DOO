package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class SedeEntidad {
    
    private UUID id;
    private String nombre;
    private CiudadEntidad ciudad;
    private String nit;
    private String direccion;
    private boolean esactiva;
    
    public SedeEntidad() {
    	setId(UtilUUID.obtenerUUIDDefecto());
        setNombre(UtilTexto.VACIA);
        setCiudad(new CiudadEntidad());
        setNit(UtilTexto.VACIA);
        setDireccion(UtilTexto.VACIA);
        setEsActiva(true);
    }

    public SedeEntidad(final UUID id, final String nombre, final CiudadEntidad ciudad, 
    		final String nit, final String direccion, final boolean esactiva) {
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
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
    }

    public CiudadEntidad getCiudad() {
        return ciudad;
    }

    public void setCiudad(final CiudadEntidad ciudad) {
        this.ciudad = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(ciudad, new CiudadEntidad());
    }
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(final String direccion) {
        this.direccion = UtilTexto.quitarEspaciosEnBlanco(direccion);
    }
    
    public String getNit() {
        return nit;
    }

    public void setNit(final String nit) {
        this.nit = UtilTexto.quitarEspaciosEnBlanco(nit);
    }
    public boolean getEsActiva() {
        return esactiva;
    }

    public void setEsActiva(final boolean esactiva) {
        this.esactiva = esactiva;
    }
}