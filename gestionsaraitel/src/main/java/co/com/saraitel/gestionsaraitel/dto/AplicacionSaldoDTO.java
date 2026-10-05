package co.com.saraitel.gestionsaraitel.dto;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AplicacionSaldoDTO {

    private UUID id;
    private SaldoFavorDTO saldoFavor;
    private PagoDTO pago;
    private BigDecimal valorAplicado;

    public AplicacionSaldoDTO() {
        setId(UtilUUID.obtenerUUIDDefecto());
        setSaldoFavor(new SaldoFavorDTO());
        setPago(new PagoDTO());
        setValorAplicado(UtilNumero.CERO_DECIMAL);
    }

    public AplicacionSaldoDTO(final UUID id, final SaldoFavorDTO saldoFavor,
            final PagoDTO pago, final BigDecimal valorAplicado) {
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

    public SaldoFavorDTO getSaldoFavor() {
        return saldoFavor;
    }

    public void setSaldoFavor(final SaldoFavorDTO saldoFavor) {
        this.saldoFavor = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
        		(saldoFavor, new SaldoFavorDTO());
    }

    public PagoDTO getPago() {
        return pago;
    }

    public void setPago(final PagoDTO pago) {
        this.pago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
        		(pago, new PagoDTO());
    }

    public BigDecimal getValorAplicado() {
        return valorAplicado;
    }

    public void setValorAplicado(final BigDecimal valorAplicado) {
        this.valorAplicado = UtilNumero.obtenerValorDefecto(valorAplicado);
    }
}