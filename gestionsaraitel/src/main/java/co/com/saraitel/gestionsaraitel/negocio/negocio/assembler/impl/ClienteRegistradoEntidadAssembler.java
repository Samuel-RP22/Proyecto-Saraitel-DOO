package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.ClienteDominio;
import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoDominio;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoEntidadAssembler
		implements EntidadAssembler<ClienteRegistradoDominio, ClienteRegistradoEntidad> {

	private static final EntidadAssembler<ClienteRegistradoDominio, ClienteRegistradoEntidad> instancia = new ClienteRegistradoEntidadAssembler();

	private ClienteRegistradoEntidadAssembler() {
	}

	public static EntidadAssembler<ClienteRegistradoDominio, ClienteRegistradoEntidad> getInstance() {
		return instancia;
	}

	@Override
	public ClienteRegistradoEntidad convertirAEntidad(ClienteRegistradoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new ClienteRegistradoDominio(
				UtilUUID.obtenerUUIDDefecto(), ClienteDominio.obtenerValorDefecto(), false));
		return new ClienteRegistradoEntidad(dominioTmp.getId(),
				ClienteEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getCliente()),
				dominioTmp.getClienteNaturalDefecto());
	}

	@Override
	public ClienteRegistradoDominio convertirADominio(ClienteRegistradoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new ClienteRegistradoEntidad());
		return new ClienteRegistradoDominio(entidadTmp.getId(),
				ClienteEntidadAssembler.getInstance().convertirADominio(entidadTmp.getCliente()),
				entidadTmp.getClienteNaturalDefecto());
	}
}