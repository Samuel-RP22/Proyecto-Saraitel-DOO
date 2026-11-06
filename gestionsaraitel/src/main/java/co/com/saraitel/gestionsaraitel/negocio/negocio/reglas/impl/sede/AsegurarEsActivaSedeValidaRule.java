package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class AsegurarEsActivaSedeValidaRule implements Rule<Boolean> {

	private static final Rule<Boolean> instancia = new AsegurarEsActivaSedeValidaRule();

	private AsegurarEsActivaSedeValidaRule() {
	}

	public static final Rule<Boolean> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Boolean... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var esActiva = datos[0];

		validarObligatoriedad(esActiva);
	}

	private void validarObligatoriedad(Boolean dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.SedeNegocioImpl.ES_ACTIVA_SEDE_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
