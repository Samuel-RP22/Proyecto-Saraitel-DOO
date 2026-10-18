package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AplicacionSaldoDominio {

	private final UUID id;
	private final SaldoFavorDominio saldoFavor;
	private final PagoDominio pago;
	private final BigDecimal valorAplicado;

	public AplicacionSaldoDominio(final UUID id, final SaldoFavorDominio saldoFavor, final PagoDominio pago,
			final BigDecimal valorAplicado) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.saldoFavor = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(saldoFavor,
				SaldoFavorDominio.obtenerValorDefecto());
		this.pago = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pago, PagoDominio.obtenerValorDefecto());
		this.valorAplicado = UtilNumero.obtenerValorDefecto(valorAplicado);
	}

	public UUID getId() {
		return id;
	}

	public SaldoFavorDominio getSaldoFavor() {
		return saldoFavor;
	}

	public PagoDominio getPago() {
		return pago;
	}

	public BigDecimal getValorAplicado() {
		return valorAplicado;
	}
}