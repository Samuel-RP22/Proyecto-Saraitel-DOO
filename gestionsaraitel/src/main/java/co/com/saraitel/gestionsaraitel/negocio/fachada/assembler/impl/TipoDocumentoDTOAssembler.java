
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.TipoDocumentoDominio;
import co.com.saraitel.gestionsaraitel.dto.TipoDocumentoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class TipoDocumentoDTOAssembler implements DTOAssembler<TipoDocumentoDominio, TipoDocumentoDTO> {

	private static final DTOAssembler<TipoDocumentoDominio, TipoDocumentoDTO> instancia = new TipoDocumentoDTOAssembler();

	private TipoDocumentoDTOAssembler() {
	}

	public static DTOAssembler<TipoDocumentoDominio, TipoDocumentoDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public TipoDocumentoDTO convertirADTO(TipoDocumentoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				TipoDocumentoDominio.obtenerValorDefecto());

		return new TipoDocumentoDTO(dominioTmp.getId(), dominioTmp.getTipo());
	}

	@Override
	public TipoDocumentoDominio convertirADominio(TipoDocumentoDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new TipoDocumentoDTO());

		return new TipoDocumentoDominio(dtoTmp.getId(), dtoTmp.getTipo());
	}

	@Override
	public List<TipoDocumentoDTO> convertirADTO(List<TipoDocumentoDominio> listaDominios) {

		var listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<TipoDocumentoDominio>());

		List<TipoDocumentoDTO> listaDTO = new ArrayList<>();

		for (TipoDocumentoDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
