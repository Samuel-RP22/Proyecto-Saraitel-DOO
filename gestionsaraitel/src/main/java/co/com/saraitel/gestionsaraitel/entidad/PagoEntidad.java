package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PagoEntidad {

	private UUID id;
	private ProcesoCompraEntidad compra;
	private BigDecimal montopendiente;
	private LocalDateTime fechapago;

	public PagoEntidad() {
		super();
	}

	private PagoEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setCompra(builder.compra);
		setMontopendiente(builder.montopendiente);
		setFechapago(builder.fechapago);
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

	public ProcesoCompraEntidad getCompra() {
		return compra;
	}

	public void setCompra(final ProcesoCompraEntidad compra) {
		this.compra = compra;
	}

	public BigDecimal getMontopendiente() {
		return montopendiente;
	}

	public void setMontopendiente(final BigDecimal montopendiente) {
		this.montopendiente = montopendiente;
	}

	public LocalDateTime getFechapago() {
		return fechapago;
	}

	public void setFechapago(final LocalDateTime fechapago) {
		this.fechapago = fechapago;
	}

	public static class Builder {

		private UUID id;
		private ProcesoCompraEntidad compra;
		private BigDecimal montopendiente;
		private LocalDateTime fechapago;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder compra(final ProcesoCompraEntidad compra) {
			this.compra = compra;
			return this;
		}

		public Builder montopendiente(final BigDecimal montopendiente) {
			this.montopendiente = montopendiente;
			return this;
		}

		public Builder fechapago(final LocalDateTime fechapago) {
			this.fechapago = fechapago;
			return this;
		}

		public PagoEntidad build() {
			return new PagoEntidad(this);
		}
	}
}