package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;

public class AsegurarNuevoProcesoCompraNoEsteDuplicadoRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarNuevoProcesoCompraNoEsteDuplicadoRule();

	private AsegurarNuevoProcesoCompraNoEsteDuplicadoRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var procesoCompra = (ProcesoCompraEntidad) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var idCliente = procesoCompra.getCliente().getId();
		var idEmpleado = procesoCompra.getEmpleado().getId();

		AsegurarClienteNoTengaProcesoCompraConMismaFechaInicioRule.obtenerInstancia().ejecutar(idCliente,
				procesoCompra.getFechaInicio(), daoFactory);
		AsegurarClienteNoTengaProcesoCompraConMismaFechaActualizacionRule.obtenerInstancia().ejecutar(idCliente,
				procesoCompra.getFechaActualizacion(), daoFactory);
		AsegurarEmpleadoNoTengaProcesoCompraConMismaFechaInicioRule.obtenerInstancia().ejecutar(idEmpleado,
				procesoCompra.getFechaInicio(), daoFactory);
		AsegurarEmpleadoNoTengaProcesoCompraConMismaFechaActualizacionRule.obtenerInstancia().ejecutar(idEmpleado,
				procesoCompra.getFechaActualizacion(), daoFactory);
	}
}
