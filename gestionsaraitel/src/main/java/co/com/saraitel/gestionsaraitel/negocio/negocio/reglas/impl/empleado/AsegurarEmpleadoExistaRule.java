package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarEmpleadoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarEmpleadoExistaRule();

	private AsegurarEmpleadoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var idEmpleado = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var empleadoExistente = daoFactory.obtenerEmpleadoDao().consultarPorId(idEmpleado);

		if (UtilUUID.esValorDefecto(empleadoExistente.getId())) {
			var mensajeUsuario = CatalogoMensajes.EmpleadoNegocioImpl.EMPLEADO_NO_EXISTE;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
