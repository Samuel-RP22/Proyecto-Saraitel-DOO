package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProductoDominio {

    private UUID id;
    private MarcaDominio marca;
    private CategoriaDominio categoria;
    private String modelo;
    private String nombre;
    private String descripcion;

    public ProductoDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.marca = new MarcaDominio();
        this.categoria = new CategoriaDominio();
        this.modelo = UtilTexto.VACIA;
        this.nombre = UtilTexto.VACIA;
        this.descripcion = UtilTexto.VACIA;
    }

    public ProductoDominio(final UUID id, final MarcaDominio marca,
            final CategoriaDominio categoria, final String modelo,
            final String nombre, final String descripcion) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.marca = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                marca, new MarcaDominio());
        this.categoria = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                categoria, new CategoriaDominio());
        this.modelo = UtilTexto.quitarEspaciosEnBlanco(modelo);
        this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
        this.descripcion = UtilTexto.quitarEspaciosEnBlanco(descripcion);
    }

    public UUID getId() {
        return id;
    }

    public MarcaDominio getMarca() {
        return marca;
    }

    public CategoriaDominio getCategoria() {
        return categoria;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
