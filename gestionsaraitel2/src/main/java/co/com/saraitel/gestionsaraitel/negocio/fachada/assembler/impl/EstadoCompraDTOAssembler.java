
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.EstadoCompraDominio;
import co.com.saraitel.gestionsaraitel.dto.EstadoCompraDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EstadoCompraDTOAssembler implements DTOAssembler<EstadoCompraDominio, EstadoCompraDTO> {

	private static final DTOAssembler<EstadoCompraDominio, EstadoCompraDTO> instancia = new EstadoCompraDTOAssembler();

	private EstadoCompraDTOAssembler() {
	}

	public static DTOAssembler<EstadoCompraDominio, EstadoCompraDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public EstadoCompraDTO convertirADTO(EstadoCompraDominio dominio) {
		EstadoCompraDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				EstadoCompraDominio.obtenerValorDefecto());

		return new EstadoCompraDTO(dominioTmp.getId(), dominioTmp.getCodigo(), dominioTmp.getNombre());
	}

	@Override
	public EstadoCompraDominio convertirADominio(EstadoCompraDTO dto) {
		EstadoCompraDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new EstadoCompraDTO());

		return new EstadoCompraDominio(dtoTmp.getId(), dtoTmp.getCodigo(), dtoTmp.getNombre());
	}

	@Override
	public List<EstadoCompraDTO> convertirADTO(List<EstadoCompraDominio> listaDominios) {

		List<EstadoCompraDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<EstadoCompraDominio>());

		List<EstadoCompraDTO> listaDTO = new ArrayList<>();

		for (EstadoCompraDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
