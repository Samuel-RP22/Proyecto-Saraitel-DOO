
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.EmpleadoDominio;
import co.com.saraitel.gestionsaraitel.dominio.VendedorDominio;
import co.com.saraitel.gestionsaraitel.dto.VendedorDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class VendedorDTOAssembler implements DTOAssembler<VendedorDominio, VendedorDTO> {

	private static final DTOAssembler<VendedorDominio, VendedorDTO> instancia = new VendedorDTOAssembler();

	private VendedorDTOAssembler() {
	}

	public static DTOAssembler<VendedorDominio, VendedorDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public VendedorDTO convertirADTO(VendedorDominio dominio) {

		VendedorDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new VendedorDominio(UtilUUID.obtenerUUIDDefecto(), EmpleadoDominio.obtenerValorDefecto()));

		return new VendedorDTO(dominioTmp.getId(),
				EmpleadoDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getEmpleado()));
	}

	@Override
	public VendedorDominio convertirADominio(VendedorDTO dto) {

		VendedorDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new VendedorDTO());

		return new VendedorDominio(dtoTmp.getId(),
				EmpleadoDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getEmpleado()));
	}

	@Override
	public List<VendedorDTO> convertirADTO(List<VendedorDominio> listaDominios) {

		List<VendedorDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<VendedorDominio>());

		List<VendedorDTO> listaDTO = new ArrayList<>();

		for (VendedorDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
