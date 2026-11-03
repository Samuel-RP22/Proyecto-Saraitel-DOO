package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class AsegurarNombreSedeValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarNombreSedeValidoRule();

	private AsegurarNombreSedeValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var nombreSede = datos[0];

		validarObligatoriedad(nombreSede);
		validarFormato(nombreSede);
		validarLongitud(nombreSede, 1, 50);
	}

	private void validarObligatoriedad(String dato) {
		if (UtilTexto.esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.SedeNegocioImpl.NOMBRE_SEDE_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		if (!UtilTexto.longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.SedeNegocioImpl.LONGITUD_NOMBRE_SEDE_NO_VALIDA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {
		if (!UtilTexto.formatoEsValido(dato, UtilTexto.SOLO_LETRAS_Y_ESPACIOS)) {
			var mensajeUsuario = CatalogoMensajes.SedeNegocioImpl.FORMATO_NOMBRE_SEDE_NO_VALIDO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
