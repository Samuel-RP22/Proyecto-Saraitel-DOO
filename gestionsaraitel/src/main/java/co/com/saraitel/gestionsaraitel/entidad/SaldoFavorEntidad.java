package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

public class SaldoFavorEntidad {

	private UUID id;
	private DevolucionEntidad devolucion;
	private BigDecimal montoDisponible;
	private String estado;

	public SaldoFavorEntidad() {
		super();
	}

	private SaldoFavorEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setDevolucion(builder.devolucion);
		setMontoDisponible(builder.montoDisponible);
		setEstado(builder.estado);
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

	public DevolucionEntidad getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(final DevolucionEntidad devolucion) {
		this.devolucion = devolucion;
	}

	public BigDecimal getMontoDisponible() {
		return montoDisponible;
	}

	public void setMontoDisponible(final BigDecimal montoDisponible) {
		this.montoDisponible = montoDisponible;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}

	public static class Builder {

		private UUID id;
		private DevolucionEntidad devolucion;
		private BigDecimal montoDisponible;
		private String estado;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder devolucion(final DevolucionEntidad devolucion) {
			this.devolucion = devolucion;
			return this;
		}

		public Builder montoDisponible(final BigDecimal montoDisponible) {
			this.montoDisponible = montoDisponible;
			return this;
		}

		public Builder estado(final String estado) {
			this.estado = estado;
			return this;
		}

		public SaldoFavorEntidad build() {
			return new SaldoFavorEntidad(this);
		}
	}
}