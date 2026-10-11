package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class SedeDominio {

    private UUID id;
    private CiudadDominio ciudad;
    private String nombre;
    private String nit;
    private String direccion;
    private boolean esActiva;

    public SedeDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.ciudad = new CiudadDominio();
        this.nombre = UtilTexto.VACIA;
        this.nit = UtilTexto.VACIA;
        this.direccion = UtilTexto.VACIA;
        this.esActiva = true;
    }

    public SedeDominio(final UUID id, final CiudadDominio ciudad,
            final String nombre, final String nit, final String direccion,
            final boolean esActiva) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.ciudad = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                ciudad, new CiudadDominio());
        this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
        this.nit = UtilTexto.quitarEspaciosEnBlanco(nit);
        this.direccion = UtilTexto.quitarEspaciosEnBlanco(direccion);
        this.esActiva = esActiva;
    }

    public UUID getId() {
        return id;
    }

    public CiudadDominio getCiudad() {
        return ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean getEsActiva() {
        return esActiva;
    }
}
