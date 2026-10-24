package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.ClienteDominio;
import co.com.saraitel.gestionsaraitel.dominio.ClienteNoRegistradoDominio;
import co.com.saraitel.gestionsaraitel.entidad.ClienteNoRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteNoRegistradoEntidadAssembler
		implements EntidadAssembler<ClienteNoRegistradoDominio, ClienteNoRegistradoEntidad> {

	private static final EntidadAssembler<ClienteNoRegistradoDominio, ClienteNoRegistradoEntidad> instancia = new ClienteNoRegistradoEntidadAssembler();

	private ClienteNoRegistradoEntidadAssembler() {
	}

	public static EntidadAssembler<ClienteNoRegistradoDominio, ClienteNoRegistradoEntidad> getInstance() {
		return instancia;
	}

	@Override
	public ClienteNoRegistradoEntidad convertirAEntidad(ClienteNoRegistradoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new ClienteNoRegistradoDominio(UtilUUID.obtenerUUIDDefecto(), ClienteDominio.obtenerValorDefecto()));
		return new ClienteNoRegistradoEntidad(dominioTmp.getId(),
				ClienteEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getCliente()));
	}

	@Override
	public ClienteNoRegistradoDominio convertirADominio(ClienteNoRegistradoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new ClienteNoRegistradoEntidad());
		return new ClienteNoRegistradoDominio(entidadTmp.getId(),
				ClienteEntidadAssembler.getInstance().convertirADominio(entidadTmp.getCliente()));
	}
}