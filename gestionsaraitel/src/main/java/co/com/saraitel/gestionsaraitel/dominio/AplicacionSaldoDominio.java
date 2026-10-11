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

    public AplicacionSaldoDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.saldoFavor = new SaldoFavorDominio();
        this.pago = new PagoDominio();
        this.valorAplicado = UtilNumero.CERO_DECIMAL;
    }

    public AplicacionSaldoDominio(final UUID id, final SaldoFavorDominio saldoFavor,
            final PagoDominio pago, final BigDecimal valorAplicado) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.saldoFavor = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
                (saldoFavor, new SaldoFavorDominio());
        this.pago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
                (pago, new PagoDominio());
        this.valorAplicado = UtilNumero.obtenerValorDefecto(valorAplicado);
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
}