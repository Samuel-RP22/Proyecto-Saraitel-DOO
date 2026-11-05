package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;
import co.com.saraitel.gestionsaraitel.dto.PersonaDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PersonaDTOAssembler implements DTOAssembler<PersonaDominio, PersonaDTO> {

	private static final DTOAssembler<PersonaDominio, PersonaDTO> instancia = new PersonaDTOAssembler();

	private PersonaDTOAssembler() {
	}

	public static DTOAssembler<PersonaDominio, PersonaDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public PersonaDTO convertirADTO(PersonaDominio dominio) {

		PersonaDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				PersonaDominio.obtenerValorDefecto());

		return new PersonaDTO.Builder().id(dominioTmp.getId())
				.tipoDocumento(
						TipoDocumentoDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getTipoDocumento()))
				.prefijo(PrefijoDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getPrefijo()))
				.numeroDocumento(dominioTmp.getNumeroDocumento()).telefono(dominioTmp.getTelefono())
				.nombre(dominioTmp.getNombre()).apellido(dominioTmp.getApellido()).correo(dominioTmp.getCorreo())
				.telefonoConfirmado(dominioTmp.getTelefonoConfirmado())
				.correoConfirmado(dominioTmp.getCorreoConfirmado()).construir();
	}

	@Override
	public PersonaDominio convertirADominio(PersonaDTO dto) {

		PersonaDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new PersonaDTO());
		return new PersonaDominio.Builder().id(dtoTmp.getId())
				.tipoDocumento(
						TipoDocumentoDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getTipoDocumento()))
				.prefijo(PrefijoDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getPrefijo()))
				.numeroDocumento(dtoTmp.getNumeroDocumento()).telefono(dtoTmp.getTelefono()).nombre(dtoTmp.getNombre())
				.apellido(dtoTmp.getApellido()).correo(dtoTmp.getCorreo())
				.telefonoConfirmado(dtoTmp.getTelefonoConfirmado()).correoConfirmado(dtoTmp.getCorreoConfirmado())
				.construir();
	}

	@Override
	public List<PersonaDTO> convertirADTO(List<PersonaDominio> listaDominios) {

		List<PersonaDominio> listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<PersonaDominio>());

		return listaDominiosTmp.stream().map(this::convertirADTO).toList();
	}
}
