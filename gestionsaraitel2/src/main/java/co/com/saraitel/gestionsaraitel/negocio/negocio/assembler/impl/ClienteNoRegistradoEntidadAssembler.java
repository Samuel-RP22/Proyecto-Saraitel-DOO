package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.ClienteNoRegistradoDominio;
import co.com.saraitel.gestionsaraitel.entidad.ClienteNoRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteNoRegistradoEntidadAssembler
		implements EntidadAssembler<ClienteNoRegistradoDominio, ClienteNoRegistradoEntidad> {

	private static final EntidadAssembler<ClienteNoRegistradoDominio, ClienteNoRegistradoEntidad> instancia = new ClienteNoRegistradoEntidadAssembler();

	private ClienteNoRegistradoEntidadAssembler() {
	}

	public static EntidadAssembler<ClienteNoRegistradoDominio, ClienteNoRegistradoEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public ClienteNoRegistradoEntidad convertirAEntidad(ClienteNoRegistradoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				ClienteNoRegistradoDominio.obtenerValorDefecto());
		return new ClienteNoRegistradoEntidad(dominioTmp.getId(),
				ClienteEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getCliente()), dominioTmp.getNombre(),
				dominioTmp.getApellido(), dominioTmp.getNumeroDocumento());
	}

	@Override
	public ClienteNoRegistradoDominio convertirADominio(ClienteNoRegistradoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new ClienteNoRegistradoEntidad());
		return new ClienteNoRegistradoDominio(entidadTmp.getId(),
				ClienteEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getCliente()), entidadTmp.getNombre(),
				entidadTmp.getApellido(), entidadTmp.getNumeroDocumento());
	}
}