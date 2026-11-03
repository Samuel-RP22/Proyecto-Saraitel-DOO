package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class AsegurarRazonSocialClienteJuridicoValidaRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarRazonSocialClienteJuridicoValidaRule();

	private static final String FORMATO_RAZON_SOCIAL = "^[A-Za-zÁÉÍÓÚáéíóúÑñÜü0-9 .,&\\-]+$";

	private AsegurarRazonSocialClienteJuridicoValidaRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var razonSocialClienteJuridico = datos[0];

		validarObligatoriedad(razonSocialClienteJuridico);
		validarFormato(razonSocialClienteJuridico);
		validarLongitud(razonSocialClienteJuridico, 2, 100);
	}

	private void validarObligatoriedad(String dato) {
		if (UtilTexto.esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.RAZON_SOCIAL_CLIENTE_JURIDICO_OBLIGATORIA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		if (!UtilTexto.longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.LONGITUD_RAZON_SOCIAL_CLIENTE_JURIDICO_NO_VALIDA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {
		if (!UtilTexto.formatoEsValido(dato, FORMATO_RAZON_SOCIAL)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.FORMATO_RAZON_SOCIAL_CLIENTE_JURIDICO_NO_VALIDO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
