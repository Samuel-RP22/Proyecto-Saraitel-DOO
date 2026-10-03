package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class IngresoInventarioEntidad {

	private UUID id;
	private String estado;
	private SedeEntidad sede;
	private LocalDateTime fechallegada;
	private BigDecimal total;

	public IngresoInventarioEntidad() {
		super();
	}

	private IngresoInventarioEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setEstado(builder.estado);
		setSede(builder.sede);
		setFechallegada(builder.fechallegada);
		setTotal(builder.total);
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}

	public SedeEntidad getSede() {
		return sede;
	}

	public void setSede(final SedeEntidad sede) {
		this.sede = sede;
	}

	public LocalDateTime getFechallegada() {
		return fechallegada;
	}

	public void setFechallegada(final LocalDateTime fechallegada) {
		this.fechallegada = fechallegada;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(final BigDecimal total) {
		this.total = total;
	}

	public static class Builder {

		private UUID id;
		private String estado;
		private SedeEntidad sede;
		private LocalDateTime fechallegada;
		private BigDecimal total;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder estado(final String estado) {
			this.estado = estado;
			return this;
		}

		public Builder sede(final SedeEntidad sede) {
			this.sede = sede;
			return this;
		}

		public Builder fechallegada(final LocalDateTime fechallegada) {
			this.fechallegada = fechallegada;
			return this;
		}

		public Builder total(final BigDecimal total) {
			this.total = total;
			return this;
		}

		public IngresoInventarioEntidad build() {
			return new IngresoInventarioEntidad(this);
		}
	}
}