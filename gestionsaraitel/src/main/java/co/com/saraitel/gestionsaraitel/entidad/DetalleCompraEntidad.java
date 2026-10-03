package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

public class DetalleCompraEntidad {

	private UUID id;
	private ProcesoCompraEntidad procesoCompra;
	private ProductoSedeEntidad productoSede;
	private int cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal subtotal;

	public DetalleCompraEntidad() {
		super();
	}

	private DetalleCompraEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setProcesoCompra(builder.procesoCompra);
		setProductoSede(builder.productoSede);
		setCantidad(builder.cantidad);
		setPrecioUnitario(builder.precioUnitario);
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

	public ProcesoCompraEntidad getProcesoCompra() {
		return procesoCompra;
	}

	public void setProcesoCompra(final ProcesoCompraEntidad procesoCompra) {
		this.procesoCompra = procesoCompra;
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

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(final BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(final BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public static class Builder {

		private UUID id;
		private ProcesoCompraEntidad procesoCompra;
		private ProductoSedeEntidad productoSede;
		private int cantidad;
		private BigDecimal precioUnitario;
		private BigDecimal subtotal;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder procesoCompra(final ProcesoCompraEntidad procesoCompra) {
			this.procesoCompra = procesoCompra;
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

		public Builder precioUnitario(final BigDecimal precioUnitario) {
			this.precioUnitario = precioUnitario;
			return this;
		}

		public Builder subtotal(final BigDecimal subtotal) {
			this.subtotal = subtotal;
			return this;
		}

		public DetalleCompraEntidad build() {
			return new DetalleCompraEntidad(this);
		}
	}
}