package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoJDominio;
import co.com.saraitel.gestionsaraitel.dto.ClienteRegistradoJDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.DTOAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteRegistradoJDTOAssembler implements DTOAssembler<ClienteRegistradoJDominio, ClienteRegistradoJDTO> {

	private static final DTOAssembler<ClienteRegistradoJDominio, ClienteRegistradoJDTO> instancia = new ClienteRegistradoJDTOAssembler();

	private ClienteRegistradoJDTOAssembler() {
	}

	public static DTOAssembler<ClienteRegistradoJDominio, ClienteRegistradoJDTO> obtenerInstancia() {
		return instancia;
	}

	@Override
	public ClienteRegistradoJDTO convertirADTO(ClienteRegistradoJDominio dominio) {

		ClienteRegistradoJDominio dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new ClienteRegistradoJDominio.Builder().construir());

		return new ClienteRegistradoJDTO.Builder().id(dominioTmp.getId())
				.clienteRegistrado(ClienteRegistradoDTOAssembler.obtenerInstancia()
						.convertirADTO(dominioTmp.getClienteRegistrado()))
				.prefijo(PrefijoDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getPrefijo()))
				.telefono(dominioTmp.getTelefono()).nit(dominioTmp.getNit()).razonSocial(dominioTmp.getRazonSocial())
				.correo(dominioTmp.getCorreo()).correoConfirmado(dominioTmp.getCorreoConfirmado())
				.telefonoConfirmado(dominioTmp.getTelefonoConfirmado()).construir();
	}

	@Override
	public ClienteRegistradoJDominio convertirADominio(ClienteRegistradoJDTO dto) {

		ClienteRegistradoJDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto,
				new ClienteRegistradoJDTO());

		return new ClienteRegistradoJDominio.Builder().id(dtoTmp.getId())
				.clienteRegistrado(ClienteRegistradoDTOAssembler.obtenerInstancia()
						.convertirADominio(dtoTmp.getClienteRegistrado()))
				.prefijo(PrefijoDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getPrefijo()))
				.telefono(dtoTmp.getTelefono()).nit(dtoTmp.getNit()).razonSocial(dtoTmp.getRazonSocial())
				.correo(dtoTmp.getCorreo()).correoConfirmado(dtoTmp.getCorreoConfirmado())
				.telefonoConfirmado(dtoTmp.getTelefonoConfirmado()).construir();
	}

	@Override
	public List<ClienteRegistradoJDTO> convertirADTO(List<ClienteRegistradoJDominio> listaDominios) {

		List<ClienteRegistradoJDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<ClienteRegistradoJDominio>());

		return listaDominiosTmp.stream().map(this::convertirADTO).toList();
	}
}
