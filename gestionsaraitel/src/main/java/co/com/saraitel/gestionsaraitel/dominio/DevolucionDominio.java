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

    private DevolucionDominio(Builder builder) {
        this.id = builder.id;
        this.detalleCompra = builder.detalleCompra;
        this.motivo = builder.motivo;
        this.fechaDevolucion = builder.fechaDevolucion;
        this.cantidad = builder.cantidad;
        this.montoDevolucion = builder.montoDevolucion;
        this.estado = builder.estado;
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

    public static class Builder {

        private UUID id;
        private DetalleCompraDominio detalleCompra;
        private MotivoDominio motivo;
        private LocalDateTime fechaDevolucion;
        private int cantidad;
        private BigDecimal montoDevolucion;
        private String estado;

        public Builder() {
            id = UtilUUID.obtenerUUIDDefecto();
            detalleCompra = new DetalleCompraDominio.Builder().build();
            motivo = new MotivoDominio.Builder().build();
            fechaDevolucion = UtilFecha.FECHA_HORA_DEFECTO;
            cantidad = 1;
            montoDevolucion = UtilNumero.CERO_DECIMAL;
            estado = UtilTexto.VACIA;
        }

        public Builder id(UUID id) {
            this.id = UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder detalleCompra(DetalleCompraDominio detalleCompra) {
            this.detalleCompra =
                UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                    detalleCompra, new DetalleCompraDominio.Builder().build());
            return this;
        }

        public Builder motivo(MotivoDominio motivo) {
            this.motivo =
                UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                    motivo, new MotivoDominio.Builder().build());
            return this;
        }

        public Builder fechaDevolucion(LocalDateTime fechaDevolucion) {
            this.fechaDevolucion = UtilFecha.obtenerValorDefecto(fechaDevolucion);
            return this;
        }

        public Builder cantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public Builder estado(String estado) {
            this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
            return this;
        }

        public DevolucionDominio build() {
            return new DevolucionDominio(this);
        }
    }
}