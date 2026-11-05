package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.DetalleIngresoDominio;
import co.com.saraitel.gestionsaraitel.dto.DetalleIngresoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DetalleIngresoDTOAssembler implements DTOAssembler<DetalleIngresoDominio, DetalleIngresoDTO> {

	private static final DTOAssembler<DetalleIngresoDominio, DetalleIngresoDTO> instancia = new DetalleIngresoDTOAssembler();

	private DetalleIngresoDTOAssembler() {
	}

	public static DTOAssembler<DetalleIngresoDominio, DetalleIngresoDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public DetalleIngresoDTO convertirADTO(DetalleIngresoDominio dominio) {

		DetalleIngresoDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				DetalleIngresoDominio.obtenerValorDefecto());

		return new DetalleIngresoDTO(dominioTmp.getId(),
				IngresoInventarioDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getIngresoInventario()),
				ProductoSedeDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getProductoSede()),
				dominioTmp.getCantidad(), dominioTmp.getCostoUnitario(), dominioTmp.getSubtotal());
	}

	@Override
	public DetalleIngresoDominio convertirADominio(DetalleIngresoDTO dto) {

		DetalleIngresoDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new DetalleIngresoDTO());

		return new DetalleIngresoDominio(dtoTmp.getId(),
				IngresoInventarioDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getIngresoInventario()),
				ProductoSedeDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getProductoSede()),
				dtoTmp.getCantidad(), dtoTmp.getCostoUnitario(), dtoTmp.getSubtotal());
	}

	@Override
	public List<DetalleIngresoDTO> convertirADTO(List<DetalleIngresoDominio> listaDominios) {

		List<DetalleIngresoDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<DetalleIngresoDominio>());

		return listaDominiosTmp.stream().map(this::convertirADTO).toList();
	}
}
