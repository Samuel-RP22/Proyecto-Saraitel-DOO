package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

public class DetalleIngresoEntidad {

	private UUID id;
	private IngresoInventarioEntidad ingresoInventario;
	private ProductoSedeEntidad productoSede;
	private int cantidad;
	private BigDecimal costoUnitario;
	private BigDecimal subtotal;

	public DetalleIngresoEntidad() {
		super();
	}

	private DetalleIngresoEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setIngresoInventario(builder.ingresoInventario);
		setProductoSede(builder.productoSede);
		setCantidad(builder.cantidad);
		setCostoUnitario(builder.costoUnitario);
		setSubtotal(builder.subtotal);
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

	public IngresoInventarioEntidad getIngresoInventario() {
		return ingresoInventario;
	}

	public void setIngresoInventario(final IngresoInventarioEntidad ingresoInventario) {
		this.ingresoInventario = ingresoInventario;
	}

	public ProductoSedeEntidad getProductoSede() {
		return productoSede;
	}

	public void setProductoSede(final ProductoSedeEntidad productoSede) {
		this.productoSede = productoSede;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(final int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(final BigDecimal costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(final BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public static class Builder {

		private UUID id;
		private IngresoInventarioEntidad ingresoInventario;
		private ProductoSedeEntidad productoSede;
		private int cantidad;
		private BigDecimal costoUnitario;
		private BigDecimal subtotal;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder ingresoInventario(final IngresoInventarioEntidad ingresoInventario) {
			this.ingresoInventario = ingresoInventario;
			return this;
		}

		public Builder productoSede(final ProductoSedeEntidad productoSede) {
			this.productoSede = productoSede;
			return this;
		}

		public Builder cantidad(final int cantidad) {
			this.cantidad = cantidad;
			return this;
		}

		public Builder costoUnitario(final BigDecimal costoUnitario) {
			this.costoUnitario = costoUnitario;
			return this;
		}

		public Builder subtotal(final BigDecimal subtotal) {
			this.subtotal = subtotal;
			return this;
		}

		public DetalleIngresoEntidad build() {
			return new DetalleIngresoEntidad(this);
		}
	}
}