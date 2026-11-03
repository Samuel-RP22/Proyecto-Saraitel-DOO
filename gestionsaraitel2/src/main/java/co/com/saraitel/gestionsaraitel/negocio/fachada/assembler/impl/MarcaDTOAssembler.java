
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.MarcaDominio;
import co.com.saraitel.gestionsaraitel.dto.MarcaDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class MarcaDTOAssembler implements DTOAssembler<MarcaDominio, MarcaDTO> {

	private static final DTOAssembler<MarcaDominio, MarcaDTO> instancia = new MarcaDTOAssembler();

	private MarcaDTOAssembler() {
	}

	public static DTOAssembler<MarcaDominio, MarcaDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public MarcaDTO convertirADTO(MarcaDominio dominio) {
		MarcaDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				MarcaDominio.obtenerValorDefecto());

		return new MarcaDTO(dominioTmp.getId(), dominioTmp.getNombre(), dominioTmp.getEsActivo());
	}

	@Override
	public MarcaDominio convertirADominio(MarcaDTO dto) {
		MarcaDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new MarcaDTO());

		return new MarcaDominio(dtoTmp.getId(), dtoTmp.getNombre(), dtoTmp.getEsActivo());
	}

	@Override
	public List<MarcaDTO> convertirADTO(List<MarcaDominio> listaDominios) {
		List<MarcaDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<MarcaDominio>());

		List<MarcaDTO> listaDTO = new ArrayList<>();

		for (MarcaDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
