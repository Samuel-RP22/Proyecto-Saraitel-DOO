
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.CategoriaDominio;
import co.com.saraitel.gestionsaraitel.dto.CategoriaDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class CategoriaDTOAssembler implements DTOAssembler<CategoriaDominio, CategoriaDTO> {

	private static final DTOAssembler<CategoriaDominio, CategoriaDTO> instancia = new CategoriaDTOAssembler();

	private CategoriaDTOAssembler() {
	}

	public static DTOAssembler<CategoriaDominio, CategoriaDTO> getInstance() {
		return instancia;
	}

	@Override
	public CategoriaDTO convertirADTO(CategoriaDominio dominio) {
		CategoriaDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				CategoriaDominio.obtenerValorDefecto());

		return new CategoriaDTO(dominioTmp.getId(), dominioTmp.getNombre(), dominioTmp.getCategoriaPadre(),
				dominioTmp.getNivel());
	}

	@Override
	public CategoriaDominio convertirADominio(CategoriaDTO dto) {
		CategoriaDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new CategoriaDTO());

		return new CategoriaDominio(dtoTmp.getId(), dtoTmp.getNombre(), dtoTmp.getIdCategoriaPadre(),
				dtoTmp.getNivel());
	}

	@Override
	public List<CategoriaDTO> convertirADTO(List<CategoriaDominio> listaDominios) {

		List<CategoriaDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<CategoriaDominio>());

		List<CategoriaDTO> listaDTO = new ArrayList<>();

		for (CategoriaDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
