package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarClienteProcesoCompraValidoRule implements Rule<UUID> {

	private static final Rule<UUID> instancia = new AsegurarClienteProcesoCompraValidoRule();

	private AsegurarClienteProcesoCompraValidoRule() {
	}

	public static final Rule<UUID> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(UUID... datos) {
		var idCliente = UtilUUID.obtenerValorDefecto(datos[0]);

		validarObligatoriedad(idCliente);
	}

	private void validarObligatoriedad(UUID dato) {
		if (dato.equals(UtilUUID.obtenerUUIDDefecto())) {
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraNegocioImpl.CLIENTE_PROCESO_COMPRA_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
