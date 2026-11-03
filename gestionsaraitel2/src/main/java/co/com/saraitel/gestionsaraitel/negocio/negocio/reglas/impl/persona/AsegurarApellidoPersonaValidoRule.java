package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class AsegurarApellidoPersonaValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarApellidoPersonaValidoRule();

	private static final String FORMATO = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$";

	private AsegurarApellidoPersonaValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var apellidoPersona = datos[0];

		validarObligatoriedad(apellidoPersona);
		validarFormato(apellidoPersona);
		validarLongitud(apellidoPersona, 2, 50);
	}

	private void validarObligatoriedad(String dato) {
		if (UtilTexto.esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.APELLIDO_PERSONA_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		if (!UtilTexto.longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.LONGITUD_APELLIDO_PERSONA_NO_VALIDA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {
		if (!UtilTexto.formatoEsValido(dato, FORMATO)) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.FORMATO_APELLIDO_PERSONA_NO_VALIDO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
