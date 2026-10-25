package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import java.math.BigDecimal;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;

public class AsegurarTotalProcesoCompraValidoRule implements Rule<BigDecimal> {

	private static final Rule<BigDecimal> instancia = new AsegurarTotalProcesoCompraValidoRule();

	private AsegurarTotalProcesoCompraValidoRule() {
	}

	public static final Rule<BigDecimal> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(BigDecimal... datos) {
		var total = UtilNumero.obtenerValorDefecto(datos[0]);

		validarRango(total);
	}

	private void validarRango(BigDecimal dato) {
		if (UtilNumero.menorQue(dato, UtilNumero.CERO_DECIMAL)) {
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraNegocioImpl.TOTAL_PROCESO_COMPRA_NO_VALIDO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
