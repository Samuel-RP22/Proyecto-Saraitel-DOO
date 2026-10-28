package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoDominio;
import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoNDominio;
import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoNEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoNEntidadAssembler
		implements EntidadAssembler<ClienteRegistradoNDominio, ClienteRegistradoNEntidad> {

	private static final EntidadAssembler<ClienteRegistradoNDominio, ClienteRegistradoNEntidad> instancia = new ClienteRegistradoNEntidadAssembler();

	private ClienteRegistradoNEntidadAssembler() {
	}

	public static EntidadAssembler<ClienteRegistradoNDominio, ClienteRegistradoNEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public ClienteRegistradoNEntidad convertirAEntidad(ClienteRegistradoNDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new ClienteRegistradoNDominio(UtilUUID.obtenerUUIDDefecto(),
						ClienteRegistradoDominio.obtenerValorDefecto(), PersonaDominio.obtenerValorDefecto()));

		return new ClienteRegistradoNEntidad(dominioTmp.getId(),
				ClienteRegistradoEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getClienteRegistrado()),
				PersonaEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getPersona()));
	}

	@Override
	public ClienteRegistradoNDominio convertirADominio(ClienteRegistradoNEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new ClienteRegistradoNEntidad());

		return new ClienteRegistradoNDominio(entidadTmp.getId(),
				ClienteRegistradoEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getClienteRegistrado()),
				PersonaEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getPersona()));
	}
}