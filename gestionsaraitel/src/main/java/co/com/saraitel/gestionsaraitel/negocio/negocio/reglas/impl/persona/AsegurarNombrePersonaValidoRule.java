package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class AsegurarNombrePersonaValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarNombrePersonaValidoRule();

	private static final String FORMATO = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$";

	private AsegurarNombrePersonaValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var nombrePersona = datos[0];

		validarObligatoriedad(nombrePersona);
		validarFormato(nombrePersona);
		validarLongitud(nombrePersona, 2, 50);
	}

	private void validarObligatoriedad(String dato) {
		if (UtilTexto.esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.NOMBRE_PERSONA_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		if (!UtilTexto.longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.LONGITUD_NOMBRE_PERSONA_NO_VALIDA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {
		if (!UtilTexto.formatoEsValido(dato, FORMATO)) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.FORMATO_NOMBRE_PERSONA_NO_VALIDO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
