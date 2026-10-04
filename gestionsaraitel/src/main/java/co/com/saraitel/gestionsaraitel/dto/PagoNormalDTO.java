package co.com.saraitel.gestionsaraitel.dto;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PagoNormalDTO {

	private UUID id;
	private MetodoPagoDTO metodoPago;
	private PagoDTO pago;
	private BigDecimal montoPagar;

	public PagoNormalDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setMetodoPago(new MetodoPagoDTO());
		setPago(new PagoDTO());
		setMontoPagar(UtilNumero.CERO_DECIMAL);
	}

	public PagoNormalDTO(final UUID id, final MetodoPagoDTO metodoPago,
			final PagoDTO pago, final BigDecimal montoPagar) {
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

	public MetodoPagoDTO getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(final MetodoPagoDTO metodoPago) {
		this.metodoPago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(metodoPago, new MetodoPagoDTO());
	}

	public PagoDTO getPago() {
		return pago;
	}

	public void setPago(final PagoDTO pago) {
		this.pago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(pago, new PagoDTO());
	}

	public BigDecimal getMontoPagar() {
		return montoPagar;
	}

	public void setMontoPagar(final BigDecimal montoPagar) {
		this.montoPagar = UtilNumero.obtenerValorDefecto(montoPagar);
	}
}