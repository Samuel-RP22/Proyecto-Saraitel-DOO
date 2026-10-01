package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class DevolucionEntidad {

	private UUID id;
	private DetalleCompraEntidad detalleCompra;
	private String motivo;
	private LocalDate fechaDevolucion;
	private Integer cantidad;
	private BigDecimal montoDevolucion;
	private String estado;

	public DevolucionEntidad() {
		super();
	}

	public DevolucionEntidad(final UUID id, final DetalleCompraEntidad detalleCompra, final String motivo,
			final LocalDate fechaDevolucion, final int cantidad, final BigDecimal montoDevolucion,
			final String estado) {
		super();
		setId(id);
		setDetalleCompra(detalleCompra);
		setMotivo(motivo);
		setFechaDevolucion(fechaDevolucion);
		setCantidad(cantidad);
		setMontoDevolucion(montoDevolucion);
		setEstado(estado);
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

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(final LocalDate fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(final int cantidad) {
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
}