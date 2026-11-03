package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarPrefijoClienteJuridicoValidoRule implements Rule<UUID> {

	private static final Rule<UUID> instancia = new AsegurarPrefijoClienteJuridicoValidoRule();

	private AsegurarPrefijoClienteJuridicoValidoRule() {
	}

	public static final Rule<UUID> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(UUID... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var idPrefijo = UtilUUID.obtenerValorDefecto(datos[0]);

		validarObligatoriedad(idPrefijo);
	}

	private void validarObligatoriedad(UUID dato) {
		if (UtilUUID.esValorDefecto(dato)) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.PREFIJO_CLIENTE_JURIDICO_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
