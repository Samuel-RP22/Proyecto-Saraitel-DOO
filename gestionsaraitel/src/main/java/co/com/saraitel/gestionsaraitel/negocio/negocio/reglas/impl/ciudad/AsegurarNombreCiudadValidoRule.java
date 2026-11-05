package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.ciudad;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class AsegurarNombreCiudadValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarNombreCiudadValidoRule();

	private AsegurarNombreCiudadValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		var nombreCiudad = datos[0];

		validarObligatoriedad(nombreCiudad);
		validarLongitud(nombreCiudad, 2, 50);
		validarFormato(nombreCiudad);
	}

	private void validarObligatoriedad(String dato) {
		if (UtilTexto.obtenerLongitudCadena(dato, true) == 0) {
			var mensajeUsuario = CatalogoMensajes.CiudadNegocioImpl.NOMBRE_CIUDAD_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		if (!UtilTexto.longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.CiudadNegocioImpl.LONGITUD_NOMBRE_CIUDAD_NO_VALIDA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {
		if (!UtilTexto.formatoEsValido(dato, UtilTexto.SOLO_LETRAS_Y_ESPACIOS)) {
			var mensajeUsuario = CatalogoMensajes.CiudadNegocioImpl.FORMATO_NOMBRE_CIUDAD_NO_VALIDO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}