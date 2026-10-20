
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.ProcesoCompraDominio;
import co.com.saraitel.gestionsaraitel.dto.ProcesoCompraDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ProcesoCompraDTOAssembler implements DTOAssembler<ProcesoCompraDominio, ProcesoCompraDTO> {

	private static final DTOAssembler<ProcesoCompraDominio, ProcesoCompraDTO> instancia = new ProcesoCompraDTOAssembler();

	private ProcesoCompraDTOAssembler() {
	}

	public static DTOAssembler<ProcesoCompraDominio, ProcesoCompraDTO> getInstance() {
		return instancia;
	}

	@Override
	public ProcesoCompraDTO convertirADTO(ProcesoCompraDominio dominio) {

		ProcesoCompraDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				ProcesoCompraDominio.obtenerValorDefecto());

		return new ProcesoCompraDTO(dominioTmp.getId(),
				ClienteDTOAssembler.getInstance().convertirADTO(dominioTmp.getCliente()),
				EmpleadoDTOAssembler.getInstance().convertirADTO(dominioTmp.getEmpleado()),
				EstadoProcesoCompraDTOAssembler.getInstance().convertirADTO(dominioTmp.getEstado()),
				dominioTmp.getFechaInicio(), dominioTmp.getFechaActualizacion(), dominioTmp.getTotal());
	}

	@Override
	public ProcesoCompraDominio convertirADominio(ProcesoCompraDTO dto) {

		ProcesoCompraDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new ProcesoCompraDTO());

		return new ProcesoCompraDominio(dtoTmp.getId(),
				ClienteDTOAssembler.getInstance().convertirADominio(dtoTmp.getCliente()),
				EmpleadoDTOAssembler.getInstance().convertirADominio(dtoTmp.getEmpleado()),
				EstadoProcesoCompraDTOAssembler.getInstance().convertirADominio(dtoTmp.getEstado()),
				dtoTmp.getFechaInicio(), dtoTmp.getFechaActualizacion(), dtoTmp.getTotal());
	}

	@Override
	public List<ProcesoCompraDTO> convertirADTO(List<ProcesoCompraDominio> listaDominios) {

		List<ProcesoCompraDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<ProcesoCompraDominio>());

		List<ProcesoCompraDTO> listaDTO = new ArrayList<>();

		for (ProcesoCompraDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
