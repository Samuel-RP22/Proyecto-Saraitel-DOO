package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PagoDominio {

    private UUID id;
    private CompraDominio compra;
    private BigDecimal montoPagado;
    private LocalDateTime fechaPago;

    public PagoDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.compra = new CompraDominio();
        this.montoPagado = UtilNumero.CERO_DECIMAL;
        this.fechaPago = UtilFecha.FECHA_HORA_DEFECTO;
    }

    public PagoDominio(final UUID id, final CompraDominio compra,
            final BigDecimal montoPagado, final LocalDateTime fechaPago) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.compra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                compra, new CompraDominio());
        this.montoPagado = UtilNumero.obtenerValorDefecto(montoPagado);
        this.fechaPago = UtilFecha.obtenerValorDefecto(fechaPago);
    }

    public UUID getId() {
        return id;
    }

    public CompraDominio getCompra() {
        return compra;
    }

    public BigDecimal getMontoPagado() {
        return montoPagado;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }
}
