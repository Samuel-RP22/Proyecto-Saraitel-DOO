package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProcesoCompraEntidad {

	private UUID id;
	private ClienteEntidad cliente;
	private EmpleadoEntidad empleado;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaActualizacion;
	private BigDecimal total;
	private String estado;

	public ProcesoCompraEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCliente(new ClienteEntidad());
		setEmpleado(new EmpleadoEntidad());
		setFechaInicio(UtilFecha.FECHA_HORA_DEFECTO);
		setFechaActualizacion(UtilFecha.FECHA_HORA_DEFECTO);
		setTotal(UtilNumero.CERO_DECIMAL);
		setEstado(UtilTexto.VACIA);
	}

	public ProcesoCompraEntidad(final UUID id, final ClienteEntidad cliente, 
			final EmpleadoEntidad empleado, final LocalDateTime fechaInicio, 
			final LocalDateTime fechaActualizacion, 
			final BigDecimal total, final String estado) {
		setId(id);
		setCliente(cliente);
		setEmpleado(empleado);
		setFechaInicio(fechaInicio);
		setFechaActualizacion(fechaActualizacion);
		setTotal(total);
		setEstado(estado);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ClienteEntidad getCliente() {
		return cliente;
	}

	public void setCliente(final ClienteEntidad cliente) {
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(cliente, new ClienteEntidad());
	}

	public EmpleadoEntidad getEmpleado() {
		return empleado;
	}

	public void setEmpleado(final EmpleadoEntidad empleado) {
		this.empleado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(empleado, new EmpleadoEntidad());
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
	}
}