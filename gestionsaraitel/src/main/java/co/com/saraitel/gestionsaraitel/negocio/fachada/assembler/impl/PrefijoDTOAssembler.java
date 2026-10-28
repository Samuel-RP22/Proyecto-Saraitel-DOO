
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.PrefijoDominio;
import co.com.saraitel.gestionsaraitel.dto.PrefijoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PrefijoDTOAssembler implements DTOAssembler<PrefijoDominio, PrefijoDTO> {

	private static final DTOAssembler<PrefijoDominio, PrefijoDTO> instancia = new PrefijoDTOAssembler();

	private PrefijoDTOAssembler() {
	}

	public static DTOAssembler<PrefijoDominio, PrefijoDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public PrefijoDTO convertirADTO(PrefijoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				PrefijoDominio.obtenerValorDefecto());

		return new PrefijoDTO(dominioTmp.getId(), dominioTmp.getCodigo());
	}

	@Override
	public PrefijoDominio convertirADominio(PrefijoDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new PrefijoDTO());

		return new PrefijoDominio(dtoTmp.getId(), dtoTmp.getCodigo());
	}

	@Override
	public List<PrefijoDTO> convertirADTO(List<PrefijoDominio> listaDominios) {

		var listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<PrefijoDominio>());

		List<PrefijoDTO> listaDTO = new ArrayList<>();

		for (PrefijoDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
