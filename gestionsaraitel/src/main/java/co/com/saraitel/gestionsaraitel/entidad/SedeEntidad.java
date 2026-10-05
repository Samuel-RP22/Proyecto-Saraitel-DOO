package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class SedeEntidad {

    private UUID id;
    private CiudadEntidad ciudad;
    private String nombre;
    private String nit;
    private String direccion;
    private boolean esActiva;

    public SedeEntidad() {
    	setId(UtilUUID.obtenerUUIDDefecto());
    	setCiudad(new CiudadEntidad());
        setNombre(UtilTexto.VACIA);
        setNit(UtilTexto.VACIA);
        setDireccion(UtilTexto.VACIA);
        setEsActiva(true);
    }

    public SedeEntidad(final UUID id, final CiudadEntidad ciudad, final String nombre,
    		final String nit, final String direccion, final boolean esActiva) {
        setId(id);
        setCiudad(ciudad);
        setNombre(nombre);
        setNit(nit);
        setDireccion(direccion);
        setEsActiva(esActiva);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public CiudadEntidad getCiudad() {
        return ciudad;
    }

    public void setCiudad(final CiudadEntidad ciudad) {
        this.ciudad = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
        		(ciudad, new CiudadEntidad());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
    }

    public String getNit() {
        return nit;
    }

    public void setNit(final String nit) {
        this.nit = UtilTexto.quitarEspaciosEnBlanco(nit);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(final String direccion) {
        this.direccion = UtilTexto.quitarEspaciosEnBlanco(direccion);
    }

    public boolean getEsActiva() {
        return esActiva;
    }

    public void setEsActiva(final boolean esActiva) {
        this.esActiva = esActiva;
    }
}