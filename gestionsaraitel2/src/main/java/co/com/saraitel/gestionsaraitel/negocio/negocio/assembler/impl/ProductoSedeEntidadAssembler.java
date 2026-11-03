package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.ProductoSedeDominio;
import co.com.saraitel.gestionsaraitel.entidad.ProductoSedeEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ProductoSedeEntidadAssembler implements EntidadAssembler<ProductoSedeDominio, ProductoSedeEntidad> {

	private static final EntidadAssembler<ProductoSedeDominio, ProductoSedeEntidad> instancia = new ProductoSedeEntidadAssembler();

	private ProductoSedeEntidadAssembler() {
	}

	public static EntidadAssembler<ProductoSedeDominio, ProductoSedeEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public ProductoSedeEntidad convertirAEntidad(ProductoSedeDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				ProductoSedeDominio.obtenerValorDefecto());

		return new ProductoSedeEntidad.Builder().id(dominioTmp.getId())
				.producto(ProductoEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getProducto()))
				.sede(SedeEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getSede()))
				.precio(dominioTmp.getPrecio()).tieneOferta(dominioTmp.getTieneOferta()).oferta(dominioTmp.getOferta())
				.precioTrasOferta(dominioTmp.getPrecioTrasOferta()).stock(dominioTmp.getStock())
				.stockGarantia(dominioTmp.getStockGarantia()).construir();
	}

	@Override
	public ProductoSedeDominio convertirADominio(ProductoSedeEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new ProductoSedeEntidad());

		return new ProductoSedeDominio.Builder().id(entidadTmp.getId())
				.producto(ProductoEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getProducto()))
				.sede(SedeEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getSede()))
				.precio(entidadTmp.getPrecio()).tieneOferta(entidadTmp.getTieneOferta()).oferta(entidadTmp.getOferta())
				.precioTrasOferta(entidadTmp.getPrecioTrasOferta()).stock(entidadTmp.getStock())
				.stockGarantia(entidadTmp.getStockGarantia()).construir();
	}
}