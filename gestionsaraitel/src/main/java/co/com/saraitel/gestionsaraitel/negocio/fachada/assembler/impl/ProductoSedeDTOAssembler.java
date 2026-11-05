package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.ProductoSedeDominio;
import co.com.saraitel.gestionsaraitel.dto.ProductoSedeDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ProductoSedeDTOAssembler implements DTOAssembler<ProductoSedeDominio, ProductoSedeDTO> {

	private static final DTOAssembler<ProductoSedeDominio, ProductoSedeDTO> instancia = new ProductoSedeDTOAssembler();

	private ProductoSedeDTOAssembler() {
	}

	public static DTOAssembler<ProductoSedeDominio, ProductoSedeDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public ProductoSedeDTO convertirADTO(ProductoSedeDominio dominio) {

		ProductoSedeDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				ProductoSedeDominio.obtenerValorDefecto());

		return new ProductoSedeDTO.Builder().id(dominioTmp.getId())
				.producto(ProductoDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getProducto()))
				.sede(SedeDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getSede()))
				.precio(dominioTmp.getPrecio()).tieneOferta(dominioTmp.getTieneOferta()).oferta(dominioTmp.getOferta())
				.precioTrasOferta(dominioTmp.getPrecioTrasOferta()).stock(dominioTmp.getStock())
				.stockGarantia(dominioTmp.getStockGarantia()).construir();
	}

	@Override
	public ProductoSedeDominio convertirADominio(ProductoSedeDTO dto) {

		ProductoSedeDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new ProductoSedeDTO());

		return new ProductoSedeDominio.Builder().id(dtoTmp.getId())
				.producto(ProductoDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getProducto()))
				.sede(SedeDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getSede()))
				.precio(dtoTmp.getPrecio()).tieneOferta(dtoTmp.getTieneOferta()).oferta(dtoTmp.getOferta())
				.precioTrasOferta(dtoTmp.getPrecioTrasOferta()).stock(dtoTmp.getStock())
				.stockGarantia(dtoTmp.getStockGarantia()).construir();
	}

	@Override
	public List<ProductoSedeDTO> convertirADTO(List<ProductoSedeDominio> listaDominios) {

		List<ProductoSedeDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<ProductoSedeDominio>());

		return listaDominiosTmp.stream().map(this::convertirADTO).toList();
	}
}
