
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.ProductoDominio;
import co.com.saraitel.gestionsaraitel.dominio.ProductoSedeDominio;
import co.com.saraitel.gestionsaraitel.dominio.SedeDominio;
import co.com.saraitel.gestionsaraitel.dto.ProductoDTO;
import co.com.saraitel.gestionsaraitel.dto.ProductoSedeDTO;
import co.com.saraitel.gestionsaraitel.dto.SedeDTO;
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

		ProductoDTO productoDTO = ProductoDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getProducto());

		SedeDTO sedeDTO = SedeDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getSede());

		return new ProductoSedeDTO.Builder().id(dominioTmp.getId()).producto(productoDTO).sede(sedeDTO)
				.precio(dominioTmp.getPrecio()).tieneOferta(dominioTmp.getTieneOferta()).oferta(dominioTmp.getOferta())
				.precioTrasOferta(dominioTmp.getPrecioTrasOferta()).stock(dominioTmp.getStock())
				.stockGarantia(dominioTmp.getStockGarantia()).construir();
	}

	@Override
	public ProductoSedeDominio convertirADominio(ProductoSedeDTO dto) {
		ProductoSedeDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new ProductoSedeDTO());

		ProductoDominio productoDominio = ProductoDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getProducto());

		SedeDominio sedeDominio = SedeDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getSede());

		return new ProductoSedeDominio.Builder().id(dtoTmp.getId()).producto(productoDominio).sede(sedeDominio)
				.precio(dtoTmp.getPrecio()).tieneOferta(dtoTmp.getTieneOferta()).oferta(dtoTmp.getOferta())
				.precioTrasOferta(dtoTmp.getPrecioTrasOferta()).stock(dtoTmp.getStock())
				.stockGarantia(dtoTmp.getStockGarantia()).construir();
	}

	@Override
	public List<ProductoSedeDTO> convertirADTO(List<ProductoSedeDominio> listaDominios) {

		List<ProductoSedeDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<ProductoSedeDominio>());

		List<ProductoSedeDTO> listaDTO = new ArrayList<>();

		for (ProductoSedeDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
