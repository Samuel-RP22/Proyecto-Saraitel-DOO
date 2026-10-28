package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarEmpleadoProcesoCompraEsteActivoRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarEmpleadoProcesoCompraEsteActivoRule();

	private AsegurarEmpleadoProcesoCompraEsteActivoRule() {
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

		if (!empleadoExistente.getEsActivo()) {
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraNegocioImpl.EMPLEADO_PROCESO_COMPRA_NO_ACTIVO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
