package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.ProductoDominio;
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

		return new ProductoDTO(dominioTmp.getId(),
				MarcaDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getMarca()),
				CategoriaDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getCategoria()),
				dominioTmp.getModelo(), dominioTmp.getNombre(), dominioTmp.getDescripcion());
	}

	@Override
	public ProductoDominio convertirADominio(ProductoDTO dto) {

		ProductoDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new ProductoDTO());

		return new ProductoDominio(dtoTmp.getId(),
				MarcaDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getMarca()),
				CategoriaDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getCategoria()), dtoTmp.getModelo(),
				dtoTmp.getNombre(), dtoTmp.getDescripcion());
	}

	@Override
	public List<ProductoDTO> convertirADTO(List<ProductoDominio> listaDominios) {

		List<ProductoDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<ProductoDominio>());

		return listaDominiosTmp.stream().map(this::convertirADTO).toList();
	}
}
