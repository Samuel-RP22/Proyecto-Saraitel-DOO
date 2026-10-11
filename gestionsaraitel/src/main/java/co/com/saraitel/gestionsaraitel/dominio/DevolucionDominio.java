package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DevolucionDominio {

    private UUID id;
    private DetalleCompraDominio detalleCompra;
    private MotivoDominio motivo;
    private LocalDateTime fechaDevolucion;
    private int cantidad;
    private BigDecimal montoDevolucion;
    private String estado;

    public DevolucionDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.detalleCompra = new DetalleCompraDominio();
        this.motivo = new MotivoDominio();
        this.fechaDevolucion = UtilFecha.FECHA_HORA_DEFECTO;
        this.cantidad = 1;
        this.montoDevolucion = UtilNumero.CERO_DECIMAL;
        this.estado = UtilTexto.VACIA;
    }

    public DevolucionDominio(final UUID id,
            final DetalleCompraDominio detalleCompra,
            final MotivoDominio motivo,
            final LocalDateTime fechaDevolucion,
            final int cantidad,
            final BigDecimal montoDevolucion,
            final String estado) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.detalleCompra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                detalleCompra, new DetalleCompraDominio());
        this.motivo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                motivo, new MotivoDominio());
        this.fechaDevolucion = UtilFecha.obtenerValorDefecto(fechaDevolucion);
        this.cantidad = cantidad;
        this.montoDevolucion = UtilNumero.obtenerValorDefecto(montoDevolucion);
        this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
    }

    public UUID getId() {
        return id;
    }

    public DetalleCompraDominio getDetalleCompra() {
        return detalleCompra;
    }

    public MotivoDominio getMotivo() {
        return motivo;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public BigDecimal getMontoDevolucion() {
        return montoDevolucion;
    }

    public String getEstado() {
        return estado;
    }
}