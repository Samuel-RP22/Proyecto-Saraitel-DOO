package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AplicacionSaldoEntidad {

    private UUID id;
    private SaldoFavorEntidad saldoFavor;
    private PagoEntidad pago;
    private BigDecimal valorAplicado;

    public AplicacionSaldoEntidad() {
        setId(UtilUUID.obtenerUUIDDefecto());
        setSaldoFavor(new SaldoFavorEntidad());
        setPago(new PagoEntidad());
        setValorAplicado(UtilNumero.CERO_DECIMAL);
    }

    public AplicacionSaldoEntidad(final UUID id, final SaldoFavorEntidad saldoFavor,
            final PagoEntidad pago, final BigDecimal valorAplicado) {
        setId(id);
        setSaldoFavor(saldoFavor);
        setPago(pago);
        setValorAplicado(valorAplicado);
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UtilUUID.obtenerValorDefecto(id);
    }

    public SaldoFavorEntidad getSaldoFavor() {
        return saldoFavor;
    }

    public void setSaldoFavor(final SaldoFavorEntidad saldoFavor) {
        this.saldoFavor = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
        		(saldoFavor, new SaldoFavorEntidad());
    }

    public PagoEntidad getPago() {
        return pago;
    }

    public void setPago(final PagoEntidad pago) {
        this.pago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
        		(pago, new PagoEntidad());
    }

    public BigDecimal getValorAplicado() {
        return valorAplicado;
    }

    public void setValorAplicado(final BigDecimal valorAplicado) {
        this.valorAplicado = UtilNumero.obtenerValorDefecto(valorAplicado);
    }
}