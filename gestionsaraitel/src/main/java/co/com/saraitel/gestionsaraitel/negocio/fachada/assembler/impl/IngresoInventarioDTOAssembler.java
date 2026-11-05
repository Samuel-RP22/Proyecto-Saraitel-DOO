package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.IngresoInventarioDominio;
import co.com.saraitel.gestionsaraitel.dto.IngresoInventarioDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class IngresoInventarioDTOAssembler implements DTOAssembler<IngresoInventarioDominio, IngresoInventarioDTO> {

	private static final DTOAssembler<IngresoInventarioDominio, IngresoInventarioDTO> instancia = new IngresoInventarioDTOAssembler();

	private IngresoInventarioDTOAssembler() {
	}

	public static DTOAssembler<IngresoInventarioDominio, IngresoInventarioDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public IngresoInventarioDTO convertirADTO(IngresoInventarioDominio dominio) {

		IngresoInventarioDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				IngresoInventarioDominio.obtenerValorDefecto());

		return new IngresoInventarioDTO(dominioTmp.getId(),
				SedeDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getSede()),
				EstadoInventarioDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getEstado()),
				dominioTmp.getFechaLlegada(), dominioTmp.getTotal());
	}

	@Override
	public IngresoInventarioDominio convertirADominio(IngresoInventarioDTO dto) {

		IngresoInventarioDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto,
				new IngresoInventarioDTO());

		return new IngresoInventarioDominio(dtoTmp.getId(),
				SedeDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getSede()),
				EstadoInventarioDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getEstado()),
				dtoTmp.getFechaLlegada(), dtoTmp.getTotal());
	}

	@Override
	public List<IngresoInventarioDTO> convertirADTO(List<IngresoInventarioDominio> listaDominios) {

		List<IngresoInventarioDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<IngresoInventarioDominio>());

		return listaDominiosTmp.stream().map(this::convertirADTO).toList();
	}
}
