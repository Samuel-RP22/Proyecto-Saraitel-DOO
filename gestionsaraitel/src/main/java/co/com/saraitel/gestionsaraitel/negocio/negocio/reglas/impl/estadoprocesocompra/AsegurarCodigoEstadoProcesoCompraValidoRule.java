package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.estadoprocesocompra;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class AsegurarCodigoEstadoProcesoCompraValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarCodigoEstadoProcesoCompraValidoRule();

	private static final String FORMATO_CODIGO = "^[A-Z0-9_]+$";

	private AsegurarCodigoEstadoProcesoCompraValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		var codigoEstadoProcesoCompra = datos[0];

		validarObligatoriedad(codigoEstadoProcesoCompra);
		validarFormato(codigoEstadoProcesoCompra);
		validarLongitud(codigoEstadoProcesoCompra, 2, 20);
	}

	private void validarObligatoriedad(String dato) {
		if (UtilTexto.esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.EstadoProcesoCompraNegocioImpl.CODIGO_ESTADO_PROCESO_COMPRA_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {
		if (!UtilTexto.longitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.EstadoProcesoCompraNegocioImpl.LONGITUD_CODIGO_ESTADO_PROCESO_COMPRA_NO_VALIDA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {
		if (!UtilTexto.formatoEsValido(dato, FORMATO_CODIGO)) {
			var mensajeUsuario = CatalogoMensajes.EstadoProcesoCompraNegocioImpl.FORMATO_CODIGO_ESTADO_PROCESO_COMPRA_NO_VALIDO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
