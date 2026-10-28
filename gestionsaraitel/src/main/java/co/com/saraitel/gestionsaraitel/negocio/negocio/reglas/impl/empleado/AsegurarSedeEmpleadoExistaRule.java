package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarSedeEmpleadoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarSedeEmpleadoExistaRule();

	private AsegurarSedeEmpleadoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var idSede = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var sedeExistente = daoFactory.obtenerSedeDao().consultarPorId(idSede);

		if (UtilUUID.esValorDefecto(sedeExistente.getId())) {
			var mensajeUsuario = CatalogoMensajes.EmpleadoNegocioImpl.SEDE_EMPLEADO_NO_EXISTE;

			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
