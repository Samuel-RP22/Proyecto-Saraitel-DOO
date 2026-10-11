package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AplicacionSaldoDominio {

    private UUID id;
    private SaldoFavorDominio saldoFavor;
    private PagoDominio pago;
    private BigDecimal valorAplicado;

    private AplicacionSaldoDominio(Builder builder) {
        this.id = builder.id;
        this.saldoFavor = builder.saldoFavor;
        this.pago = builder.pago;
        this.valorAplicado = builder.valorAplicado;
    }

    public UUID getId() {
        return id;
    }

    public SaldoFavorDominio getSaldoFavor() {
        return saldoFavor;
    }

    public PagoDominio getPago() {
        return pago;
    }

    public BigDecimal getValorAplicado() {
        return valorAplicado;
    }

    public static class Builder {

        private UUID id;
        private SaldoFavorDominio saldoFavor;
        private PagoDominio pago;
        private BigDecimal valorAplicado;

        public Builder() {
            id = UtilUUID.obtenerUUIDDefecto();
            saldoFavor = new SaldoFavorDominio.Builder().build();
            pago = new PagoDominio.Builder().build();
            valorAplicado = UtilNumero.CERO_DECIMAL;
        }

        public Builder id(UUID id) {
            this.id = UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder saldoFavor(SaldoFavorDominio saldoFavor) {
            this.saldoFavor =
                UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(saldoFavor, new SaldoFavorDominio.Builder().build());
            return this;
        }

        public Builder pago(PagoDominio pago) {
            this.pago =
                UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pago, new PagoDominio.Builder().build());
            return this;
        }

        public Builder valorAplicado(BigDecimal valorAplicado) {
            this.valorAplicado =UtilNumero.obtenerValorDefecto(valorAplicado);
            return this;
        }

        public AplicacionSaldoDominio build() {
            return new AplicacionSaldoDominio(this);
        }
    }
}