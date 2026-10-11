package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DetalleIngresoDominio {

    private UUID id;
    private IngresoInventarioDominio ingresoInventario;
    private ProductoSedeDominio productoSede;
    private int cantidad;
    private BigDecimal costoUnitario;
    private BigDecimal subtotal;

    public DetalleIngresoDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.ingresoInventario = new IngresoInventarioDominio();
        this.productoSede = new ProductoSedeDominio();
        this.cantidad = 1;
        this.costoUnitario = UtilNumero.CERO_DECIMAL;
        this.subtotal = UtilNumero.CERO_DECIMAL;
    }

    public DetalleIngresoDominio(final UUID id,
            final IngresoInventarioDominio ingresoInventario,
            final ProductoSedeDominio productoSede,
            final int cantidad,
            final BigDecimal costoUnitario,
            final BigDecimal subtotal) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.ingresoInventario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                ingresoInventario, new IngresoInventarioDominio());
        this.productoSede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                productoSede, new ProductoSedeDominio());
        this.cantidad = cantidad;
        this.costoUnitario = UtilNumero.obtenerValorDefecto(costoUnitario);
        this.subtotal = UtilNumero.obtenerValorDefecto(subtotal);
    }

    public UUID getId() {
        return id;
    }

    public IngresoInventarioDominio getIngresoInventario() {
        return ingresoInventario;
    }

    public ProductoSedeDominio getProductoSede() {
        return productoSede;
    }

    public int getCantidad() {
        return cantidad;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }
}