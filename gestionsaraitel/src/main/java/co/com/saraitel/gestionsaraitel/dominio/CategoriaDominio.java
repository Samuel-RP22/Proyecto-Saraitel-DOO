package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class CategoriaDominio {

    private UUID id;
    private String nombre;
    private UUID categoriaPadre;
    private int nivel;

    public CategoriaDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.nombre = UtilTexto.VACIA;
        this.categoriaPadre = null;
        this.nivel = 1;
    }

    public CategoriaDominio(final UUID id, final String nombre,
            final UUID categoriaPadre, final int nivel) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
        this.categoriaPadre = categoriaPadre;
        this.nivel = nivel;
    }

    public UUID getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public UUID getCategoriaPadre() {
        return categoriaPadre;
    }

    public int getNivel() {
        return nivel;
    }
}