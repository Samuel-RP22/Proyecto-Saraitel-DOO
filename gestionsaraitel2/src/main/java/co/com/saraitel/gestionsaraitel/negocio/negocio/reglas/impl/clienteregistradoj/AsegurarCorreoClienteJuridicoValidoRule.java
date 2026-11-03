package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class AsegurarCorreoClienteJuridicoValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarCorreoClienteJuridicoValidoRule();

	private AsegurarCorreoClienteJuridicoValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var correoClienteJuridico = datos[0];

		validarObligatoriedad(correoClienteJuridico);
		validarFormato(correoClienteJuridico);
		validarLongitud(correoClienteJuridico, 6, 100);
	}

	private void validarObligatoriedad(String dato) {
		if (UtilTexto.esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.CORREO_CLIENTE_JURIDICO_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		if (!UtilTexto.longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.LONGITUD_CORREO_CLIENTE_JURIDICO_NO_VALIDA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {
		if (!UtilTexto.formatoEsValido(dato, UtilTexto.FORMATO_CORREO)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.FORMATO_CORREO_CLIENTE_JURIDICO_NO_VALIDO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
