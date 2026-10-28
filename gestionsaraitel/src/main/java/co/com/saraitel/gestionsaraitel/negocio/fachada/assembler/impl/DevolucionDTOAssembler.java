
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.DevolucionDominio;
import co.com.saraitel.gestionsaraitel.dto.DevolucionDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DevolucionDTOAssembler implements DTOAssembler<DevolucionDominio, DevolucionDTO> {

	private static final DTOAssembler<DevolucionDominio, DevolucionDTO> instancia = new DevolucionDTOAssembler();

	private DevolucionDTOAssembler() {
	}

	public static DTOAssembler<DevolucionDominio, DevolucionDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public DevolucionDTO convertirADTO(DevolucionDominio dominio) {

		DevolucionDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				DevolucionDominio.obtenerValorDefecto());

		return new DevolucionDTO(dominioTmp.getId(),
				DetalleCompraDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getDetalleCompra()),
				MotivoDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getMotivo()), dominioTmp.getFechaDevolucion(),
				dominioTmp.getCantidad(), dominioTmp.getMontoDevolucion(), dominioTmp.getEstado());
	}

	@Override
	public DevolucionDominio convertirADominio(DevolucionDTO dto) {

		DevolucionDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new DevolucionDTO());

		return new DevolucionDominio(dtoTmp.getId(),
				DetalleCompraDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getDetalleCompra()),
				MotivoDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getMotivo()), dtoTmp.getFechaDevolucion(),
				dtoTmp.getCantidad(), dtoTmp.getMontoDevolucion(), dtoTmp.getEstado());
	}

	@Override
	public List<DevolucionDTO> convertirADTO(List<DevolucionDominio> listaDominios) {

		List<DevolucionDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<DevolucionDominio>());

		List<DevolucionDTO> listaDTO = new ArrayList<>();

		for (DevolucionDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
