package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductoSedeEntidad {

	private UUID id;
	private ProductoEntidad producto;
	private SedeEntidad sede;
	private BigDecimal precio;
	private Boolean tieneOferta;
	private int oferta;
	private BigDecimal precioTrasOferta;
	private int stock;
	private int stockGarantia;

	public ProductoSedeEntidad() {
		super();
	}

	private ProductoSedeEntidad(final Builder builder) {
		super();
		setId(builder.id);
		setProducto(builder.producto);
		setSede(builder.sede);
		setPrecio(builder.precio);
		setTieneOferta(builder.tieneOferta);
		setOferta(builder.oferta);
		setPrecioTrasOferta(builder.precioTrasOferta);
		setStock(builder.stock);
		setStockGarantia(builder.stockGarantia);
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

	public ProductoEntidad getProducto() {
		return producto;
	}

	public void setProducto(final ProductoEntidad producto) {
		this.producto = producto;
	}

	public SedeEntidad getSede() {
		return sede;
	}

	public void setSede(final SedeEntidad sede) {
		this.sede = sede;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(final BigDecimal precio) {
		this.precio = precio;
	}

	public boolean getTieneOferta() {
		return tieneOferta;
	}

	public void setTieneOferta(final boolean tieneOferta) {
		this.tieneOferta = tieneOferta;
	}

	public int getOferta() {
		return oferta;
	}

	public void setOferta(final int oferta) {
		this.oferta = oferta;
	}

	public BigDecimal getPrecioTrasOferta() {
		return precioTrasOferta;
	}

	public void setPrecioTrasOferta(final BigDecimal precioTrasOferta) {
		this.precioTrasOferta = precioTrasOferta;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(final int stock) {
		this.stock = stock;
	}

	public int getStockGarantia() {
		return stockGarantia;
	}

	public void setStockGarantia(final int stockGarantia) {
		this.stockGarantia = stockGarantia;
	}

	public static class Builder {

		private UUID id;
		private ProductoEntidad producto;
		private SedeEntidad sede;
		private BigDecimal precio;
		private boolean tieneOferta;
		private int oferta;
		private BigDecimal precioTrasOferta;
		private int stock;
		private int stockGarantia;

		private Builder() {
			super();
		}

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder producto(final ProductoEntidad producto) {
			this.producto = producto;
			return this;
		}

		public Builder sede(final SedeEntidad sede) {
			this.sede = sede;
			return this;
		}

		public Builder precio(final BigDecimal precio) {
			this.precio = precio;
			return this;
		}

		public Builder tieneOferta(final boolean tieneOferta) {
			this.tieneOferta = tieneOferta;
			return this;
		}

		public Builder oferta(final int oferta) {
			this.oferta = oferta;
			return this;
		}

		public Builder precioTrasOferta(final BigDecimal precioTrasOferta) {
			this.precioTrasOferta = precioTrasOferta;
			return this;
		}

		public Builder stock(final int stock) {
			this.stock = stock;
			return this;
		}

		public Builder stockGarantia(final int stockGarantia) {
			this.stockGarantia = stockGarantia;
			return this;
		}

		public ProductoSedeEntidad build() {
			return new ProductoSedeEntidad(this);
		}
	}
}