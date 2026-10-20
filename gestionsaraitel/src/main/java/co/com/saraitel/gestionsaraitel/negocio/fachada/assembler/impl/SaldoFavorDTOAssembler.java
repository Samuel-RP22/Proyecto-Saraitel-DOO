
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.SaldoFavorDominio;
import co.com.saraitel.gestionsaraitel.dto.SaldoFavorDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class SaldoFavorDTOAssembler implements DTOAssembler<SaldoFavorDominio, SaldoFavorDTO> {

	private static final DTOAssembler<SaldoFavorDominio, SaldoFavorDTO> instancia = new SaldoFavorDTOAssembler();

	private SaldoFavorDTOAssembler() {
	}

	public static DTOAssembler<SaldoFavorDominio, SaldoFavorDTO> getInstance() {
		return instancia;
	}

	@Override
	public SaldoFavorDTO convertirADTO(SaldoFavorDominio dominio) {

		SaldoFavorDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				SaldoFavorDominio.obtenerValorDefecto());

		return new SaldoFavorDTO(dominioTmp.getId(),
				DevolucionDTOAssembler.getInstance().convertirADTO(dominioTmp.getDevolucion()),
				EstadoSaldoFavorDTOAssembler.getInstance().convertirADTO(dominioTmp.getEstado()),
				dominioTmp.getMontoUsado());
	}

	@Override
	public SaldoFavorDominio convertirADominio(SaldoFavorDTO dto) {

		SaldoFavorDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new SaldoFavorDTO());

		return new SaldoFavorDominio(dtoTmp.getId(),
				DevolucionDTOAssembler.getInstance().convertirADominio(dtoTmp.getDevolucion()),
				EstadoSaldoFavorDTOAssembler.getInstance().convertirADominio(dtoTmp.getEstado()),
				dtoTmp.getMontoUsado());
	}

	@Override
	public List<SaldoFavorDTO> convertirADTO(List<SaldoFavorDominio> listaDominios) {

		List<SaldoFavorDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<SaldoFavorDominio>());

		List<SaldoFavorDTO> listaDTO = new ArrayList<>();

		for (SaldoFavorDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
