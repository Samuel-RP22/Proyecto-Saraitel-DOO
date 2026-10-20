
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.MotivoDominio;
import co.com.saraitel.gestionsaraitel.dto.MotivoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class MotivoDTOAssembler implements DTOAssembler<MotivoDominio, MotivoDTO> {

	private static final DTOAssembler<MotivoDominio, MotivoDTO> instancia = new MotivoDTOAssembler();

	private MotivoDTOAssembler() {
	}

	public static DTOAssembler<MotivoDominio, MotivoDTO> getInstance() {
		return instancia;
	}

	@Override
	public MotivoDTO convertirADTO(MotivoDominio dominio) {

		MotivoDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				MotivoDominio.obtenerValorDefecto());

		return new MotivoDTO(dominioTmp.getId(), dominioTmp.getNombre());
	}

	@Override
	public MotivoDominio convertirADominio(MotivoDTO dto) {

		MotivoDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new MotivoDTO());

		return new MotivoDominio(dtoTmp.getId(), dtoTmp.getNombre());
	}

	@Override
	public List<MotivoDTO> convertirADTO(List<MotivoDominio> listaDominios) {

		List<MotivoDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<MotivoDominio>());

		List<MotivoDTO> listaDTO = new ArrayList<>();

		for (MotivoDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
