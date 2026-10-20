
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.DetalleIngresoDominio;
import co.com.saraitel.gestionsaraitel.dominio.IngresoInventarioDominio;
import co.com.saraitel.gestionsaraitel.dominio.ProductoSedeDominio;
import co.com.saraitel.gestionsaraitel.dto.DetalleIngresoDTO;
import co.com.saraitel.gestionsaraitel.dto.IngresoInventarioDTO;
import co.com.saraitel.gestionsaraitel.dto.ProductoSedeDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DetalleIngresoDTOAssembler implements DTOAssembler<DetalleIngresoDominio, DetalleIngresoDTO> {

	private static final DTOAssembler<DetalleIngresoDominio, DetalleIngresoDTO> instancia = new DetalleIngresoDTOAssembler();

	private DetalleIngresoDTOAssembler() {
	}

	public static DTOAssembler<DetalleIngresoDominio, DetalleIngresoDTO> getInstance() {
		return instancia;
	}

	@Override
	public DetalleIngresoDTO convertirADTO(DetalleIngresoDominio dominio) {
		DetalleIngresoDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				DetalleIngresoDominio.obtenerValorDefecto());

		IngresoInventarioDTO ingresoInventarioDTO = IngresoInventarioDTOAssembler.getInstance()
				.convertirADTO(dominioTmp.getIngresoInventario());

		ProductoSedeDTO productoSedeDTO = ProductoSedeDTOAssembler.getInstance()
				.convertirADTO(dominioTmp.getProductoSede());

		return new DetalleIngresoDTO(dominioTmp.getId(), ingresoInventarioDTO, productoSedeDTO,
				dominioTmp.getCantidad(), dominioTmp.getCostoUnitario(), dominioTmp.getSubtotal());
	}

	@Override
	public DetalleIngresoDominio convertirADominio(DetalleIngresoDTO dto) {
		DetalleIngresoDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new DetalleIngresoDTO());

		IngresoInventarioDominio ingresoInventarioDominio = IngresoInventarioDTOAssembler.getInstance()
				.convertirADominio(dtoTmp.getIngresoInventario());

		ProductoSedeDominio productoSedeDominio = ProductoSedeDTOAssembler.getInstance()
				.convertirADominio(dtoTmp.getProductoSede());

		return new DetalleIngresoDominio(dtoTmp.getId(), ingresoInventarioDominio, productoSedeDominio,
				dtoTmp.getCantidad(), dtoTmp.getCostoUnitario(), dtoTmp.getSubtotal());
	}

	@Override
	public List<DetalleIngresoDTO> convertirADTO(List<DetalleIngresoDominio> listaDominios) {

		List<DetalleIngresoDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<DetalleIngresoDominio>());

		List<DetalleIngresoDTO> listaDTO = new ArrayList<>();

		for (DetalleIngresoDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
