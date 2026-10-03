package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ProcesoCompraEntidad {

	private UUID id;
	private ClienteEntidad cliente;
	private EmpleadoEntidad empleado;
	private LocalDateTime fechainicio;
	private LocalDateTime fechaactualizacion;
	private BigDecimal totalcompra;
	private String estado;

	public ProcesoCompraEntidad() {
		super();
	}

	private ProcesoCompraEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setCliente(builder.cliente);
		setEmpleado(builder.empleado);
		setFechainicio(builder.fechainicio);
		setFechaactualizacion(builder.fechaactualizacion);
		setTotalcompra(builder.totalcompra);
		setEstado(builder.estado);
	}

	public static Builder builder() {
		return new Builder();
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

	public LocalDateTime getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(final LocalDateTime fechainicio) {
		this.fechainicio = fechainicio;
	}

	public LocalDateTime getFechaactualizacion() {
		return fechaactualizacion;
	}

	public void setFechaactualizacion(final LocalDateTime fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}

	public BigDecimal getTotalcompra() {
		return totalcompra;
	}

	public void setTotalcompra(final BigDecimal totalcompra) {
		this.totalcompra = totalcompra;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}

	public static class Builder {

		private UUID id;
		private ClienteEntidad cliente;
		private EmpleadoEntidad empleado;
		private LocalDateTime fechainicio;
		private LocalDateTime fechaactualizacion;
		private BigDecimal totalcompra;
		private String estado;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder cliente(final ClienteEntidad cliente) {
			this.cliente = cliente;
			return this;
		}

		public Builder empleado(final EmpleadoEntidad empleado) {
			this.empleado = empleado;
			return this;
		}

		public Builder fechainicio(final LocalDateTime fechainicio) {
			this.fechainicio = fechainicio;
			return this;
		}

		public Builder fechaactualizacion(final LocalDateTime fechaactualizacion) {
			this.fechaactualizacion = fechaactualizacion;
			return this;
		}

		public Builder totalcompra(final BigDecimal totalcompra) {
			this.totalcompra = totalcompra;
			return this;
		}

		public Builder estado(final String estado) {
			this.estado = estado;
			return this;
		}

		public ProcesoCompraEntidad build() {
			return new ProcesoCompraEntidad(this);
		}
	}
}