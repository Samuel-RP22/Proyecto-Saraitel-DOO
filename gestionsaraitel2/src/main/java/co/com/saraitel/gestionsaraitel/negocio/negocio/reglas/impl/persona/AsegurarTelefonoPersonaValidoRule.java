package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class AsegurarTelefonoPersonaValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarTelefonoPersonaValidoRule();

	private AsegurarTelefonoPersonaValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var telefonoPersona = datos[0];

		validarObligatoriedad(telefonoPersona);
		validarFormato(telefonoPersona);
		validarLongitud(telefonoPersona, 7, 15);
	}

	private void validarObligatoriedad(String dato) {
		if (UtilTexto.esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.TELEFONO_PERSONA_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		if (!UtilTexto.longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.LONGITUD_TELEFONO_PERSONA_NO_VALIDA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {
		if (!UtilTexto.formatoEsValido(dato, UtilTexto.SOLO_NUMEROS)) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.FORMATO_TELEFONO_PERSONA_NO_VALIDO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
