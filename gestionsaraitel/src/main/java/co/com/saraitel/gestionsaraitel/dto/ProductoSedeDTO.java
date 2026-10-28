package co.com.saraitel.gestionsaraitel.dto;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilBoolean;
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
		this(new Builder());
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

	public static final class Builder {

		private UUID id;
		private ProductoDTO producto;
		private SedeDTO sede;
		private BigDecimal precio;
		private Boolean tieneOferta;
		private Integer oferta = UtilNumero.CERO_INTEGER;
		private BigDecimal precioTrasOferta;
		private Integer stock;
		private Integer stockGarantia;

		public Builder() {
			this.id = UtilUUID.obtenerUUIDDefecto();
			this.producto = new ProductoDTO();
			this.sede = new SedeDTO();
			this.precio = UtilNumero.CERO_DECIMAL;
			this.tieneOferta = false;
			this.oferta = UtilNumero.CERO_INTEGER;
			this.precioTrasOferta = UtilNumero.CERO_DECIMAL;
			this.stock = UtilNumero.CERO_INTEGER;
			this.stockGarantia = UtilNumero.CERO_INTEGER;
		}

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

		public Builder tieneOferta(final Boolean tieneOferta) {
			this.tieneOferta = tieneOferta;
			return this;
		}

		public Builder oferta(final Integer oferta) {
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
		this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(producto, new ProductoDTO());
	}

	public SedeDTO getSede() {
		return sede;
	}

	public void setSede(final SedeDTO sede) {
		this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(sede, new SedeDTO());
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

	public void setTieneOferta(final Boolean tieneOferta) {
		this.tieneOferta = UtilBoolean.obtenerValorDefectoFalso(tieneOferta);
	}

	public int getOferta() {
		return oferta;
	}

	public void setOferta(final Integer oferta) {
		this.oferta = UtilNumero.obtenerValorDefecto(oferta);
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

	public void setStock(final Integer stock) {
		this.stock = UtilNumero.obtenerValorDefecto(stock);
	}

	public int getStockGarantia() {
		return stockGarantia;
	}

	public void setStockGarantia(final Integer stockGarantia) {
		this.stockGarantia = UtilNumero.obtenerValorDefecto(stockGarantia);
	}
}