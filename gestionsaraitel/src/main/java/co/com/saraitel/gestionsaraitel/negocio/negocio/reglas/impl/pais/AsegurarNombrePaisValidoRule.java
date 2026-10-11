package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.pais;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioException;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class AsegurarNombrePaisValidoRule implements Rule<String> {
	
	private static final Rule<String> instancia = new AsegurarNombrePaisValidoRule();
	
	private AsegurarNombrePaisValidoRule() {
	}
	
	public static final Rule<String> obtenerInstancia(){
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		var nombrePais = datos[0];
		
		validarObligatoriedad(nombrePais);
		validarFormato(nombrePais);	
		validarLongitud(nombrePais, 1, 50);
	}
	
	private void validarObligatoriedad(String dato) {
		if (UtilTexto.esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.PaisNegocioImpl.LONGITUD_NOMBRE_PAIS_NO_VALIDA;
			throw GestionSaraitelNegocioException.crear(mensajeUsuario);
		}
	}
	
	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		if (!UtilTexto.longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.PaisNegocioImpl.LONGITUD_NOMBRE_PAIS_NO_VALIDA;
			throw GestionSaraitelNegocioException.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {
		if (!UtilTexto.formatoEsValido(dato, UtilTexto.SOLO_LETRAS_Y_ESPACIOS)) {
			var mensajeUsuario = CatalogoMensajes.PaisNegocioImpl.FORMATO_NOMBRE_PAIS_NO_VALIDO;
			throw GestionSaraitelNegocioException.crear(mensajeUsuario);
		}
	}
}
