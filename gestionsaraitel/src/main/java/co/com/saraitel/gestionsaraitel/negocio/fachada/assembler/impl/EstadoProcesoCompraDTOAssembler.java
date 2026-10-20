
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.EstadoProcesoCompraDominio;
import co.com.saraitel.gestionsaraitel.dto.EstadoProcesoCompraDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EstadoProcesoCompraDTOAssembler
		implements DTOAssembler<EstadoProcesoCompraDominio, EstadoProcesoCompraDTO> {

	private static final DTOAssembler<EstadoProcesoCompraDominio, EstadoProcesoCompraDTO> instancia = new EstadoProcesoCompraDTOAssembler();

	private EstadoProcesoCompraDTOAssembler() {
	}

	public static DTOAssembler<EstadoProcesoCompraDominio, EstadoProcesoCompraDTO> getInstance() {
		return instancia;
	}

	@Override
	public EstadoProcesoCompraDTO convertirADTO(EstadoProcesoCompraDominio dominio) {
		EstadoProcesoCompraDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				EstadoProcesoCompraDominio.obtenerValorDefecto());

		return new EstadoProcesoCompraDTO(dominioTmp.getId(), dominioTmp.getCodigo(), dominioTmp.getNombre());
	}

	@Override
	public EstadoProcesoCompraDominio convertirADominio(EstadoProcesoCompraDTO dto) {
		EstadoProcesoCompraDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto,
				new EstadoProcesoCompraDTO());

		return new EstadoProcesoCompraDominio(dtoTmp.getId(), dtoTmp.getCodigo(), dtoTmp.getNombre());
	}

	@Override
	public List<EstadoProcesoCompraDTO> convertirADTO(List<EstadoProcesoCompraDominio> listaDominios) {

		List<EstadoProcesoCompraDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<EstadoProcesoCompraDominio>());

		List<EstadoProcesoCompraDTO> listaDTO = new ArrayList<>();

		for (EstadoProcesoCompraDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
