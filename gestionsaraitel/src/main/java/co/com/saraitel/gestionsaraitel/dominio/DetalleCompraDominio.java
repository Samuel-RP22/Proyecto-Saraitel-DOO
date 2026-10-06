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

    private DetalleCompraDominio(Builder builder) {
        this.id = builder.id;
        this.procesoCompra = builder.procesoCompra;
        this.productoSede = builder.productoSede;
        this.cantidad = builder.cantidad;
        this.precioUnitario = builder.precioUnitario;
        this.subtotal = builder.subtotal;
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

    public static class Builder {

        private UUID id;
        private ProcesoCompraDominio procesoCompra;
        private ProductoSedeDominio productoSede;
        private int cantidad;
        private BigDecimal precioUnitario;
        private BigDecimal subtotal;

        public Builder() {
            id = UtilUUID.obtenerUUIDDefecto();
            procesoCompra = new ProcesoCompraDominio.Builder().build();
            productoSede = new ProductoSedeDominio.Builder().build();
            cantidad = 1;
            precioUnitario = UtilNumero.CERO_DECIMAL;
            subtotal = UtilNumero.CERO_DECIMAL;
        }

        public Builder id(UUID id) {
            this.id = UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder procesoCompra(ProcesoCompraDominio procesoCompra) {
            this.procesoCompra =
                UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                    procesoCompra, new ProcesoCompraDominio.Builder().build());
            return this;
        }

        public Builder productoSede(ProductoSedeDominio productoSede) {
            this.productoSede =
                UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                    productoSede, new ProductoSedeDominio.Builder().build());
            return this;
        }

        public Builder cantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public Builder precioUnitario(BigDecimal precioUnitario) {
            this.precioUnitario = UtilNumero.obtenerValorDefecto(precioUnitario);
            return this;
        }

        public DetalleCompraDominio build() {
            return new DetalleCompraDominio(this);
        }
    }
}