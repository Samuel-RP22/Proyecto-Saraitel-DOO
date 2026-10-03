package co.com.saraitel.gestionsaraitel.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

public class FacturaEntidad {

	private UUID id;
	private ProcesoCompraEntidad compra;
	private LocalDateTime fechaemision;

	public FacturaEntidad() {
		super();
	}

	private FacturaEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setCompra(builder.compra);
		setFechaemision(builder.fechaemision);
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

	public LocalDateTime getFechaemision() {
		return fechaemision;
	}

	public void setFechaemision(final LocalDateTime fechaemision) {
		this.fechaemision = fechaemision;
	}

	public static class Builder {

		private UUID id;
		private ProcesoCompraEntidad compra;
		private LocalDateTime fechaemision;

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

		public Builder fechaemision(final LocalDateTime fechaemision) {
			this.fechaemision = fechaemision;
			return this;
		}

		public FacturaEntidad build() {
			return new FacturaEntidad(this);
		}
	}
}