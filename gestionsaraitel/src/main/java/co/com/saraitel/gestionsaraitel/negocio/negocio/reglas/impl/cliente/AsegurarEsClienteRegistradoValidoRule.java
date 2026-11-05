package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.cliente;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class AsegurarEsClienteRegistradoValidoRule implements Rule<Boolean> {

	private static final Rule<Boolean> instancia = new AsegurarEsClienteRegistradoValidoRule();

	private AsegurarEsClienteRegistradoValidoRule() {
	}

	public static final Rule<Boolean> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Boolean... datos) {
		Rule.asegurarCantidadDatos(datos, 1);
		var esClienteRegistrado = datos[0];
		validarObligatoriedad(esClienteRegistrado);
	}

	private void validarObligatoriedad(Boolean dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.ES_CLIENTE_REGISTRADO_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}