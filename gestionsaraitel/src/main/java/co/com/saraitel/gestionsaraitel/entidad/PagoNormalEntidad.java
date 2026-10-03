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

	private PagoNormalEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setMetodoPago(builder.metodoPago);
		setPago(builder.pago);
		setMontoPagar(builder.montoPagar);
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

	public static class Builder {

		private UUID id;
		private MetodoPagoEntidad metodoPago;
		private PagoEntidad pago;
		private BigDecimal montoPagar;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder metodoPago(final MetodoPagoEntidad metodoPago) {
			this.metodoPago = metodoPago;
			return this;
		}

		public Builder pago(final PagoEntidad pago) {
			this.pago = pago;
			return this;
		}

		public Builder montoPagar(final BigDecimal montoPagar) {
			this.montoPagar = montoPagar;
			return this;
		}

		public PagoNormalEntidad build() {
			return new PagoNormalEntidad(this);
		}
	}
}