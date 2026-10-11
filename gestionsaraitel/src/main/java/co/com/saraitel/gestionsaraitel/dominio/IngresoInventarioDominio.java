package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class IngresoInventarioDominio {

    private UUID id;
    private SedeDominio sede;
    private LocalDateTime fechaLlegada;
    private BigDecimal total;
    private String estado;

    public IngresoInventarioDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.sede = new SedeDominio();
        this.fechaLlegada = UtilFecha.FECHA_HORA_DEFECTO;
        this.total = UtilNumero.CERO_DECIMAL;
        this.estado = UtilTexto.VACIA;
    }

    public IngresoInventarioDominio(final UUID id, final SedeDominio sede,
            final LocalDateTime fechaLlegada, final BigDecimal total,
            final String estado) {

        this.id = UtilUUID.obtenerValorDefecto(id);
        this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                sede, new SedeDominio());
        
        if (UtilFecha.esFechaFutura(fechaLlegada)) {
            throw new IllegalArgumentException(
                    "La fecha de llegada no puede ser posterior a la fecha y hora actual");
        }

        this.fechaLlegada = UtilFecha.obtenerValorDefecto(fechaLlegada);
        this.total = UtilNumero.obtenerValorDefecto(total);
        this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
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
}
