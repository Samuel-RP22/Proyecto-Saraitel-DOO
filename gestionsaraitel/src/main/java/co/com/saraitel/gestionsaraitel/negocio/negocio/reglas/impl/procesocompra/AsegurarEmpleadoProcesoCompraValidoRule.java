package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarEmpleadoProcesoCompraValidoRule implements Rule<UUID> {

	private static final Rule<UUID> instancia = new AsegurarEmpleadoProcesoCompraValidoRule();

	private AsegurarEmpleadoProcesoCompraValidoRule() {
	}

	public static final Rule<UUID> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(UUID... datos) {
		var idEmpleado = UtilUUID.obtenerValorDefecto(datos[0]);

		validarObligatoriedad(idEmpleado);
	}

	private void validarObligatoriedad(UUID dato) {
		if (dato.equals(UtilUUID.obtenerUUIDDefecto())) {
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraNegocioImpl.EMPLEADO_PROCESO_COMPRA_OBLIGATORIO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
