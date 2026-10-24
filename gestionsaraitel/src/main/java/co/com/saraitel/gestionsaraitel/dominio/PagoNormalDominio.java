package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PagoNormalDominio {

	private final UUID id;
	private final MetodoPagoDominio metodoPago;
	private final PagoDominio pago;
	private final BigDecimal montoPagar;

	public PagoNormalDominio(final UUID id, final MetodoPagoDominio metodoPago, final PagoDominio pago,
			final BigDecimal montoPagar) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.metodoPago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(metodoPago,
				MetodoPagoDominio.obtenerValorDefecto());
		this.pago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pago, PagoDominio.obtenerValorDefecto());
		this.montoPagar = UtilNumero.obtenerValorDefecto(montoPagar);
	}

	public static PagoNormalDominio obtenerValorDefecto() {
		return new PagoNormalDominio(UtilUUID.obtenerUUIDDefecto(), MetodoPagoDominio.obtenerValorDefecto(),
				PagoDominio.obtenerValorDefecto(), UtilNumero.CERO_DECIMAL);
	}

	public UUID getId() {
		return id;
	}

	public MetodoPagoDominio getMetodoPago() {
		return metodoPago;
	}

	public PagoDominio getPago() {
		return pago;
	}

	public BigDecimal getMontoPagar() {
		return montoPagar;
	}
}
