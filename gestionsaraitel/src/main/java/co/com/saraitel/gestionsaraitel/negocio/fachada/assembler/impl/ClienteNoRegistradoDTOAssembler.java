package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.ClienteNoRegistradoDominio;
import co.com.saraitel.gestionsaraitel.dto.ClienteNoRegistradoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteNoRegistradoDTOAssembler
		implements DTOAssembler<ClienteNoRegistradoDominio, ClienteNoRegistradoDTO> {

	private static final DTOAssembler<ClienteNoRegistradoDominio, ClienteNoRegistradoDTO> instancia = new ClienteNoRegistradoDTOAssembler();

	private ClienteNoRegistradoDTOAssembler() {
	}

	public static DTOAssembler<ClienteNoRegistradoDominio, ClienteNoRegistradoDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public ClienteNoRegistradoDTO convertirADTO(ClienteNoRegistradoDominio dominio) {

		ClienteNoRegistradoDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				ClienteNoRegistradoDominio.obtenerValorDefecto());

		return new ClienteNoRegistradoDTO(dominioTmp.getId(),
				ClienteDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getCliente()), dominioTmp.getNombre(),
				dominioTmp.getApellido(), dominioTmp.getNumeroDocumento());
	}

	@Override
	public ClienteNoRegistradoDominio convertirADominio(ClienteNoRegistradoDTO dto) {

		ClienteNoRegistradoDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto,
				new ClienteNoRegistradoDTO());

		return new ClienteNoRegistradoDominio(dtoTmp.getId(),
				ClienteDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getCliente()), dtoTmp.getNombre(),
				dtoTmp.getApellido(), dtoTmp.getNumeroDocumento());
	}

	@Override
	public List<ClienteNoRegistradoDTO> convertirADTO(List<ClienteNoRegistradoDominio> listaDominios) {

		List<ClienteNoRegistradoDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<ClienteNoRegistradoDominio>());

		return listaDominiosTmp.stream().map(this::convertirADTO).toList();
	}
}
