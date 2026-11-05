package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoJDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class ValidarDatosConsultarClientesJuridicosPorFiltroRule implements Rule<ClienteRegistradoJDominio> {

	private static final Rule<ClienteRegistradoJDominio> instancia = new ValidarDatosConsultarClientesJuridicosPorFiltroRule();

	private ValidarDatosConsultarClientesJuridicosPorFiltroRule() {
	}

	public static final Rule<ClienteRegistradoJDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(ClienteRegistradoJDominio... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var filtro = datos[0];

		if (!UtilTexto.esVacia(filtro.getNit())) {
			AsegurarNitClienteJuridicoValidoRule.obtenerInstancia().ejecutar(filtro.getNit());
		}

		if (!UtilTexto.esVacia(filtro.getRazonSocial())) {
			AsegurarRazonSocialClienteJuridicoValidaRule.obtenerInstancia().ejecutar(filtro.getRazonSocial());
		}

		if (!UtilTexto.esVacia(filtro.getTelefono())) {
			AsegurarTelefonoClienteJuridicoValidoRule.obtenerInstancia().ejecutar(filtro.getTelefono());
		}

		if (!UtilTexto.esVacia(filtro.getCorreo())) {
			AsegurarCorreoClienteJuridicoValidoRule.obtenerInstancia().ejecutar(filtro.getCorreo());
		}
	}
}