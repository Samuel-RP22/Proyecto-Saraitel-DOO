package co.com.saraitel.gestionsaraitel.dto;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProductoSedeDTO {

	private UUID id;
	private ProductoDTO producto;
	private SedeDTO sede;
	private BigDecimal precio;
	private boolean tieneOferta;
	private int oferta;
	private BigDecimal precioTrasOferta;
	private int stock;
	private int stockGarantia;

	public ProductoSedeDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setProducto(new ProductoDTO());
		setSede(new SedeDTO());
		setPrecio(UtilNumero.CERO_DECIMAL);
		setTieneOferta(false);
		setOferta(0);
		setPrecioTrasOferta(UtilNumero.CERO_DECIMAL);
		setStock(0);
		setStockGarantia(0);
	}

	private ProductoSedeDTO(final Builder builder) {
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

	public static Builder build() {
		return new Builder();
	}

	public static final class Builder {

		private UUID id = UtilUUID.obtenerUUIDDefecto();
		private ProductoDTO producto = new ProductoDTO();
		private SedeDTO sede = new SedeDTO();
		private BigDecimal precio = UtilNumero.CERO_DECIMAL;
		private boolean tieneOferta = false;
		private int oferta = 0;
		private BigDecimal precioTrasOferta = UtilNumero.CERO_DECIMAL;
		private int stock = 0;
		private int stockGarantia = 0;

		public Builder id(final UUID id) {
			this.id = id;
			return this;
		}

		public Builder producto(final ProductoDTO producto) {
			this.producto = producto;
			return this;
		}

		public Builder sede(final SedeDTO sede) {
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

		public ProductoSedeDTO construir() {
			return new ProductoSedeDTO(this);
		}
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ProductoDTO getProducto() {
		return producto;
	}

	public void setProducto(final ProductoDTO producto) {
		this.producto = UtilObjeto.esNulo(producto) ?
				new ProductoDTO() : producto;
	}

	public SedeDTO getSede() {
		return sede;
	}

	public void setSede(final SedeDTO sede) {
		this.sede = UtilObjeto.esNulo(sede) ?
				new SedeDTO() : sede;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(final BigDecimal precio) {
		this.precio = UtilNumero.obtenerValorDefecto(precio);
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
		this.precioTrasOferta = UtilNumero.obtenerValorDefecto(precioTrasOferta);
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
}