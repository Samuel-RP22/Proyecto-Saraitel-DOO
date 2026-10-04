package co.com.saraitel.gestionsaraitel.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DevolucionDTO {

	private UUID id;
	private DetalleCompraDTO detalleCompra;
	private MotivoDTO motivo;
	private LocalDateTime fechaDevolucion;
	private int cantidad;
	private BigDecimal montoDevolucion;
	private String estado;

	public DevolucionDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setDetalleCompra(new DetalleCompraDTO());
		setMotivo(new MotivoDTO());
		setFechaDevolucion(UtilFecha.FECHA_HORA_DEFECTO);
		setCantidad(1);
		setMontoDevolucion(UtilNumero.CERO_DECIMAL);
		setEstado(UtilTexto.VACIA);
	}

	public DevolucionDTO(final UUID id, final DetalleCompraDTO detalleCompra,
			final MotivoDTO motivo, final LocalDateTime fechaDevolucion,
			final int cantidad, final BigDecimal montoDevolucion, final String estado) {
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
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public DetalleCompraDTO getDetalleCompra() {
		return detalleCompra;
	}

	public void setDetalleCompra(final DetalleCompraDTO detalleCompra) {
		this.detalleCompra = UtilObjeto.esNulo(detalleCompra) ?
				new DetalleCompraDTO() : detalleCompra;
	}

	public MotivoDTO getMotivo() {
		return motivo;
	}

	public void setMotivo(final MotivoDTO motivo) {
		this.motivo = UtilObjeto.esNulo(motivo) ?
				new MotivoDTO() : motivo;
	}

	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(final LocalDateTime fechaDevolucion) {
		this.fechaDevolucion = UtilFecha.obtenerValorDefecto(fechaDevolucion);
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
		this.montoDevolucion = UtilNumero.obtenerValorDefecto(montoDevolucion);
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
	}
}