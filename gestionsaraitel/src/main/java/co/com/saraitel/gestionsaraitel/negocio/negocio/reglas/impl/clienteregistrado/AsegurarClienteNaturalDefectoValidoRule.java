package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistrado;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class AsegurarClienteNaturalDefectoValidoRule implements Rule<Boolean> {

	private static final Rule<Boolean> instancia = new AsegurarClienteNaturalDefectoValidoRule();

	private AsegurarClienteNaturalDefectoValidoRule() {
	}

	public static final Rule<Boolean> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Boolean... datos) {
		Rule.asegurarCantidadDatos(datos, 1);
		var clienteNaturalDefecto = datos[0];
		validarObligatoriedad(clienteNaturalDefecto);
	}

	private void validarObligatoriedad(Boolean dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNegocioImpl.CLIENTE_NATURAL_DEFECTO_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}