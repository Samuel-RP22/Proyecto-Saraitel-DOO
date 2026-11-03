package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilBoolean;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProductoSedeEntidad {

	private UUID id;
	private ProductoEntidad producto;
	private SedeEntidad sede;
	private BigDecimal precio;
	private boolean tieneOferta;
	private int oferta;
	private BigDecimal precioTrasOferta;
	private int stock;
	private int stockGarantia;

	public ProductoSedeEntidad() {
		this(new Builder());
	}

	private ProductoSedeEntidad(final Builder builder) {
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
		private ProductoEntidad producto;
		private SedeEntidad sede;
		private BigDecimal precio;
		private Boolean tieneOferta;
		private Integer oferta = UtilNumero.CERO_INTEGER;
		private BigDecimal precioTrasOferta;
		private Integer stock;
		private Integer stockGarantia;

		public Builder() {
			this.id = UtilUUID.obtenerUUIDDefecto();
			this.producto = new ProductoEntidad();
			this.sede = new SedeEntidad();
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

		public ProductoSedeEntidad construir() {
			return new ProductoSedeEntidad(this);
		}
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ProductoEntidad getProducto() {
		return producto;
	}

	public void setProducto(final ProductoEntidad producto) {
		this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(producto, new ProductoEntidad());
	}

	public SedeEntidad getSede() {
		return sede;
	}

	public void setSede(final SedeEntidad sede) {
		this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(sede, new SedeEntidad());
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