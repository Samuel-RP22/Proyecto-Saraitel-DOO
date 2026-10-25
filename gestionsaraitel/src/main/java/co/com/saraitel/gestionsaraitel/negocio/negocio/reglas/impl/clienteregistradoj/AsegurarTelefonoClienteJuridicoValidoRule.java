package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class AsegurarTelefonoClienteJuridicoValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarTelefonoClienteJuridicoValidoRule();

	private static final String FORMATO_TELEFONO = "^[0-9]+$";

	private AsegurarTelefonoClienteJuridicoValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		var telefonoClienteJuridico = datos[0];

		validarObligatoriedad(telefonoClienteJuridico);
		validarFormato(telefonoClienteJuridico);
		validarLongitud(telefonoClienteJuridico, 7, 15);
	}

	private void validarObligatoriedad(String dato) {
		if (UtilTexto.esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.TELEFONO_CLIENTE_JURIDICO_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		if (!UtilTexto.longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.LONGITUD_TELEFONO_CLIENTE_JURIDICO_NO_VALIDA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {
		if (!UtilTexto.formatoEsValido(dato, FORMATO_TELEFONO)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.FORMATO_TELEFONO_CLIENTE_JURIDICO_NO_VALIDO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
