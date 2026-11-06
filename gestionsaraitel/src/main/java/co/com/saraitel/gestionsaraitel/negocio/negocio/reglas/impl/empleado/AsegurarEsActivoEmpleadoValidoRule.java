package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class AsegurarEsActivoEmpleadoValidoRule implements Rule<Boolean> {

	private static final Rule<Boolean> instancia = new AsegurarEsActivoEmpleadoValidoRule();

	private AsegurarEsActivoEmpleadoValidoRule() {
	}

	public static final Rule<Boolean> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Boolean... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var esActivo = datos[0];

		validarObligatoriedad(esActivo);
	}

	private void validarObligatoriedad(Boolean dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.EmpleadoNegocioImpl.ES_ACTIVO_EMPLEADO_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
