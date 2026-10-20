
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.CompraDominio;
import co.com.saraitel.gestionsaraitel.dominio.FacturaDominio;
import co.com.saraitel.gestionsaraitel.dto.FacturaDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class FacturaDTOAssembler implements DTOAssembler<FacturaDominio, FacturaDTO> {

	private static final DTOAssembler<FacturaDominio, FacturaDTO> instancia = new FacturaDTOAssembler();

	private FacturaDTOAssembler() {
	}

	public static DTOAssembler<FacturaDominio, FacturaDTO> getInstance() {
		return instancia;
	}

	@Override
	public FacturaDTO convertirADTO(FacturaDominio dominio) {

		FacturaDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new FacturaDominio(UtilUUID.obtenerUUIDDefecto(), CompraDominio.obtenerValorDefecto(),
						co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha.FECHA_HORA_DEFECTO));

		return new FacturaDTO(dominioTmp.getId(),
				CompraDTOAssembler.getInstance().convertirADTO(dominioTmp.getCompra()), dominioTmp.getFechaEmision());
	}

	@Override
	public FacturaDominio convertirADominio(FacturaDTO dto) {

		FacturaDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new FacturaDTO());

		return new FacturaDominio(dtoTmp.getId(),
				CompraDTOAssembler.getInstance().convertirADominio(dtoTmp.getCompra()), dtoTmp.getFechaEmision());
	}

	@Override
	public List<FacturaDTO> convertirADTO(List<FacturaDominio> listaDominios) {

		List<FacturaDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<FacturaDominio>());

		List<FacturaDTO> listaDTO = new ArrayList<>();

		for (FacturaDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
