
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.MetodoPagoDominio;
import co.com.saraitel.gestionsaraitel.dto.MetodoPagoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class MetodoPagoDTOAssembler implements DTOAssembler<MetodoPagoDominio, MetodoPagoDTO> {

	private static final DTOAssembler<MetodoPagoDominio, MetodoPagoDTO> instancia = new MetodoPagoDTOAssembler();

	private MetodoPagoDTOAssembler() {
	}

	public static DTOAssembler<MetodoPagoDominio, MetodoPagoDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public MetodoPagoDTO convertirADTO(MetodoPagoDominio dominio) {

		MetodoPagoDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				MetodoPagoDominio.obtenerValorDefecto());

		return new MetodoPagoDTO(dominioTmp.getId(), dominioTmp.getNombre(), dominioTmp.getEsActivo());
	}

	@Override
	public MetodoPagoDominio convertirADominio(MetodoPagoDTO dto) {

		MetodoPagoDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new MetodoPagoDTO());

		return new MetodoPagoDominio(dtoTmp.getId(), dtoTmp.getNombre(), dtoTmp.getEsActivo());
	}

	@Override
	public List<MetodoPagoDTO> convertirADTO(List<MetodoPagoDominio> listaDominios) {

		List<MetodoPagoDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<MetodoPagoDominio>());

		List<MetodoPagoDTO> listaDTO = new ArrayList<>();

		for (MetodoPagoDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
