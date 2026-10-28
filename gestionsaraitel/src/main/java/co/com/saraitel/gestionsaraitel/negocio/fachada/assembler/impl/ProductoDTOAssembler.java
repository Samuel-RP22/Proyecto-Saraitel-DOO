
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.CategoriaDominio;
import co.com.saraitel.gestionsaraitel.dominio.MarcaDominio;
import co.com.saraitel.gestionsaraitel.dominio.ProductoDominio;
import co.com.saraitel.gestionsaraitel.dto.CategoriaDTO;
import co.com.saraitel.gestionsaraitel.dto.MarcaDTO;
import co.com.saraitel.gestionsaraitel.dto.ProductoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ProductoDTOAssembler implements DTOAssembler<ProductoDominio, ProductoDTO> {

	private static final DTOAssembler<ProductoDominio, ProductoDTO> instancia = new ProductoDTOAssembler();

	private ProductoDTOAssembler() {
	}

	public static DTOAssembler<ProductoDominio, ProductoDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public ProductoDTO convertirADTO(ProductoDominio dominio) {
		ProductoDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				ProductoDominio.obtenerValorDefecto());

		MarcaDTO marcaDTO = MarcaDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getMarca());

		CategoriaDTO categoriaDTO = CategoriaDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getCategoria());

		return new ProductoDTO(dominioTmp.getId(), marcaDTO, categoriaDTO, dominioTmp.getModelo(),
				dominioTmp.getNombre(), dominioTmp.getDescripcion());
	}

	@Override
	public ProductoDominio convertirADominio(ProductoDTO dto) {
		ProductoDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new ProductoDTO());

		MarcaDominio marcaDominio = MarcaDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getMarca());

		CategoriaDominio categoriaDominio = CategoriaDTOAssembler.obtenerInstancia()
				.convertirADominio(dtoTmp.getCategoria());

		return new ProductoDominio(dtoTmp.getId(), marcaDominio, categoriaDominio, dtoTmp.getModelo(),
				dtoTmp.getNombre(), dtoTmp.getDescripcion());
	}

	@Override
	public List<ProductoDTO> convertirADTO(List<ProductoDominio> listaDominios) {

		List<ProductoDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<ProductoDominio>());

		List<ProductoDTO> listaDTO = new ArrayList<>();

		for (ProductoDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
