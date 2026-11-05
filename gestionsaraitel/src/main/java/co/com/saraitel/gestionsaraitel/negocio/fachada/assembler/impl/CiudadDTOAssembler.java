package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.CiudadDominio;
import co.com.saraitel.gestionsaraitel.dto.CiudadDTO;
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

		return new CiudadDTO(dominioTmp.getId(), dominioTmp.getNombre(),
				DepartamentoDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getDepartamento()));
	}

	@Override
	public CiudadDominio convertirADominio(CiudadDTO dto) {

		CiudadDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new CiudadDTO());

		return new CiudadDominio(dtoTmp.getId(), dtoTmp.getNombre(),
				DepartamentoDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getDepartamento()));
	}

	@Override
	public List<CiudadDTO> convertirADTO(List<CiudadDominio> listaDominios) {

		List<CiudadDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<CiudadDominio>());

		return listaDominiosTmp.stream().map(this::convertirADTO).toList();
	}
}
