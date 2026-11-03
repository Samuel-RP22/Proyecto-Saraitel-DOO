package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.estadoprocesocompra;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class AsegurarNombreEstadoProcesoCompraValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarNombreEstadoProcesoCompraValidoRule();

	private AsegurarNombreEstadoProcesoCompraValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var nombreEstadoProcesoCompra = datos[0];

		validarObligatoriedad(nombreEstadoProcesoCompra);
		validarFormato(nombreEstadoProcesoCompra);
		validarLongitud(nombreEstadoProcesoCompra, 1, 50);
	}

	private void validarObligatoriedad(String dato) {
		if (UtilTexto.esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.EstadoProcesoCompraNegocioImpl.NOMBRE_ESTADO_PROCESO_COMPRA_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		if (!UtilTexto.longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.EstadoProcesoCompraNegocioImpl.LONGITUD_NOMBRE_ESTADO_PROCESO_COMPRA_NO_VALIDA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {
		if (!UtilTexto.formatoEsValido(dato, UtilTexto.SOLO_LETRAS_Y_ESPACIOS)) {
			var mensajeUsuario = CatalogoMensajes.EstadoProcesoCompraNegocioImpl.FORMATO_NOMBRE_ESTADO_PROCESO_COMPRA_NO_VALIDO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
