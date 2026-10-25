package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarEstadoDelProcesoCompraValidoRule implements Rule<UUID> {

	private static final Rule<UUID> instancia = new AsegurarEstadoDelProcesoCompraValidoRule();

	private AsegurarEstadoDelProcesoCompraValidoRule() {
	}

	public static final Rule<UUID> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(UUID... datos) {
		var idEstado = UtilUUID.obtenerValorDefecto(datos[0]);

		validarObligatoriedad(idEstado);
	}

	private void validarObligatoriedad(UUID dato) {
		if (dato.equals(UtilUUID.obtenerUUIDDefecto())) {
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraNegocioImpl.ESTADO_PROCESO_COMPRA_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
