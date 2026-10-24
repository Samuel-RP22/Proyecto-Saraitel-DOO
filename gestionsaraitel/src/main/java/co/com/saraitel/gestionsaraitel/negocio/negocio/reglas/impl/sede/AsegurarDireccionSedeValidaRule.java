package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class AsegurarDireccionSedeValidaRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarDireccionSedeValidaRule();

	private static final String FORMATO_DIRECCION = "^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9 #\\-.,°]+$";

	private AsegurarDireccionSedeValidaRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		var direccionSede = datos[0];

		validarObligatoriedad(direccionSede);
		validarFormato(direccionSede);
		validarLongitud(direccionSede, 5, 100);
	}

	private void validarObligatoriedad(String dato) {
		if (UtilTexto.esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.SedeNegocioImpl.DIRECCION_SEDE_OBLIGATORIA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		if (!UtilTexto.longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.SedeNegocioImpl.LONGITUD_DIRECCION_SEDE_NO_VALIDA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {
		if (!UtilTexto.formatoEsValido(dato, FORMATO_DIRECCION)) {
			var mensajeUsuario = CatalogoMensajes.SedeNegocioImpl.FORMATO_DIRECCION_SEDE_NO_VALIDO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
