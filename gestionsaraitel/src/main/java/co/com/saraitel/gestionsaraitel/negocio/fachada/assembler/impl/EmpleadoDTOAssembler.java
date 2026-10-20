
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.EmpleadoDominio;
import co.com.saraitel.gestionsaraitel.dto.EmpleadoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EmpleadoDTOAssembler implements DTOAssembler<EmpleadoDominio, EmpleadoDTO> {

	private static final DTOAssembler<EmpleadoDominio, EmpleadoDTO> instancia = new EmpleadoDTOAssembler();

	private EmpleadoDTOAssembler() {
	}

	public static DTOAssembler<EmpleadoDominio, EmpleadoDTO> getInstance() {
		return instancia;
	}

	@Override
	public EmpleadoDTO convertirADTO(EmpleadoDominio dominio) {

		EmpleadoDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				EmpleadoDominio.obtenerValorDefecto());

		return new EmpleadoDTO(dominioTmp.getId(), SedeDTOAssembler.getInstance().convertirADTO(dominioTmp.getSede()),
				PersonaDTOAssembler.getInstance().convertirADTO(dominioTmp.getPersona()), dominioTmp.getEsActiva());
	}

	@Override
	public EmpleadoDominio convertirADominio(EmpleadoDTO dto) {

		EmpleadoDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new EmpleadoDTO());

		return new EmpleadoDominio(dtoTmp.getId(), SedeDTOAssembler.getInstance().convertirADominio(dtoTmp.getSede()),
				PersonaDTOAssembler.getInstance().convertirADominio(dtoTmp.getPersona()), dtoTmp.getEsActivo());
	}

	@Override
	public List<EmpleadoDTO> convertirADTO(List<EmpleadoDominio> listaDominios) {

		List<EmpleadoDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<EmpleadoDominio>());

		List<EmpleadoDTO> listaDTO = new ArrayList<>();

		for (EmpleadoDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
