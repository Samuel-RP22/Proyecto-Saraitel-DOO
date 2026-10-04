package co.com.saraitel.gestionsaraitel.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PagoDTO {

	private UUID id;
	private CompraDTO compra;
	private BigDecimal montoPagado;
	private LocalDateTime fechaPago;

	public PagoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCompra(new CompraDTO());
		setMontoPagado(UtilNumero.CERO_DECIMAL);
		setFechaPago(UtilFecha.FECHA_HORA_DEFECTO);
	}

	public PagoDTO(final UUID id, final CompraDTO compra,
			final BigDecimal montoPagado, final LocalDateTime fechaPago) {
		setId(id);
		setCompra(compra);
		setMontoPagado(montoPagado);
		setFechaPago(fechaPago);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public CompraDTO getCompra() {
		return compra;
	}

	public void setCompra(final CompraDTO compra) {
		this.compra = UtilObjeto.esNulo(compra) ?
				new CompraDTO() : compra;
	}

	public BigDecimal getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(final BigDecimal montoPagado) {
		this.montoPagado = UtilNumero.obtenerValorDefecto(montoPagado);
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(final LocalDateTime fechaPago) {
		this.fechaPago = UtilFecha.obtenerValorDefecto(fechaPago);
	}
}