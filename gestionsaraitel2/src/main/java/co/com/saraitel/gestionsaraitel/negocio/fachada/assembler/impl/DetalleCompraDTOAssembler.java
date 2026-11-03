
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.DetalleCompraDominio;
import co.com.saraitel.gestionsaraitel.dto.DetalleCompraDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DetalleCompraDTOAssembler implements DTOAssembler<DetalleCompraDominio, DetalleCompraDTO> {

	private static final DTOAssembler<DetalleCompraDominio, DetalleCompraDTO> instancia = new DetalleCompraDTOAssembler();

	private DetalleCompraDTOAssembler() {
	}

	public static DTOAssembler<DetalleCompraDominio, DetalleCompraDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public DetalleCompraDTO convertirADTO(DetalleCompraDominio dominio) {

		DetalleCompraDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				DetalleCompraDominio.obtenerValorDefecto());

		return new DetalleCompraDTO(dominioTmp.getId(),
				ProcesoCompraDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getProcesoCompra()),
				ProductoSedeDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getProductoSede()),
				dominioTmp.getCantidad(), dominioTmp.getPrecioUnitario(), dominioTmp.getSubtotal());
	}

	@Override
	public DetalleCompraDominio convertirADominio(DetalleCompraDTO dto) {

		DetalleCompraDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new DetalleCompraDTO());

		return new DetalleCompraDominio(dtoTmp.getId(),
				ProcesoCompraDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getProcesoCompra()),
				ProductoSedeDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getProductoSede()),
				dtoTmp.getCantidad(), dtoTmp.getPrecioUnitario(), dtoTmp.getSubtotal());
	}

	@Override
	public List<DetalleCompraDTO> convertirADTO(List<DetalleCompraDominio> listaDominios) {

		List<DetalleCompraDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<DetalleCompraDominio>());

		List<DetalleCompraDTO> listaDTO = new ArrayList<>();

		for (DetalleCompraDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
