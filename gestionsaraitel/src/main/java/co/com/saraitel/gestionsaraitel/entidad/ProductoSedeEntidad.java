package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

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
		setId(UtilUUID.obtenerUUIDDefecto());
		setProducto(new ProductoEntidad());
		setSede(new SedeEntidad());
		setPrecio(UtilNumero.CERO_DECIMAL);
		setTieneOferta(false);
		setOferta(0);
		setPrecioTrasOferta(UtilNumero.CERO_DECIMAL);
		setStock(0);
		setStockGarantia(0);
	}

	public ProductoSedeEntidad(final UUID id, final ProductoEntidad producto, final SedeEntidad sede,
			final BigDecimal precio, final boolean tieneOferta, final int oferta,
			final BigDecimal precioTrasOferta, final int stock, final int stockGarantia) {
		setId(id);
		setProducto(producto);
		setSede(sede);
		setPrecio(precio);
		setTieneOferta(tieneOferta);
		setOferta(oferta);
		setPrecioTrasOferta(precioTrasOferta);
		setStock(stock);
		setStockGarantia(stockGarantia);
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
		this.producto = UtilObjeto.esNulo(producto) ?
				new ProductoEntidad() : producto;
	}

	public SedeEntidad getSede() {
		return sede;
	}

	public void setSede(final SedeEntidad sede) {
		this.sede = UtilObjeto.esNulo(sede) ?
				new SedeEntidad() : sede;
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