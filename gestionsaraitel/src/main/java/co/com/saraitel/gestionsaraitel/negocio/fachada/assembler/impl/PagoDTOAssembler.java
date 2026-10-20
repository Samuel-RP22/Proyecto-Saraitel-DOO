
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.PagoDominio;
import co.com.saraitel.gestionsaraitel.dto.PagoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PagoDTOAssembler implements DTOAssembler<PagoDominio, PagoDTO> {

	private static final DTOAssembler<PagoDominio, PagoDTO> instancia = new PagoDTOAssembler();

	private PagoDTOAssembler() {
	}

	public static DTOAssembler<PagoDominio, PagoDTO> getInstance() {
		return instancia;
	}

	@Override
	public PagoDTO convertirADTO(PagoDominio dominio) {

		PagoDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				PagoDominio.obtenerValorDefecto());

		return new PagoDTO(dominioTmp.getId(), CompraDTOAssembler.getInstance().convertirADTO(dominioTmp.getCompra()),
				dominioTmp.getMontoPagado(), dominioTmp.getFechaPago());
	}

	@Override
	public PagoDominio convertirADominio(PagoDTO dto) {

		PagoDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new PagoDTO());

		return new PagoDominio(dtoTmp.getId(), CompraDTOAssembler.getInstance().convertirADominio(dtoTmp.getCompra()),
				dtoTmp.getMontoPagado(), dtoTmp.getFechaPago());
	}

	@Override
	public List<PagoDTO> convertirADTO(List<PagoDominio> listaDominios) {

		List<PagoDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<PagoDominio>());

		List<PagoDTO> listaDTO = new ArrayList<>();

		for (PagoDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
