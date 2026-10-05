package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PagoNormalEntidad {

	private UUID id;
	private MetodoPagoEntidad metodoPago;
	private PagoEntidad pago;
	private BigDecimal montoPagar;

	public PagoNormalEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setMetodoPago(new MetodoPagoEntidad());
		setPago(new PagoEntidad());
		setMontoPagar(UtilNumero.CERO_DECIMAL);
	}

	public PagoNormalEntidad(final UUID id, final MetodoPagoEntidad metodoPago,
			final PagoEntidad pago, final BigDecimal montoPagar) {
		setId(id);
		setMetodoPago(metodoPago);
		setPago(pago);
		setMontoPagar(montoPagar);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public MetodoPagoEntidad getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(final MetodoPagoEntidad metodoPago) {
		this.metodoPago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(metodoPago, new MetodoPagoEntidad());
	}

	public PagoEntidad getPago() {
		return pago;
	}

	public void setPago(final PagoEntidad pago) {
		this.pago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(pago, new PagoEntidad());
	}

	public BigDecimal getMontoPagar() {
		return montoPagar;
	}

	public void setMontoPagar(final BigDecimal montoPagar) {
		this.montoPagar = UtilNumero.obtenerValorDefecto(montoPagar);
	}
}