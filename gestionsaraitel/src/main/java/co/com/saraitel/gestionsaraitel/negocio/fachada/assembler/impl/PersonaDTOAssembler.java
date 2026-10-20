
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;
import co.com.saraitel.gestionsaraitel.dominio.PrefijoDominio;
import co.com.saraitel.gestionsaraitel.dominio.TipoDocumentoDominio;
import co.com.saraitel.gestionsaraitel.dto.PersonaDTO;
import co.com.saraitel.gestionsaraitel.dto.PrefijoDTO;
import co.com.saraitel.gestionsaraitel.dto.TipoDocumentoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PersonaDTOAssembler implements DTOAssembler<PersonaDominio, PersonaDTO> {

	private static final DTOAssembler<PersonaDominio, PersonaDTO> instancia = new PersonaDTOAssembler();

	private PersonaDTOAssembler() {
	}

	public static DTOAssembler<PersonaDominio, PersonaDTO> getInstance() {
		return instancia;
	}

	@Override
	public PersonaDTO convertirADTO(PersonaDominio dominio) {

		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				PersonaDominio.obtenerValorDefecto());

		TipoDocumentoDTO tipoDocumentoDTO = TipoDocumentoDTOAssembler.getInstance()
				.convertirADTO(dominioTmp.getTipoDocumento());

		PrefijoDTO prefijoDTO = PrefijoDTOAssembler.getInstance().convertirADTO(dominioTmp.getPrefijo());

		return new PersonaDTO.Builder().id(dominioTmp.getId()).tipoDocumento(tipoDocumentoDTO).prefijo(prefijoDTO)
				.numeroDocumento(dominioTmp.getNumeroDocumento()).telefono(dominioTmp.getTelefono())
				.nombre(dominioTmp.getNombre()).apellido(dominioTmp.getApellido()).correo(dominioTmp.getCorreo())
				.telefonoConfirmado(dominioTmp.getTelefonoConfirmado())
				.correoConfirmado(dominioTmp.getCorreoConfirmado()).construir();
	}

	@Override
	public PersonaDominio convertirADominio(PersonaDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new PersonaDTO());
		TipoDocumentoDominio tipoDocumentoDominio = TipoDocumentoDTOAssembler.getInstance()
				.convertirADominio(dtoTmp.getTipoDocumento());

		PrefijoDominio prefijoDominio = PrefijoDTOAssembler.getInstance().convertirADominio(dtoTmp.getPrefijo());

		return new PersonaDominio.Builder().id(dtoTmp.getId()).tipoDocumento(tipoDocumentoDominio)
				.prefijo(prefijoDominio).numeroDocumento(dtoTmp.getNumeroDocumento()).telefono(dtoTmp.getTelefono())
				.nombre(dtoTmp.getNombre()).apellido(dtoTmp.getApellido()).correo(dtoTmp.getCorreo())
				.telefonoConfirmado(dtoTmp.getTelefonoConfirmado()).correoConfirmado(dtoTmp.getCorreoConfirmado())
				.construir();
	}

	@Override
	public List<PersonaDTO> convertirADTO(List<PersonaDominio> listaDominios) {

		var listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<PersonaDominio>());

		List<PersonaDTO> listaDTO = new ArrayList<>();

		for (PersonaDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
