
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.AplicacionSaldoDominio;
import co.com.saraitel.gestionsaraitel.dominio.SaldoFavorDominio;
import co.com.saraitel.gestionsaraitel.dominio.PagoDominio;
import co.com.saraitel.gestionsaraitel.dto.AplicacionSaldoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AplicacionSaldoDTOAssembler implements DTOAssembler<AplicacionSaldoDominio, AplicacionSaldoDTO> {

	private static final DTOAssembler<AplicacionSaldoDominio, AplicacionSaldoDTO> instancia = new AplicacionSaldoDTOAssembler();

	private AplicacionSaldoDTOAssembler() {
	}

	public static DTOAssembler<AplicacionSaldoDominio, AplicacionSaldoDTO> getInstance() {
		return instancia;
	}

	@Override
	public AplicacionSaldoDTO convertirADTO(AplicacionSaldoDominio dominio) {

		AplicacionSaldoDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new AplicacionSaldoDominio(UtilUUID.obtenerUUIDDefecto(), SaldoFavorDominio.obtenerValorDefecto(),
						PagoDominio.obtenerValorDefecto(), UtilNumero.CERO_DECIMAL));

		return new AplicacionSaldoDTO(dominioTmp.getId(),
				SaldoFavorDTOAssembler.getInstance().convertirADTO(dominioTmp.getSaldoFavor()),
				PagoDTOAssembler.getInstance().convertirADTO(dominioTmp.getPago()), dominioTmp.getValorAplicado());
	}

	@Override
	public AplicacionSaldoDominio convertirADominio(AplicacionSaldoDTO dto) {

		AplicacionSaldoDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new AplicacionSaldoDTO());

		return new AplicacionSaldoDominio(dtoTmp.getId(),
				SaldoFavorDTOAssembler.getInstance().convertirADominio(dtoTmp.getSaldoFavor()),
				PagoDTOAssembler.getInstance().convertirADominio(dtoTmp.getPago()), dtoTmp.getValorAplicado());
	}

	@Override
	public List<AplicacionSaldoDTO> convertirADTO(List<AplicacionSaldoDominio> listaDominios) {

		List<AplicacionSaldoDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<AplicacionSaldoDominio>());

		List<AplicacionSaldoDTO> listaDTO = new ArrayList<>();

		for (AplicacionSaldoDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
