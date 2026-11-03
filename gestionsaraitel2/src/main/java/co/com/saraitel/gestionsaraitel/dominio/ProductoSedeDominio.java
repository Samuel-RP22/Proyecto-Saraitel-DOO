package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilBoolean;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProductoSedeDominio {

	private final UUID id;
	private final ProductoDominio producto;
	private final SedeDominio sede;
	private final BigDecimal precio;
	private final boolean tieneOferta;
	private final int oferta;
	private final BigDecimal precioTrasOferta;
	private final int stock;
	private final int stockGarantia;

	private ProductoSedeDominio(final Builder builder) {
		this.id = UtilUUID.obtenerValorDefecto(builder.id);
		this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(builder.producto,
				ProductoDominio.obtenerValorDefecto());
		this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(builder.sede,
				SedeDominio.obtenerValorDefecto());
		this.precio = UtilNumero.obtenerValorDefecto(builder.precio);
		this.tieneOferta = UtilBoolean.obtenerValorDefectoFalso(builder.tieneOferta);
		this.oferta = UtilNumero.obtenerValorDefecto(builder.oferta);
		this.precioTrasOferta = UtilNumero.obtenerValorDefecto(builder.precioTrasOferta);
		this.stock = UtilNumero.obtenerValorDefecto(builder.stock);
		this.stockGarantia = UtilNumero.obtenerValorDefecto(builder.stockGarantia);
	}

	public static ProductoSedeDominio obtenerValorDefecto() {
		return new Builder().construir();
	}

	public static final class Builder {

		private UUID id;
		private ProductoDominio producto;
		private SedeDominio sede;
		private BigDecimal precio;
		private Boolean tieneOferta;
		private Integer oferta;
		private BigDecimal precioTrasOferta;
		private Integer stock;
		private Integer stockGarantia;

		public Builder() {
			this.id = UtilUUID.obtenerUUIDDefecto();
			this.producto = ProductoDominio.obtenerValorDefecto();
			this.sede = SedeDominio.obtenerValorDefecto();
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

		public Builder producto(final ProductoDominio producto) {
			this.producto = producto;
			return this;
		}

		public Builder sede(final SedeDominio sede) {
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

		public ProductoSedeDominio construir() {
			return new ProductoSedeDominio(this);
		}
	}

	public UUID getId() {
		return id;
	}

	public ProductoDominio getProducto() {
		return producto;
	}

	public SedeDominio getSede() {
		return sede;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public boolean getTieneOferta() {
		return tieneOferta;
	}

	public int getOferta() {
		return oferta;
	}

	public BigDecimal getPrecioTrasOferta() {
		return precioTrasOferta;
	}

	public int getStock() {
		return stock;
	}

	public int getStockGarantia() {
		return stockGarantia;
	}
}