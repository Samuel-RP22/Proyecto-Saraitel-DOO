
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.CompraDominio;
import co.com.saraitel.gestionsaraitel.dto.CompraDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class CompraDTOAssembler implements DTOAssembler<CompraDominio, CompraDTO> {

	private static final DTOAssembler<CompraDominio, CompraDTO> instancia = new CompraDTOAssembler();

	private CompraDTOAssembler() {
	}

	public static DTOAssembler<CompraDominio, CompraDTO> getInstance() {
		return instancia;
	}

	@Override
	public CompraDTO convertirADTO(CompraDominio dominio) {

		CompraDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				CompraDominio.obtenerValorDefecto());

		return new CompraDTO(dominioTmp.getId(),
				ProcesoCompraDTOAssembler.getInstance().convertirADTO(dominioTmp.getProcesoCompra()),
				EstadoCompraDTOAssembler.getInstance().convertirADTO(dominioTmp.getEstado()),
				dominioTmp.getFechaCompra());
	}

	@Override
	public CompraDominio convertirADominio(CompraDTO dto) {

		CompraDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new CompraDTO());

		return new CompraDominio(dtoTmp.getId(),
				ProcesoCompraDTOAssembler.getInstance().convertirADominio(dtoTmp.getProcesoCompra()),
				EstadoCompraDTOAssembler.getInstance().convertirADominio(dtoTmp.getEstado()), dtoTmp.getFechaCompra());
	}

	@Override
	public List<CompraDTO> convertirADTO(List<CompraDominio> listaDominios) {

		List<CompraDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<CompraDominio>());

		List<CompraDTO> listaDTO = new ArrayList<>();

		for (CompraDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
