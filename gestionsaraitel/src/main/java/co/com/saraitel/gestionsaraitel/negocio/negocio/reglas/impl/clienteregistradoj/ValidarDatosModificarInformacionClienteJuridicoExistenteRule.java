package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoJDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;

public class ValidarDatosModificarInformacionClienteJuridicoExistenteRule implements Rule<ClienteRegistradoJDominio> {

	private static final Rule<ClienteRegistradoJDominio> instancia = new ValidarDatosModificarInformacionClienteJuridicoExistenteRule();

	private ValidarDatosModificarInformacionClienteJuridicoExistenteRule() {
	}

	public static final Rule<ClienteRegistradoJDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(ClienteRegistradoJDominio... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var dominio = datos[0];

		AsegurarRazonSocialClienteJuridicoValidaRule.obtenerInstancia().ejecutar(dominio.getRazonSocial());
		AsegurarPrefijoClienteJuridicoValidoRule.obtenerInstancia().ejecutar(dominio.getPrefijo().getId());
		AsegurarTelefonoClienteJuridicoValidoRule.obtenerInstancia().ejecutar(dominio.getTelefono());
		AsegurarCorreoClienteJuridicoValidoRule.obtenerInstancia().ejecutar(dominio.getCorreo());
	}
}
