package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.ProductoDominio;
import co.com.saraitel.gestionsaraitel.entidad.ProductoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ProductoEntidadAssembler implements EntidadAssembler<ProductoDominio, ProductoEntidad> {

	private static final EntidadAssembler<ProductoDominio, ProductoEntidad> instancia = new ProductoEntidadAssembler();

	private ProductoEntidadAssembler() {
	}

	public static EntidadAssembler<ProductoDominio, ProductoEntidad> getInstance() {
		return instancia;
	}

	@Override
	public ProductoEntidad convertirAEntidad(ProductoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				ProductoDominio.obtenerValorDefecto());

		return new ProductoEntidad(dominioTmp.getId(),
				MarcaEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getMarca()),
				CategoriaEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getCategoria()),
				dominioTmp.getModelo(), dominioTmp.getNombre(), dominioTmp.getDescripcion());
	}

	@Override
	public ProductoDominio convertirADominio(ProductoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new ProductoEntidad());

		return new ProductoDominio(entidadTmp.getId(),
				MarcaEntidadAssembler.getInstance().convertirADominio(entidadTmp.getMarca()),
				CategoriaEntidadAssembler.getInstance().convertirADominio(entidadTmp.getCategoria()),
				entidadTmp.getModelo(), entidadTmp.getNombre(), entidadTmp.getDescripcion());
	}
}