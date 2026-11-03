package co.com.saraitel.gestionsaraitel.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProcesoCompraDTO {

	private UUID id;
	private ClienteDTO cliente;
	private EmpleadoDTO empleado;
	private EstadoProcesoCompraDTO estado;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaActualizacion;
	private BigDecimal total;

	public ProcesoCompraDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteDTO());
		setEmpleado(new EmpleadoDTO());
		setEstado(new EstadoProcesoCompraDTO());
		setFechaInicio(UtilFecha.FECHA_HORA_DEFECTO);
		setFechaActualizacion(UtilFecha.FECHA_HORA_DEFECTO);
		setTotal(UtilNumero.CERO_DECIMAL);
	}

	public ProcesoCompraDTO(final UUID id, final ClienteDTO cliente, final EmpleadoDTO empleado,
			final EstadoProcesoCompraDTO estado, final LocalDateTime fechaInicio,
			final LocalDateTime fechaActualizacion, final BigDecimal total) {
		setId(id);
		setCliente(cliente);
		setEmpleado(empleado);
		setEstado(estado);
		setFechaInicio(fechaInicio);
		setFechaActualizacion(fechaActualizacion);
		setTotal(total);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(final ClienteDTO cliente) {
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteDTO());
	}

	public EmpleadoDTO getEmpleado() {
		return empleado;
	}

	public void setEmpleado(final EmpleadoDTO empleado) {
		this.empleado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(empleado, new EmpleadoDTO());
	}

	public EstadoProcesoCompraDTO getEstado() {
		return estado;
	}

	public void setEstado(final EstadoProcesoCompraDTO estado) {
		this.estado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estado, new EstadoProcesoCompraDTO());
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(final LocalDateTime fechaInicio) {
		this.fechaInicio = UtilFecha.obtenerValorDefecto(fechaInicio);
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(final LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = UtilFecha.obtenerValorDefecto(fechaActualizacion);
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(final BigDecimal total) {
		this.total = UtilNumero.obtenerValorDefecto(total);
	}
}