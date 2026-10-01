package co.com.saraitel.gestionsaraitel.entidad;

import java.util.Date;
import java.util.UUID;

public class ProcesoCompraEntidad {

	private UUID id;
	private ClienteEntidad cliente;
	private EmpleadoEntidad empleado;
	private Date fechainicio;
	private Date fechaactualizacion;
	private Double totalcompra;
	private String estado;

	public ProcesoCompraEntidad() {
		super();
	}

	public ProcesoCompraEntidad(final UUID id, final ClienteEntidad cliente, final EmpleadoEntidad empleado,
			final Date fechainicio, final Date fechaactualizacion, final Double totalcompra, final String estado) {
		super();
		setId(id);
		setCliente(cliente);
		setEmpleado(empleado);
		setFechainicio(fechainicio);
		setFechaactualizacion(fechaactualizacion);
		setTotalcompra(totalcompra);
		setEstado(estado);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public ClienteEntidad getCliente() {
		return cliente;
	}

	public void setCliente(final ClienteEntidad cliente) {
		this.cliente = cliente;
	}

	public EmpleadoEntidad getEmpleado() {
		return empleado;
	}

	public void setEmpleado(final EmpleadoEntidad empleado) {
		this.empleado = empleado;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(final Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechaactualizacion() {
		return fechaactualizacion;
	}

	public void setFechaactualizacion(final Date fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	public Double getTotalcompra() {
		return totalcompra;
	}

	public void setTotalcompra(final Double totalcompra) {
		this.totalcompra = totalcompra;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}
}