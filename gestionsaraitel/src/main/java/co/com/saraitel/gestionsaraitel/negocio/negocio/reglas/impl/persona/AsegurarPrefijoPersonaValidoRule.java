package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarPrefijoPersonaValidoRule implements Rule<UUID> {

	private static final Rule<UUID> instancia = new AsegurarPrefijoPersonaValidoRule();

	private AsegurarPrefijoPersonaValidoRule() {
	}

	public static final Rule<UUID> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(UUID... datos) {
		var idPrefijo = UtilUUID.obtenerValorDefecto(datos[0]);

		validarObligatoriedad(idPrefijo);
	}

	private void validarObligatoriedad(UUID dato) {
		if (UtilUUID.esValorDefecto(dato)) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.PREFIJO_PERSONA_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
