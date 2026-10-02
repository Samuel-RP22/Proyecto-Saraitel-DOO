package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DepartamentoDTO {

    private UUID id;
    private String nombre;
    private PaisDTO pais;

    public DepartamentoDTO() {
        setId(UtilUUID.obtenerUUIDDefecto());
        setNombre(UtilTexto.VACIA);
        setPais(new PaisDTO());
    }

    public DepartamentoDTO(final UUID id, final String nombre, final PaisDTO pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
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

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(final PaisDTO pais) {
        this.pais = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pais, new PaisDTO());
    }
}