package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductoSedeEntidad {

	private UUID id;
	private ProductoEntidad producto;
	private SedeEntidad sede;
	private BigDecimal precio;
	private Boolean tieneOferta;
	private BigDecimal oferta;
	private BigDecimal precioTrasOferta;
	private Integer stock;
	private Integer stockGarantia;

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

	public Boolean getTieneOferta() {
		return tieneOferta;
	}

	public void setTieneOferta(final Boolean tieneOferta) {
		this.tieneOferta = tieneOferta;
	}

	public BigDecimal getOferta() {
		return oferta;
	}

	public void setOferta(final BigDecimal oferta) {
		this.oferta = oferta;
	}

	public BigDecimal getPrecioTrasOferta() {
		return precioTrasOferta;
	}

	public void setPrecioTrasOferta(final BigDecimal precioTrasOferta) {
		this.precioTrasOferta = precioTrasOferta;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(final Integer stock) {
		this.stock = stock;
	}

	public Integer getStockGarantia() {
		return stockGarantia;
	}

	public void setStockGarantia(final Integer stockGarantia) {
		this.stockGarantia = stockGarantia;
	}

	public static class Builder {

		private UUID id;
		private ProductoEntidad producto;
		private SedeEntidad sede;
		private BigDecimal precio;
		private Boolean tieneOferta;
		private BigDecimal oferta;
		private BigDecimal precioTrasOferta;
		private Integer stock;
		private Integer stockGarantia;

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

		public Builder tieneOferta(final Boolean tieneOferta) {
			this.tieneOferta = tieneOferta;
			return this;
		}

		public Builder oferta(final BigDecimal oferta) {
			this.oferta = oferta;
			return this;
		}

		public Builder precioTrasOferta(final BigDecimal precioTrasOferta) {
			this.precioTrasOferta = precioTrasOferta;
			return this;
		}

		public Builder stock(final Integer stock) {
			this.stock = stock;
			return this;
		}

		public Builder stockGarantia(final Integer stockGarantia) {
			this.stockGarantia = stockGarantia;
			return this;
		}

		public ProductoSedeEntidad build() {
			return new ProductoSedeEntidad(this);
		}
	}
}