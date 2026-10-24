package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarSedeEmpleadoEsteActivaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarSedeEmpleadoEsteActivaRule();

	private AsegurarSedeEmpleadoEsteActivaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var idSede = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var sedeExistente = daoFactory.obtenerSedeDao().consultarPorId(idSede);

		if (!sedeExistente.getEsActiva()) {
			var mensajeUsuario = CatalogoMensajes.EmpleadoNegocioImpl.SEDE_EMPLEADO_NO_ACTIVA;

			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
