package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PagoNormalDominio {

    private UUID id;
    private MetodoPagoDominio metodoPago;
    private PagoDominio pago;
    private BigDecimal montoPagar;

    private PagoNormalDominio(Builder builder) {
        this.id = builder.id;
        this.metodoPago = builder.metodoPago;
        this.pago = builder.pago;
        this.montoPagar = builder.montoPagar;
    }

    public UUID getId() {
        return id;
    }

    public MetodoPagoDominio getMetodoPago() {
        return metodoPago;
    }

    public PagoDominio getPago() {
        return pago;
    }

    public BigDecimal getMontoPagar() {
        return montoPagar;
    }

    public static class Builder {

        private UUID id;
        private MetodoPagoDominio metodoPago;
        private PagoDominio pago;
        private BigDecimal montoPagar;

        public Builder() {
            id = UtilUUID.obtenerUUIDDefecto();
            metodoPago = new MetodoPagoDominio.Builder().build();
            pago = new PagoDominio.Builder().build();
            montoPagar = UtilNumero.CERO_DECIMAL;
        }

        public Builder id(UUID id) {
            this.id = UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder metodoPago(MetodoPagoDominio metodoPago) {
            this.metodoPago =
                UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                    metodoPago, new MetodoPagoDominio.Builder().build());
            return this;
        }

        public Builder pago(PagoDominio pago) {
            this.pago =
                UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                    pago, new PagoDominio.Builder().build());
            return this;
        }

        public Builder montoPagar(BigDecimal montoPagar) {
            this.montoPagar = UtilNumero.obtenerValorDefecto(montoPagar);
            return this;
        }

        public PagoNormalDominio build() {
            return new PagoNormalDominio(this);
        }
    }
}