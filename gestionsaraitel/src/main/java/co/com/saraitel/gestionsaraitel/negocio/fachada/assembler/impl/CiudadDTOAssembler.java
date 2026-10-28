
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.CiudadDominio;
import co.com.saraitel.gestionsaraitel.dominio.DepartamentoDominio;
import co.com.saraitel.gestionsaraitel.dto.CiudadDTO;
import co.com.saraitel.gestionsaraitel.dto.DepartamentoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class CiudadDTOAssembler implements DTOAssembler<CiudadDominio, CiudadDTO> {

	private static final DTOAssembler<CiudadDominio, CiudadDTO> instancia = new CiudadDTOAssembler();

	private CiudadDTOAssembler() {
	}

	public static DTOAssembler<CiudadDominio, CiudadDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public CiudadDTO convertirADTO(CiudadDominio dominio) {
		CiudadDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				CiudadDominio.obtenerValorDefecto());

		DepartamentoDTO departamentoDTO = DepartamentoDTOAssembler.obtenerInstancia()
				.convertirADTO(dominioTmp.getDepartamento());

		return new CiudadDTO(dominioTmp.getId(), dominioTmp.getNombre(), departamentoDTO);
	}

	@Override
	public CiudadDominio convertirADominio(CiudadDTO dto) {
		CiudadDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new CiudadDTO());

		DepartamentoDominio departamentoDominio = DepartamentoDTOAssembler.obtenerInstancia()
				.convertirADominio(dtoTmp.getDepartamento());

		return new CiudadDominio(dtoTmp.getId(), dtoTmp.getNombre(), departamentoDominio);
	}

	@Override
	public List<CiudadDTO> convertirADTO(List<CiudadDominio> listaDominios) {
		List<CiudadDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<CiudadDominio>());

		List<CiudadDTO> listaDTO = new ArrayList<>();

		for (CiudadDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
