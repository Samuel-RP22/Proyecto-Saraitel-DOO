package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PagoEntidad {

	private UUID id;
	private CompraEntidad compra;
	private BigDecimal montoPagado;
	private LocalDateTime fechaPago;

	public PagoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCompra(new CompraEntidad());
		setMontoPagado(UtilNumero.CERO_DECIMAL);
		setFechaPago(UtilFecha.FECHA_HORA_DEFECTO);
	}

	public PagoEntidad(final UUID id, final CompraEntidad compra,
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

	public CompraEntidad getCompra() {
		return compra;
	}

	public void setCompra(final CompraEntidad compra) {
		this.compra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(compra, new CompraEntidad());
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