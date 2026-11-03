
package co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;

import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoDominio;
import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoJDominio;
import co.com.saraitel.gestionsaraitel.dominio.PrefijoDominio;
import co.com.saraitel.gestionsaraitel.dto.ClienteRegistradoDTO;
import co.com.saraitel.gestionsaraitel.dto.ClienteRegistradoJDTO;
import co.com.saraitel.gestionsaraitel.dto.PrefijoDTO;
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

		ClienteRegistradoDTO clienteRegistradoDTO = ClienteRegistradoDTOAssembler.obtenerInstancia()
				.convertirADTO(dominioTmp.getClienteRegistrado());

		PrefijoDTO prefijoDTO = PrefijoDTOAssembler.obtenerInstancia().convertirADTO(dominioTmp.getPrefijo());

		return new ClienteRegistradoJDTO.Builder().id(dominioTmp.getId()).clienteRegistrado(clienteRegistradoDTO)
				.prefijo(prefijoDTO).telefono(dominioTmp.getTelefono()).nit(dominioTmp.getNit())
				.razonSocial(dominioTmp.getRazonSocial()).correo(dominioTmp.getCorreo())
				.correoConfirmado(dominioTmp.getCorreoConfirmado())
				.telefonoConfirmado(dominioTmp.getTelefonoConfirmado()).construir();
	}

	@Override
	public ClienteRegistradoJDominio convertirADominio(ClienteRegistradoJDTO dto) {
		ClienteRegistradoJDTO dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto,
				new ClienteRegistradoJDTO());

		ClienteRegistradoDominio clienteRegistradoDominio = ClienteRegistradoDTOAssembler.obtenerInstancia()
				.convertirADominio(dtoTmp.getClienteRegistrado());

		PrefijoDominio prefijoDominio = PrefijoDTOAssembler.obtenerInstancia().convertirADominio(dtoTmp.getPrefijo());

		return new ClienteRegistradoJDominio.Builder().id(dtoTmp.getId()).clienteRegistrado(clienteRegistradoDominio)
				.prefijo(prefijoDominio).telefono(dtoTmp.getTelefono()).nit(dtoTmp.getNit())
				.razonSocial(dtoTmp.getRazonSocial()).correo(dtoTmp.getCorreo())
				.correoConfirmado(dtoTmp.getCorreoConfirmado()).telefonoConfirmado(dtoTmp.getTelefonoConfirmado())
				.construir();
	}

	@Override
	public List<ClienteRegistradoJDTO> convertirADTO(List<ClienteRegistradoJDominio> listaDominios) {

		List<ClienteRegistradoJDominio> listaDominiosTmp = UtilObjeto
				.obtenerValorDefectoSiValorOriginalEsNulo(listaDominios, new ArrayList<ClienteRegistradoJDominio>());

		List<ClienteRegistradoJDTO> listaDTO = new ArrayList<>();

		for (ClienteRegistradoJDominio dominio : listaDominiosTmp) {
			listaDTO.add(convertirADTO(dominio));
		}

		return listaDTO;
	}
}
