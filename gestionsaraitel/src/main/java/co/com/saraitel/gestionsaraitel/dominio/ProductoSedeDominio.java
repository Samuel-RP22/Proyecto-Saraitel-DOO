package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProductoSedeDominio {
	
	private UUID id;
	private ProductoDominio producto;
	private SedeDominio sede;
	private BigDecimal precio;
	private boolean tieneOferta;
	private int oferta;
	private BigDecimal precioTrasOferta;
	private int stock;
	private int stockGarantia;
	
	
	private ProductoSedeDominio(Builder builder) {
		this.id = builder.id;
		this.producto = builder.producto;
		this.sede = builder.sede;
		this.precio = builder.precio;
		this.tieneOferta = builder.tieneOferta;
		this.oferta = builder.oferta;
		this.precioTrasOferta = builder.precioTrasOferta;
		this.stock = builder.stock;
		this.stock = builder.stockGarantia;
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
	
	public static class Builder {
		private UUID id;
		private ProductoDominio producto;
		private SedeDominio sede;
		private BigDecimal precio;
		private boolean tieneOferta;
		private int oferta;
		private BigDecimal precioTrasOferta;
		private int stock;
		private int stockGarantia;
		
		public Builder() {
		    id = UtilUUID.obtenerUUIDDefecto();
		    producto = new ProductoDominio.Builder().build();
		    sede = new SedeDominio.Builder().build();
		    precio = UtilNumero.CERO_DECIMAL;
		    tieneOferta = false;
		    oferta = 0;
		    precioTrasOferta = UtilNumero.CERO_DECIMAL;
		    stock = 0;
		    stockGarantia = 0;
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder producto(ProductoDominio producto) {
		    this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
		        producto,
		        new ProductoDominio.Builder().build()
		    );
		    return this;
		}
		
		public Builder sede(SedeDominio sede) {
		    this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
		    			sede, new SedeDominio.Builder().build());
		    return this;
		}
		
		public Builder precio(BigDecimal precio) {
		    this.precio = UtilNumero.obtenerValorDefecto(precio);
		    return this;
		}
		
		public Builder tieneOferta(boolean tieneOferta) {
		    this.tieneOferta = tieneOferta;

		    if (!tieneOferta) {
		        this.oferta = 0;
		    }

		    return this;
		}

		public Builder oferta(int oferta) {

		    if (!UtilNumero.estaEntreXyY(oferta, 0, 100)) {
		        throw new IllegalArgumentException(
		            
		        );
		    }

		    this.oferta = oferta;
		    return this;
		}
		
		
		public ProductoSedeDominio build() {
			return new ProductoSedeDominio(this);
		}
	}
}

