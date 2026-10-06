package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class IngresoInventarioDominio {

    private UUID id;
    private SedeDominio sede;
    private LocalDateTime fechaLlegada;
    private BigDecimal total;
    private String estado;

    private IngresoInventarioDominio(Builder builder) {
        this.id = builder.id;
        this.sede = builder.sede;
        this.fechaLlegada = builder.fechaLlegada;
        this.total = builder.total;
        this.estado = builder.estado;
    }

    public UUID getId() {
        return id;
    }

    public SedeDominio getSede() {
        return sede;
    }

    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getEstado() {
        return estado;
    }

    public static class Builder {

        private UUID id;
        private SedeDominio sede;
        private LocalDateTime fechaLlegada;
        private BigDecimal total;
        private String estado;

        public Builder() {
            id = UtilUUID.obtenerUUIDDefecto();
            sede = new SedeDominio.Builder().build();
            fechaLlegada = UtilFecha.FECHA_HORA_DEFECTO;
            total = UtilNumero.CERO_DECIMAL;
            estado = "";
        }

        public Builder id(UUID id) {
            this.id = UtilUUID.obtenerValorDefecto(id);
            return this;
        }

        public Builder sede(SedeDominio sede) {
            this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                sede, new SedeDominio.Builder().build());
            return this;
        }
        
        public Builder fechaLlegada(LocalDateTime fechaLlegada) {

            if (UtilFecha.esFechaFutura(fechaLlegada)) {
                throw new IllegalArgumentException(
                    "La fecha de llegada no puede ser posterior a la fecha y hora actual");
            }

            this.fechaLlegada = UtilFecha.obtenerValorDefecto(fechaLlegada);
            return this;
        }

        // estado
        // total calculado

        public IngresoInventarioDominio build() {
            return new IngresoInventarioDominio(this);
        }
    }
}