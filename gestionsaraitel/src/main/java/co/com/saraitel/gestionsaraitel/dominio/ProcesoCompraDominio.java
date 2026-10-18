package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProcesoCompraDominio {

	private final UUID id;
	private final ClienteDominio cliente;
	private final EmpleadoDominio empleado;
	private final EstadoProcesoCompraDominio estado;
	private final LocalDateTime fechaInicio;
	private final LocalDateTime fechaActualizacion;
	private final BigDecimal total;

	public ProcesoCompraDominio(final UUID id, final ClienteDominio cliente, final EmpleadoDominio empleado,
			final EstadoProcesoCompraDominio estado, final LocalDateTime fechaInicio,
			final LocalDateTime fechaActualizacion, final BigDecimal total) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente,
				ClienteDominio.obtenerValorDefecto());
		this.empleado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(empleado,
				EmpleadoDominio.obtenerValorDefecto());
		this.estado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estado,
				EstadoProcesoCompraDominio.obtenerValorDefecto());
		this.fechaInicio = UtilFecha.obtenerValorDefecto(fechaInicio);
		this.fechaActualizacion = UtilFecha.obtenerValorDefecto(fechaActualizacion);
		this.total = UtilNumero.obtenerValorDefecto(total);
	}

	public static ProcesoCompraDominio obtenerValorDefecto() {
		return new ProcesoCompraDominio(UtilUUID.obtenerUUIDDefecto(), ClienteDominio.obtenerValorDefecto(),
				EmpleadoDominio.obtenerValorDefecto(), EstadoProcesoCompraDominio.obtenerValorDefecto(),
				UtilFecha.FECHA_HORA_DEFECTO, UtilFecha.FECHA_HORA_DEFECTO, UtilNumero.CERO_DECIMAL);
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

	public EstadoProcesoCompraDominio getEstado() {
		return estado;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public BigDecimal getTotal() {
		return total;
	}
}