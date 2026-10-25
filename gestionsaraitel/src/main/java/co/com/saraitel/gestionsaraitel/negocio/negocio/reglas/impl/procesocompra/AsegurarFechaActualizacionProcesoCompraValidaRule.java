package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import java.time.LocalDateTime;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;

public class AsegurarFechaActualizacionProcesoCompraValidaRule implements Rule<LocalDateTime> {

	private static final Rule<LocalDateTime> instancia = new AsegurarFechaActualizacionProcesoCompraValidaRule();

	private AsegurarFechaActualizacionProcesoCompraValidaRule() {
	}

	public static final Rule<LocalDateTime> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(LocalDateTime... datos) {
		var fechaActualizacion = UtilFecha.obtenerValorDefecto(datos[0]);
		var fechaInicio = UtilFecha.obtenerValorDefecto(datos[1]);

		validarObligatoriedad(fechaActualizacion);
		validarCoherencia(fechaActualizacion, fechaInicio);
	}

	private void validarObligatoriedad(LocalDateTime dato) {
		if (dato.equals(UtilFecha.FECHA_HORA_DEFECTO)) {
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraNegocioImpl.FECHA_ACTUALIZACION_PROCESO_COMPRA_OBLIGATORIA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}

	private void validarCoherencia(LocalDateTime fechaActualizacion, LocalDateTime fechaInicio) {
		if (UtilFecha.esAnterior(fechaActualizacion, fechaInicio)) {
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraNegocioImpl.FECHA_ACTUALIZACION_PROCESO_COMPRA_ANTERIOR_A_FECHA_INICIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
