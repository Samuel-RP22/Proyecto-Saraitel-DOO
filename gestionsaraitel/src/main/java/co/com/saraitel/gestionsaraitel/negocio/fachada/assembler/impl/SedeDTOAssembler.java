package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.SedeDominio;
import co.com.saraitel.gestionsaraitel.dto.SedeDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class SedeDTOAssembler implements DTOAssembler<SedeDominio, SedeDTO> {

	private static final DTOAssembler<SedeDominio, SedeDTO> instancia = new SedeDTOAssembler();

	private SedeDTOAssembler() {
	}

	public static DTOAssembler<SedeDominio, SedeDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public SedeDTO convertirADTO(SedeDominio dominio) {

		SedeDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				SedeDominio.obtenerValorDefecto());

		return new SedeDTO(dominioTmp.getId(),
				CiudadDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getCiudad()), dominioTmp.getNombre(),
				dominioTmp.getNit(), dominioTmp.getDireccion(), dominioTmp.getEsActiva());
	}

	@Override
	public SedeDominio convertirADominio(SedeDTO dto) {

		SedeDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new SedeDTO());

		return new SedeDominio(dtoTmp.getId(),
				CiudadDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getCiudad()), dtoTmp.getNombre(),
				dtoTmp.getNit(), dtoTmp.getDireccion(), dtoTmp.getEsActiva());
	}

	@Override
	public List<SedeDTO> convertirADTO(List<SedeDominio> listaDominios) {

		List<SedeDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<SedeDominio>());

		return listaDominiosTmp.stream().map(this::convertirADTO).toList();
	}
}
