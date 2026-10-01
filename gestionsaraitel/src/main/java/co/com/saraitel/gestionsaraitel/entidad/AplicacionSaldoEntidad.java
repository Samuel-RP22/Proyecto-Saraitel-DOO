package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

public class AplicacionSaldoEntidad {

	private UUID id;
	private SaldoFavorEntidad saldoFavor;
	private PagoEntidad pago;
	private BigDecimal valorAplicado;

	public AplicacionSaldoEntidad() {
		super();
	}

	public AplicacionSaldoEntidad(final UUID id, final SaldoFavorEntidad saldoFavor, final PagoEntidad pago,
			final BigDecimal valorAplicado) {
		super();
		setId(id);
		setSaldoFavor(saldoFavor);
		setPago(pago);
		setValorAplicado(valorAplicado);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public SaldoFavorEntidad getSaldoFavor() {
		return saldoFavor;
	}

	public void setSaldoFavor(final SaldoFavorEntidad saldoFavor) {
		this.saldoFavor = saldoFavor;
	}

	public PagoEntidad getPago() {
		return pago;
	}

	public void setPago(final PagoEntidad pago) {
		this.pago = pago;
	}

	public BigDecimal getValorAplicado() {
		return valorAplicado;
	}

	public void setValorAplicado(final BigDecimal valorAplicado) {
		this.valorAplicado = valorAplicado;
	}
}