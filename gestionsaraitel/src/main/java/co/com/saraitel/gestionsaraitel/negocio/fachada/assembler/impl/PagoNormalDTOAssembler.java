
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.PagoNormalDominio;
import co.com.saraitel.gestionsaraitel.dominio.MetodoPagoDominio;
import co.com.saraitel.gestionsaraitel.dominio.PagoDominio;
import co.com.saraitel.gestionsaraitel.dto.PagoNormalDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PagoNormalDTOAssembler implements DTOAssembler<PagoNormalDominio, PagoNormalDTO> {

	private static final DTOAssembler<PagoNormalDominio, PagoNormalDTO> instancia = new PagoNormalDTOAssembler();

	private PagoNormalDTOAssembler() {
	}

	public static DTOAssembler<PagoNormalDominio, PagoNormalDTO> getInstance() {
		return instancia;
	}

	@Override
	public PagoNormalDTO convertirADTO(PagoNormalDominio dominio) {

		PagoNormalDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new PagoNormalDominio(UtilUUID.obtenerUUIDDefecto(), MetodoPagoDominio.obtenerValorDefecto(),
						PagoDominio.obtenerValorDefecto(), UtilNumero.CERO_DECIMAL));

		return new PagoNormalDTO(dominioTmp.getId(),
				MetodoPagoDTOAssembler.getInstance().convertirADTO(dominioTmp.getMetodoPago()),
				PagoDTOAssembler.getInstance().convertirADTO(dominioTmp.getPago()), dominioTmp.getMontoPagar());
	}

	@Override
	public PagoNormalDominio convertirADominio(PagoNormalDTO dto) {

		PagoNormalDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new PagoNormalDTO());

		return new PagoNormalDominio(dtoTmp.getId(),
				MetodoPagoDTOAssembler.getInstance().convertirADominio(dtoTmp.getMetodoPago()),
				PagoDTOAssembler.getInstance().convertirADominio(dtoTmp.getPago()), dtoTmp.getMontoPagar());
	}

	@Override
	public List<PagoNormalDTO> convertirADTO(List<PagoNormalDominio> listaDominios) {

		List<PagoNormalDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<PagoNormalDominio>());

		List<PagoNormalDTO> listaDTO = new ArrayList<>();

		for (PagoNormalDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
