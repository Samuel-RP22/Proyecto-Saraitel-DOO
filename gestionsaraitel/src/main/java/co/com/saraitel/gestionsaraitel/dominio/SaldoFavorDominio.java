package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class SaldoFavorDominio {

    private UUID id;
    private DevolucionDominio devolucion;
    private BigDecimal montoUsado;
    private String estado;

    private SaldoFavorDominio(Builder builder) {
        this.id = builder.id;
        this.devolucion = builder.devolucion;
        this.montoUsado = builder.montoUsado;
        this.estado = builder.estado;
    }

    public UUID getId() {
        return id;
    }

    public DevolucionDominio getDevolucion() {
        return devolucion;
    }

    public BigDecimal getMontoUsado() {
        return montoUsado;
    }

    public String getEstado() {
        return estado;
    }

    public static class Builder {

        private UUID id;
        private DevolucionDominio devolucion;
        private BigDecimal montoUsado;
        private String estado;

        public Builder() {
            id = UtilUUID.obtenerUUIDDefecto();
            devolucion = new DevolucionDominio.Builder().build();
            montoUsado = UtilNumero.CERO_DECIMAL;
            estado = UtilTexto.VACIA;
        }

        public Builder id(UUID id) {
            this.id = UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder devolucion(DevolucionDominio devolucion) {
            this.devolucion =
                UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(devolucion, new DevolucionDominio.Builder().build());
            return this;
        }

        public Builder estado(String estado) {
            this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
            return this;
        }

        public SaldoFavorDominio build() {
            return new SaldoFavorDominio(this);
        }
    }
}