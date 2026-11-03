
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.AdministradorDominio;
import co.com.saraitel.gestionsaraitel.dominio.EmpleadoDominio;
import co.com.saraitel.gestionsaraitel.dto.AdministradorDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AdministradorDTOAssembler implements DTOAssembler<AdministradorDominio, AdministradorDTO> {

	private static final DTOAssembler<AdministradorDominio, AdministradorDTO> instancia = new AdministradorDTOAssembler();

	private AdministradorDTOAssembler() {
	}

	public static DTOAssembler<AdministradorDominio, AdministradorDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public AdministradorDTO convertirADTO(AdministradorDominio dominio) {

		AdministradorDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new AdministradorDominio(UtilUUID.obtenerUUIDDefecto(), EmpleadoDominio.obtenerValorDefecto()));

		return new AdministradorDTO(dominioTmp.getId(),
				EmpleadoDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getEmpleado()));
	}

	@Override
	public AdministradorDominio convertirADominio(AdministradorDTO dto) {

		AdministradorDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new AdministradorDTO());

		return new AdministradorDominio(dtoTmp.getId(),
				EmpleadoDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getEmpleado()));
	}

	@Override
	public List<AdministradorDTO> convertirADTO(List<AdministradorDominio> listaDominios) {

		List<AdministradorDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<AdministradorDominio>());

		List<AdministradorDTO> listaDTO = new ArrayList<>();

		for (AdministradorDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
