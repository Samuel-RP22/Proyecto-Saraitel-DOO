package co.com.saraitel.gestionsaraitel.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class FacturaDominio {

    private UUID id;
    private CompraDominio compra;
    private LocalDateTime fechaEmision;

    public FacturaDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.compra = new CompraDominio();
        this.fechaEmision = UtilFecha.FECHA_HORA_DEFECTO;
    }

    public FacturaDominio(final UUID id, final CompraDominio compra,
            final LocalDateTime fechaEmision) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.compra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                compra, new CompraDominio());
        this.fechaEmision = UtilFecha.obtenerValorDefecto(fechaEmision);
    }

    public UUID getId() {
        return id;
    }

    public CompraDominio getCompra() {
        return compra;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }
}