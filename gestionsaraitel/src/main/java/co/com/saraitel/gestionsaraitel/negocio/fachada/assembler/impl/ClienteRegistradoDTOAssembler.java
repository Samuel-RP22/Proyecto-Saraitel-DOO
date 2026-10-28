
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.ClienteDominio;
import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoDominio;
import co.com.saraitel.gestionsaraitel.dto.ClienteDTO;
import co.com.saraitel.gestionsaraitel.dto.ClienteRegistradoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteRegistradoDTOAssembler implements DTOAssembler<ClienteRegistradoDominio, ClienteRegistradoDTO> {

	private static final DTOAssembler<ClienteRegistradoDominio, ClienteRegistradoDTO> instancia = new ClienteRegistradoDTOAssembler();

	private ClienteRegistradoDTOAssembler() {
	}

	public static DTOAssembler<ClienteRegistradoDominio, ClienteRegistradoDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public ClienteRegistradoDTO convertirADTO(ClienteRegistradoDominio dominio) {
		ClienteRegistradoDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				ClienteRegistradoDominio.obtenerValorDefecto());

		ClienteDTO clienteDTO = ClienteDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getCliente());

		return new ClienteRegistradoDTO(dominioTmp.getId(), clienteDTO, dominioTmp.getClienteNaturalDefecto());
	}

	@Override
	public ClienteRegistradoDominio convertirADominio(ClienteRegistradoDTO dto) {
		ClienteRegistradoDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto,
				new ClienteRegistradoDTO());

		ClienteDominio clienteDominio = ClienteDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getCliente());

		return new ClienteRegistradoDominio(dtoTmp.getId(), clienteDominio, dtoTmp.getClienteNaturalDefecto());
	}

	@Override
	public List<ClienteRegistradoDTO> convertirADTO(List<ClienteRegistradoDominio> listaDominios) {

		List<ClienteRegistradoDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<ClienteRegistradoDominio>());

		List<ClienteRegistradoDTO> listaDTO = new ArrayList<>();

		for (ClienteRegistradoDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
