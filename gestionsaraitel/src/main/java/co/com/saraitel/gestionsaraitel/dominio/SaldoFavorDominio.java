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

    public SaldoFavorDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.devolucion = new DevolucionDominio();
        this.montoUsado = UtilNumero.CERO_DECIMAL;
        this.estado = UtilTexto.VACIA;
    }

    public SaldoFavorDominio(final UUID id, final DevolucionDominio devolucion,
            final BigDecimal montoUsado, final String estado) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.devolucion = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                devolucion, new DevolucionDominio());
        this.montoUsado = UtilNumero.obtenerValorDefecto(montoUsado);
        this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
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
}
