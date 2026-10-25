package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import java.time.LocalDateTime;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;

public class AsegurarFechaInicioProcesoCompraValidaRule implements Rule<LocalDateTime> {

	private static final Rule<LocalDateTime> instancia = new AsegurarFechaInicioProcesoCompraValidaRule();

	private AsegurarFechaInicioProcesoCompraValidaRule() {
	}

	public static final Rule<LocalDateTime> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(LocalDateTime... datos) {
		var fechaInicio = UtilFecha.obtenerValorDefecto(datos[0]);

		validarObligatoriedad(fechaInicio);
	}

	private void validarObligatoriedad(LocalDateTime dato) {
		if (dato.equals(UtilFecha.FECHA_HORA_DEFECTO)) {
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraNegocioImpl.FECHA_INICIO_PROCESO_COMPRA_OBLIGATORIA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
