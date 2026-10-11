package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DetalleCompraDominio {

    private UUID id;
    private ProcesoCompraDominio procesoCompra;
    private ProductoSedeDominio productoSede;
    private int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    public DetalleCompraDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.procesoCompra = new ProcesoCompraDominio();
        this.productoSede = new ProductoSedeDominio();
        this.cantidad = 1;
        this.precioUnitario = UtilNumero.CERO_DECIMAL;
        this.subtotal = UtilNumero.CERO_DECIMAL;
    }

    public DetalleCompraDominio(final UUID id,
            final ProcesoCompraDominio procesoCompra,
            final ProductoSedeDominio productoSede,
            final int cantidad,
            final BigDecimal precioUnitario,
            final BigDecimal subtotal) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.procesoCompra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                procesoCompra, new ProcesoCompraDominio());
        this.productoSede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                productoSede, new ProductoSedeDominio());
        this.cantidad = cantidad;
        this.precioUnitario = UtilNumero.obtenerValorDefecto(precioUnitario);
        this.subtotal = UtilNumero.obtenerValorDefecto(subtotal);
    }

    public UUID getId() {
        return id;
    }

    public ProcesoCompraDominio getProcesoCompra() {
        return procesoCompra;
    }

    public ProductoSedeDominio getProductoSede() {
        return productoSede;
    }

    public int getCantidad() {
        return cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }
}