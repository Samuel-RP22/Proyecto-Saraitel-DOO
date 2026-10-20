package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.EstadoInventarioDominio;
import co.com.saraitel.gestionsaraitel.dominio.IngresoInventarioDominio;
import co.com.saraitel.gestionsaraitel.dominio.SedeDominio;
import co.com.saraitel.gestionsaraitel.dto.EstadoInventarioDTO;
import co.com.saraitel.gestionsaraitel.dto.IngresoInventarioDTO;
import co.com.saraitel.gestionsaraitel.dto.SedeDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class IngresoInventarioDTOAssembler implements DTOAssembler<IngresoInventarioDominio, IngresoInventarioDTO> {

	private static final DTOAssembler<IngresoInventarioDominio, IngresoInventarioDTO> instancia = new IngresoInventarioDTOAssembler();

	private IngresoInventarioDTOAssembler() {
	}

	public static DTOAssembler<IngresoInventarioDominio, IngresoInventarioDTO> getInstance() {
		return instancia;
	}

	@Override
	public IngresoInventarioDTO convertirADTO(IngresoInventarioDominio dominio) {
		IngresoInventarioDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				IngresoInventarioDominio.obtenerValorDefecto());

		SedeDTO sedeDTO = SedeDTOAssembler.getInstance().convertirADTO(dominioTmp.getSede());

		EstadoInventarioDTO estadoDTO = EstadoInventarioDTOAssembler.getInstance()
				.convertirADTO(dominioTmp.getEstado());

		return new IngresoInventarioDTO(dominioTmp.getId(), sedeDTO, estadoDTO, dominioTmp.getFechaLlegada(),
				dominioTmp.getTotal());
	}

	@Override
	public IngresoInventarioDominio convertirADominio(IngresoInventarioDTO dto) {
		IngresoInventarioDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto,
				new IngresoInventarioDTO());

		SedeDominio sedeDominio = SedeDTOAssembler.getInstance().convertirADominio(dtoTmp.getSede());

		EstadoInventarioDominio estadoDominio = EstadoInventarioDTOAssembler.getInstance()
				.convertirADominio(dtoTmp.getEstado());

		return new IngresoInventarioDominio(dtoTmp.getId(), sedeDominio, estadoDominio, dtoTmp.getFechaLlegada(),
				dtoTmp.getTotal());
	}

	@Override
	public List<IngresoInventarioDTO> convertirADTO(List<IngresoInventarioDominio> listaDominios) {

		List<IngresoInventarioDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<IngresoInventarioDominio>());

		List<IngresoInventarioDTO> listaDTO = new ArrayList<>();

		for (IngresoInventarioDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}