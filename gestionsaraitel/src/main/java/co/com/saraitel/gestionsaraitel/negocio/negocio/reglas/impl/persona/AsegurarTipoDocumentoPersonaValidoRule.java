package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarTipoDocumentoPersonaValidoRule implements Rule<UUID> {

	private static final Rule<UUID> instancia = new AsegurarTipoDocumentoPersonaValidoRule();

	private AsegurarTipoDocumentoPersonaValidoRule() {
	}

	public static final Rule<UUID> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(UUID... datos) {
		var idTipoDocumento = UtilUUID.obtenerValorDefecto(datos[0]);

		validarObligatoriedad(idTipoDocumento);
	}

	private void validarObligatoriedad(UUID dato) {
		if (dato.equals(UtilUUID.obtenerUUIDDefecto())) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.TIPO_DOCUMENTO_PERSONA_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
