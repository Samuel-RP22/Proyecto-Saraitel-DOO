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

	private AplicacionSaldoEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setSaldoFavor(builder.saldoFavor);
		setPago(builder.pago);
		setValorAplicado(builder.valorAplicado);
	}

	public static Builder builder() {
		return new Builder();
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

	public static class Builder {

		private UUID id;
		private SaldoFavorEntidad saldoFavor;
		private PagoEntidad pago;
		private BigDecimal valorAplicado;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder saldoFavor(final SaldoFavorEntidad saldoFavor) {
			this.saldoFavor = saldoFavor;
			return this;
		}

		public Builder pago(final PagoEntidad pago) {
			this.pago = pago;
			return this;
		}

		public Builder valorAplicado(final BigDecimal valorAplicado) {
			this.valorAplicado = valorAplicado;
			return this;
		}

		public AplicacionSaldoEntidad build() {
			return new AplicacionSaldoEntidad(this);
		}
	}
}