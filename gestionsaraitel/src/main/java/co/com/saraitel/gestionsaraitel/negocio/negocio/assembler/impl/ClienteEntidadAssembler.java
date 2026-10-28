package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.ClienteDominio;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteEntidadAssembler implements EntidadAssembler<ClienteDominio, ClienteEntidad> {

	private static final EntidadAssembler<ClienteDominio, ClienteEntidad> instancia = new ClienteEntidadAssembler();

	private ClienteEntidadAssembler() {
	}

	public static EntidadAssembler<ClienteDominio, ClienteEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public ClienteEntidad convertirAEntidad(ClienteDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				ClienteDominio.obtenerValorDefecto());
		return new ClienteEntidad(dominioTmp.getId(), dominioTmp.getEsClienteRegistrado());
	}

	@Override
	public ClienteDominio convertirADominio(ClienteEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new ClienteEntidad());
		return new ClienteDominio(entidadTmp.getId(), entidadTmp.getEsClienteRegistrado());
	}
}