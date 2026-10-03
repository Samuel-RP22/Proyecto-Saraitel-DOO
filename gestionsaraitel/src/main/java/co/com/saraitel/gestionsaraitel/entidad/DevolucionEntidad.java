package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class DevolucionEntidad {

	private UUID id;
	private DetalleCompraEntidad detalleCompra;
	private String motivo;
	private LocalDateTime fechaDevolucion;
	private int cantidad;
	private BigDecimal montoDevolucion;
	private String estado;

	public DevolucionEntidad() {
		super();
	}

	private DevolucionEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setDetalleCompra(builder.detalleCompra);
		setMotivo(builder.motivo);
		setFechaDevolucion(builder.fechaDevolucion);
		setCantidad(builder.cantidad);
		setMontoDevolucion(builder.montoDevolucion);
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

	public DetalleCompraEntidad getDetalleCompra() {
		return detalleCompra;
	}

	public void setDetalleCompra(final DetalleCompraEntidad detalleCompra) {
		this.detalleCompra = detalleCompra;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(final String motivo) {
		this.motivo = motivo;
	}

	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(final LocalDateTime fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(final Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getMontoDevolucion() {
		return montoDevolucion;
	}

	public void setMontoDevolucion(final BigDecimal montoDevolucion) {
		this.montoDevolucion = montoDevolucion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}

	public static class Builder {

		private UUID id;
		private DetalleCompraEntidad detalleCompra;
		private String motivo;
		private LocalDateTime fechaDevolucion;
		private int cantidad;
		private BigDecimal montoDevolucion;
		private String estado;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder detalleCompra(final DetalleCompraEntidad detalleCompra) {
			this.detalleCompra = detalleCompra;
			return this;
		}

		public Builder motivo(final String motivo) {
			this.motivo = motivo;
			return this;
		}

		public Builder fechaDevolucion(final LocalDateTime fechaDevolucion) {
			this.fechaDevolucion = fechaDevolucion;
			return this;
		}

		public Builder cantidad(final int cantidad) {
			this.cantidad = cantidad;
			return this;
		}

		public Builder montoDevolucion(final BigDecimal montoDevolucion) {
			this.montoDevolucion = montoDevolucion;
			return this;
		}

		public Builder estado(final String estado) {
			this.estado = estado;
			return this;
		}

		public DevolucionEntidad build() {
			return new DevolucionEntidad(this);
		}
	}
}