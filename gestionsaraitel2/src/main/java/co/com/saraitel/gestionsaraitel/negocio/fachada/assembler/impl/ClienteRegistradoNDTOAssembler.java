
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;
import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoDominio;
import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoNDominio;
import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;
import co.com.saraitel.gestionsaraitel.dto.ClienteRegistradoDTO;
import co.com.saraitel.gestionsaraitel.dto.ClienteRegistradoNDTO;
import co.com.saraitel.gestionsaraitel.dto.PersonaDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteRegistradoNDTOAssembler implements DTOAssembler<ClienteRegistradoNDominio, ClienteRegistradoNDTO> {

	private static final DTOAssembler<ClienteRegistradoNDominio, ClienteRegistradoNDTO> instancia = new ClienteRegistradoNDTOAssembler();

	private ClienteRegistradoNDTOAssembler() {
	}

	public static DTOAssembler<ClienteRegistradoNDominio, ClienteRegistradoNDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public ClienteRegistradoNDTO convertirADTO(ClienteRegistradoNDominio dominio) {
		ClienteRegistradoNDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new ClienteRegistradoNDominio(UtilUUID.obtenerUUIDDefecto(),
						ClienteRegistradoDominio.obtenerValorDefecto(), PersonaDominio.obtenerValorDefecto()));

		ClienteRegistradoDTO clienteRegistradoDTO = ClienteRegistradoDTOAssembler.obtenerInstancia()
				.convertirADTO(dominioTmp.getClienteRegistrado());

		PersonaDTO personaDTO = PersonaDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getPersona());

		return new ClienteRegistradoNDTO(dominioTmp.getId(), clienteRegistradoDTO, personaDTO);
	}

	@Override
	public ClienteRegistradoNDominio convertirADominio(ClienteRegistradoNDTO dto) {
		ClienteRegistradoNDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto,
				new ClienteRegistradoNDTO());

		ClienteRegistradoDominio clienteRegistradoDominio = ClienteRegistradoDTOAssembler.obtenerInstancia()
				.convertirADominio(dtoTmp.getClienteRegistrado());

		PersonaDominio personaDominio = PersonaDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getPersona());

		return new ClienteRegistradoNDominio(dtoTmp.getId(), clienteRegistradoDominio, personaDominio);
	}

	@Override
	public List<ClienteRegistradoNDTO> convertirADTO(List<ClienteRegistradoNDominio> listaDominios) {

		List<ClienteRegistradoNDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<ClienteRegistradoNDominio>());

		List<ClienteRegistradoNDTO> listaDTO = new ArrayList<>();

		for (ClienteRegistradoNDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
