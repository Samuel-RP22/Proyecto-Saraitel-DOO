package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class CiudadDominio {

    private UUID id;
    private String nombre;
    private DepartamentoDominio departamento;

    public CiudadDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.nombre = UtilTexto.VACIA;
        this.departamento = new DepartamentoDominio();
    }

    public CiudadDominio(final UUID id, final String nombre,
            final DepartamentoDominio departamento) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
        this.departamento = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
                (departamento, new DepartamentoDominio());
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public DepartamentoDominio getDepartamento() {
        return departamento;
    }
}