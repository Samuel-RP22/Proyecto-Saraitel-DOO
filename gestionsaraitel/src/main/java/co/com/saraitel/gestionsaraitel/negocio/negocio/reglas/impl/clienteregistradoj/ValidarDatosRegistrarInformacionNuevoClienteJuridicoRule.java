package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoJDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;

public class ValidarDatosRegistrarInformacionNuevoClienteJuridicoRule implements Rule<ClienteRegistradoJDominio> {

	private static final Rule<ClienteRegistradoJDominio> instancia = new ValidarDatosRegistrarInformacionNuevoClienteJuridicoRule();

	private ValidarDatosRegistrarInformacionNuevoClienteJuridicoRule() {
	}

	public static final Rule<ClienteRegistradoJDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(ClienteRegistradoJDominio... datos) {
		var dominio = datos[0];

		AsegurarNitClienteJuridicoValidoRule.obtenerInstancia().ejecutar(dominio.getNit());
		AsegurarRazonSocialClienteJuridicoValidaRule.obtenerInstancia().ejecutar(dominio.getRazonSocial());
		AsegurarPrefijoClienteJuridicoValidoRule.obtenerInstancia().ejecutar(dominio.getPrefijo().getId());
		AsegurarTelefonoClienteJuridicoValidoRule.obtenerInstancia().ejecutar(dominio.getTelefono());
		AsegurarCorreoClienteJuridicoValidoRule.obtenerInstancia().ejecutar(dominio.getCorreo());
	}
}
