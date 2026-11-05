package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoDominio;
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

		return new ClienteRegistradoDTO(dominioTmp.getId(),
				ClienteDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getCliente()),
				dominioTmp.getClienteNaturalDefecto());
	}

	@Override
	public ClienteRegistradoDominio convertirADominio(ClienteRegistradoDTO dto) {

		ClienteRegistradoDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto,
				new ClienteRegistradoDTO());

		return new ClienteRegistradoDominio(dtoTmp.getId(),
				ClienteDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getCliente()),
				dtoTmp.getClienteNaturalDefecto());
	}

	@Override
	public List<ClienteRegistradoDTO> convertirADTO(List<ClienteRegistradoDominio> listaDominios) {

		List<ClienteRegistradoDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<ClienteRegistradoDominio>());

		return listaDominiosTmp.stream().map(this::convertirADTO).toList();
	}
}
