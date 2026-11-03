
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.EstadoSaldoFavorDominio;
import co.com.saraitel.gestionsaraitel.dto.EstadoSaldoFavorDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EstadoSaldoFavorDTOAssembler implements DTOAssembler<EstadoSaldoFavorDominio, EstadoSaldoFavorDTO> {

	private static final DTOAssembler<EstadoSaldoFavorDominio, EstadoSaldoFavorDTO> instancia = new EstadoSaldoFavorDTOAssembler();

	private EstadoSaldoFavorDTOAssembler() {
	}

	public static DTOAssembler<EstadoSaldoFavorDominio, EstadoSaldoFavorDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public EstadoSaldoFavorDTO convertirADTO(EstadoSaldoFavorDominio dominio) {
		EstadoSaldoFavorDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				EstadoSaldoFavorDominio.obtenerValorDefecto());

		return new EstadoSaldoFavorDTO(dominioTmp.getId(), dominioTmp.getCodigo(), dominioTmp.getNombre());
	}

	@Override
	public EstadoSaldoFavorDominio convertirADominio(EstadoSaldoFavorDTO dto) {
		EstadoSaldoFavorDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto,
				new EstadoSaldoFavorDTO());

		return new EstadoSaldoFavorDominio(dtoTmp.getId(), dtoTmp.getCodigo(), dtoTmp.getNombre());
	}

	@Override
	public List<EstadoSaldoFavorDTO> convertirADTO(List<EstadoSaldoFavorDominio> listaDominios) {

		List<EstadoSaldoFavorDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<EstadoSaldoFavorDominio>());

		List<EstadoSaldoFavorDTO> listaDTO = new ArrayList<>();

		for (EstadoSaldoFavorDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
