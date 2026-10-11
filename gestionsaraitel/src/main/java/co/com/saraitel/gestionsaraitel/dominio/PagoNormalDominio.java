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

    public PagoNormalDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.metodoPago = new MetodoPagoDominio();
        this.pago = new PagoDominio();
        this.montoPagar = UtilNumero.CERO_DECIMAL;
    }

    public PagoNormalDominio(final UUID id, final MetodoPagoDominio metodoPago,
            final PagoDominio pago, final BigDecimal montoPagar) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.metodoPago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                metodoPago, new MetodoPagoDominio());
        this.pago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                pago, new PagoDominio());
        this.montoPagar = UtilNumero.obtenerValorDefecto(montoPagar);
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
}
