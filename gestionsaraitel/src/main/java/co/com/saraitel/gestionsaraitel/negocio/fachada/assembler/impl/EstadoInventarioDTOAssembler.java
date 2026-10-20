
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.EstadoInventarioDominio;
import co.com.saraitel.gestionsaraitel.dto.EstadoInventarioDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EstadoInventarioDTOAssembler implements DTOAssembler<EstadoInventarioDominio, EstadoInventarioDTO> {

	private static final DTOAssembler<EstadoInventarioDominio, EstadoInventarioDTO> instancia = new EstadoInventarioDTOAssembler();

	private EstadoInventarioDTOAssembler() {
	}

	public static DTOAssembler<EstadoInventarioDominio, EstadoInventarioDTO> getInstance() {
		return instancia;
	}

	@Override
	public EstadoInventarioDTO convertirADTO(EstadoInventarioDominio dominio) {
		EstadoInventarioDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				EstadoInventarioDominio.obtenerValorDefecto());

		return new EstadoInventarioDTO(dominioTmp.getId(), dominioTmp.getCodigo(), dominioTmp.getNombre());
	}

	@Override
	public EstadoInventarioDominio convertirADominio(EstadoInventarioDTO dto) {
		EstadoInventarioDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto,
				new EstadoInventarioDTO());

		return new EstadoInventarioDominio(dtoTmp.getId(), dtoTmp.getCodigo(), dtoTmp.getNombre());
	}

	@Override
	public List<EstadoInventarioDTO> convertirADTO(List<EstadoInventarioDominio> listaDominios) {

		List<EstadoInventarioDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<EstadoInventarioDominio>());

		List<EstadoInventarioDTO> listaDTO = new ArrayList<>();

		for (EstadoInventarioDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
