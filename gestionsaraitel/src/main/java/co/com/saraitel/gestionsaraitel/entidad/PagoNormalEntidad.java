package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

public class PagoNormalEntidad {

	private UUID id;
	private MetodoPagoEntidad metodoPago;
	private PagoEntidad pago;
	private BigDecimal montoPagar;

	public PagoNormalEntidad() {
		super();
	}

	public PagoNormalEntidad(final UUID id, final MetodoPagoEntidad metodoPago, final PagoEntidad pago,
			final BigDecimal montoPagar) {
		super();
		setId(id);
		setMetodoPago(metodoPago);
		setPago(pago);
		setMontoPagar(montoPagar);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public MetodoPagoEntidad getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(final MetodoPagoEntidad metodoPago) {
		this.metodoPago = metodoPago;
	}

	public PagoEntidad getPago() {
		return pago;
	}

	public void setPago(final PagoEntidad pago) {
		this.pago = pago;
	}

	public BigDecimal getMontoPagar() {
		return montoPagar;
	}

	public void setMontoPagar(final BigDecimal montoPagar) {
		this.montoPagar = montoPagar;
	}
}