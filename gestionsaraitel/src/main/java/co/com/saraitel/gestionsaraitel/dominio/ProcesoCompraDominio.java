package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProcesoCompraDominio {

    private UUID id;
    private ClienteDominio cliente;
    private EmpleadoDominio empleado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaActualizacion;
    private BigDecimal totalCompra;
    private String estado;

    public ProcesoCompraDominio() {
        this.id = UtilUUID.obtenerUUIDDefecto();
        this.cliente = new ClienteDominio();
        this.empleado = new EmpleadoDominio();
        this.fechaInicio = UtilFecha.FECHA_HORA_DEFECTO;
        this.fechaActualizacion = UtilFecha.FECHA_HORA_DEFECTO;
        this.totalCompra = UtilNumero.CERO_DECIMAL;
        this.estado = UtilTexto.VACIA;
    }

    public ProcesoCompraDominio(final UUID id, final ClienteDominio cliente,
            final EmpleadoDominio empleado, final LocalDateTime fechaInicio,
            final LocalDateTime fechaActualizacion, final BigDecimal totalCompra,
            final String estado) {

        this.id = UtilUUID.obtenerValorDefecto(id);
        this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                cliente, new ClienteDominio());
        this.empleado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                empleado, new EmpleadoDominio());
        this.fechaInicio = UtilFecha.obtenerValorDefecto(fechaInicio);
        this.fechaActualizacion = UtilFecha.obtenerValorDefecto(fechaActualizacion);
        this.totalCompra = UtilNumero.obtenerValorDefecto(totalCompra);
        this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
    }

    public UUID getId() {
        return id;
    }

    public ClienteDominio getCliente() {
        return cliente;
    }

    public EmpleadoDominio getEmpleado() {
        return empleado;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public BigDecimal getTotalCompra() {
        return totalCompra;
    }

    public String getEstado() {
        return estado;
    }
}
