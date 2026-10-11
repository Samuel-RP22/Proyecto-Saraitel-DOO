package co.com.saraitel.gestionsaraitel.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;

public class CompraDominio {

    private UUID id;
    private ProcesoCompraDominio procesoCompra;
    private LocalDateTime fechaCompra;
    private String estado;

    public CompraDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.procesoCompra = new ProcesoCompraDominio();
        this.fechaCompra = UtilFecha.FECHA_HORA_DEFECTO;
        this.estado = UtilTexto.VACIA;
    }

    public CompraDominio(final UUID id, final ProcesoCompraDominio procesoCompra,
            final LocalDateTime fechaCompra, final String estado) {
        this.id = UtilUUID.obtenerValorDefecto(id);
        this.procesoCompra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
                (procesoCompra, new ProcesoCompraDominio());
        this.fechaCompra = UtilFecha.obtenerValorDefecto(fechaCompra);
        this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
    }

    public UUID getId() {
        return id;
    }

    public ProcesoCompraDominio getProcesoCompra() {
        return procesoCompra;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public String getEstado() {
        return estado;
    }
}