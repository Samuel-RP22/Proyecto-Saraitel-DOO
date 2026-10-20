
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.CiudadDominio;
import co.com.saraitel.gestionsaraitel.dominio.SedeDominio;
import co.com.saraitel.gestionsaraitel.dto.CiudadDTO;
import co.com.saraitel.gestionsaraitel.dto.SedeDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class SedeDTOAssembler implements DTOAssembler<SedeDominio, SedeDTO> {

	private static final DTOAssembler<SedeDominio, SedeDTO> instancia = new SedeDTOAssembler();

	private SedeDTOAssembler() {
	}

	public static DTOAssembler<SedeDominio, SedeDTO> getInstance() {
		return instancia;
	}

	@Override
	public SedeDTO convertirADTO(SedeDominio dominio) {
		SedeDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				SedeDominio.obtenerValorDefecto());

		CiudadDTO ciudadDTO = CiudadDTOAssembler.getInstance().convertirADTO(dominioTmp.getCiudad());

		return new SedeDTO(dominioTmp.getId(), ciudadDTO, dominioTmp.getNombre(), dominioTmp.getNit(),
				dominioTmp.getDireccion(), dominioTmp.getEsActiva());
	}

	@Override
	public SedeDominio convertirADominio(SedeDTO dto) {
		SedeDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new SedeDTO());

		CiudadDominio ciudadDominio = CiudadDTOAssembler.getInstance().convertirADominio(dtoTmp.getCiudad());

		return new SedeDominio(dtoTmp.getId(), ciudadDominio, dtoTmp.getNombre(), dtoTmp.getNit(),
				dtoTmp.getDireccion(), dtoTmp.getEsActiva());
	}

	@Override
	public List<SedeDTO> convertirADTO(List<SedeDominio> listaDominios) {
		List<SedeDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<SedeDominio>());

		List<SedeDTO> listaDTO = new ArrayList<>();

		for (SedeDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
