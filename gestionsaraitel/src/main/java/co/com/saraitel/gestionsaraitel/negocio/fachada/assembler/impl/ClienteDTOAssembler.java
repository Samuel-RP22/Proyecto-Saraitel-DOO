
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.ClienteDominio;
import co.com.saraitel.gestionsaraitel.dto.ClienteDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteDTOAssembler implements DTOAssembler<ClienteDominio, ClienteDTO> {

	private static final DTOAssembler<ClienteDominio, ClienteDTO> instancia = new ClienteDTOAssembler();

	private ClienteDTOAssembler() {
	}

	public static DTOAssembler<ClienteDominio, ClienteDTO> getInstance() {
		return instancia;
	}

	@Override
	public ClienteDTO convertirADTO(ClienteDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				ClienteDominio.obtenerValorDefecto());

		return new ClienteDTO(dominioTmp.getId(), dominioTmp.getEsClienteRegistrado());
	}

	@Override
	public ClienteDominio convertirADominio(ClienteDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new ClienteDTO());

		return new ClienteDominio(dtoTmp.getId(), dtoTmp.getEsClienteRegistrado());
	}

	@Override
	public List<ClienteDTO> convertirADTO(List<ClienteDominio> listaDominios) {
		var listaDominiosTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios,
				new ArrayList<ClienteDominio>());

		List<ClienteDTO> listaDTO = new ArrayList<>();

		for (ClienteDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
