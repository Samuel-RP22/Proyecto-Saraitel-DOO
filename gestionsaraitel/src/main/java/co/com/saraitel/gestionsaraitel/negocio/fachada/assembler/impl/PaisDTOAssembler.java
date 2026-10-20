package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.PaisDominio;
import co.com.saraitel.gestionsaraitel.dto.PaisDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PaisDTOAssembler implements DTOAssembler<PaisDominio, PaisDTO> {
	
	private static final DTOAssembler<PaisDominio, PaisDTO> instancia = new PaisDTOAssembler();
	private PaisDTOAssembler() {
	}

	public static DTOAssembler<PaisDominio, PaisDTO> getInstance() {
		return instancia;
	}

	@Override
	public PaisDTO convertirADTO(PaisDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				PaisDominio.obtenerValorDefecto());
		return new PaisDTO(dominioTmp.getId(), dominioTmp.getNombre());
	}

	@Override
	public PaisDominio convertirADominio(PaisDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new PaisDTO());

		return new PaisDominio(dtoTmp.getId(), dtoTmp.getNombre());
	}

	@Override
	public List<PaisDTO> convertirADTO(List<PaisDominio> listaDominios) {
		var listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<PaisDominio>());

		List<PaisDTO> listaDTO = new ArrayList<>();

		for (PaisDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}