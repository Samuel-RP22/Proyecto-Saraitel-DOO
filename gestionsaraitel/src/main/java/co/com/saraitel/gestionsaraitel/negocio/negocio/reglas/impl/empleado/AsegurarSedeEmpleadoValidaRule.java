package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarSedeEmpleadoValidaRule implements Rule<UUID> {

	private static final Rule<UUID> instancia = new AsegurarSedeEmpleadoValidaRule();

	private AsegurarSedeEmpleadoValidaRule() {
	}

	public static final Rule<UUID> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(UUID... datos) {
		var idSede = UtilUUID.obtenerValorDefecto(datos[0]);

		validarObligatoriedad(idSede);
	}

	private void validarObligatoriedad(UUID dato) {
		if (UtilUUID.esValorDefecto(dato)) {
			var mensajeUsuario = CatalogoMensajes.EmpleadoNegocioImpl.SEDE_EMPLEADO_OBLIGATORIA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
