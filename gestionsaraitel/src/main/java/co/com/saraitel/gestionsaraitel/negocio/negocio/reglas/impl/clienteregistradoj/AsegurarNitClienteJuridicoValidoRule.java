package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class AsegurarNitClienteJuridicoValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarNitClienteJuridicoValidoRule();

	private AsegurarNitClienteJuridicoValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		var nitClienteJuridico = datos[0];

		validarObligatoriedad(nitClienteJuridico);
		validarFormato(nitClienteJuridico);
		validarLongitud(nitClienteJuridico, 9, 12);
	}

	private void validarObligatoriedad(String dato) {
		if (UtilTexto.esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.NIT_CLIENTE_JURIDICO_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		if (!UtilTexto.longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.LONGITUD_NIT_CLIENTE_JURIDICO_NO_VALIDA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {
		if (!UtilTexto.formatoEsValido(dato, UtilTexto.FORMATO_NIT)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.FORMATO_NIT_CLIENTE_JURIDICO_NO_VALIDO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
