package co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl;

import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoJDominio;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoJEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.EntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteRegistradoJEntidadAssembler
		implements EntidadAssembler<ClienteRegistradoJDominio, ClienteRegistradoJEntidad> {

	private static final EntidadAssembler<ClienteRegistradoJDominio, ClienteRegistradoJEntidad> instancia = new ClienteRegistradoJEntidadAssembler();

	private ClienteRegistradoJEntidadAssembler() {
	}

	public static EntidadAssembler<ClienteRegistradoJDominio, ClienteRegistradoJEntidad> obtenerInstancia() {
		return instancia;
	}

	@Override
	public ClienteRegistradoJEntidad convertirAEntidad(ClienteRegistradoJDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new ClienteRegistradoJDominio.Builder().construir());

		return new ClienteRegistradoJEntidad.Builder().id(dominioTmp.getId())
				.clienteRegistrado(ClienteRegistradoEntidadAssembler.obtenerInstancia()
						.convertirAEntidad(dominioTmp.getClienteRegistrado()))
				.prefijo(PrefijoEntidadAssembler.obtenerInstancia().convertirAEntidad(dominioTmp.getPrefijo()))
				.telefono(dominioTmp.getTelefono()).nit(dominioTmp.getNit()).razonSocial(dominioTmp.getRazonSocial())
				.correo(dominioTmp.getCorreo()).correoConfirmado(dominioTmp.getCorreoConfirmado())
				.telefonoConfirmado(dominioTmp.getTelefonoConfirmado()).construir();
	}

	@Override
	public ClienteRegistradoJDominio convertirADominio(ClienteRegistradoJEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad,
				new ClienteRegistradoJEntidad.Builder().construir());

		return new ClienteRegistradoJDominio.Builder().id(entidadTmp.getId())
				.clienteRegistrado(ClienteRegistradoEntidadAssembler.obtenerInstancia()
						.convertirADominio(entidadTmp.getClienteRegistrado()))
				.prefijo(PrefijoEntidadAssembler.obtenerInstancia().convertirADominio(entidadTmp.getPrefijo()))
				.telefono(entidadTmp.getTelefono()).nit(entidadTmp.getNit()).razonSocial(entidadTmp.getRazonSocial())
				.correo(entidadTmp.getCorreo()).correoConfirmado(entidadTmp.getCorreoConfirmado())
				.telefonoConfirmado(entidadTmp.getTelefonoConfirmado()).construir();
	}
}