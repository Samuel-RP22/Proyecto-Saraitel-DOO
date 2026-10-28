
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.DepartamentoDominio;
import co.com.saraitel.gestionsaraitel.dominio.PaisDominio;
import co.com.saraitel.gestionsaraitel.dto.DepartamentoDTO;
import co.com.saraitel.gestionsaraitel.dto.PaisDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DepartamentoDTOAssembler implements DTOAssembler<DepartamentoDominio, DepartamentoDTO> {

	private static final DTOAssembler<DepartamentoDominio, DepartamentoDTO> instancia = new DepartamentoDTOAssembler();

	private DepartamentoDTOAssembler() {
	}

	public static DTOAssembler<DepartamentoDominio, DepartamentoDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public DepartamentoDTO convertirADTO(DepartamentoDominio dominio) {
		DepartamentoDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				DepartamentoDominio.obtenerValorDefecto());

		PaisDTO paisDTO = PaisDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getPais());

		return new DepartamentoDTO(dominioTmp.getId(), dominioTmp.getNombre(), paisDTO);
	}

	@Override
	public DepartamentoDominio convertirADominio(DepartamentoDTO dto) {
		DepartamentoDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new DepartamentoDTO());

		PaisDominio paisDominio = PaisDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getPais());

		return new DepartamentoDominio(dtoTmp.getId(), dtoTmp.getNombre(), paisDominio);
	}

	@Override
	public List<DepartamentoDTO> convertirADTO(List<DepartamentoDominio> listaDominios) {

		List<DepartamentoDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<DepartamentoDominio>());

		List<DepartamentoDTO> listaDTO = new ArrayList<>();

		for (DepartamentoDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
