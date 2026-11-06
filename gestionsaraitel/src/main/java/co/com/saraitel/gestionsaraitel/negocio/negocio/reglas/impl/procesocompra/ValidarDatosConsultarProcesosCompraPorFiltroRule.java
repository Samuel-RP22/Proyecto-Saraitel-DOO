package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.ProcesoCompraDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ValidarDatosConsultarProcesosCompraPorFiltroRule implements Rule<Object> {

	private static final Rule<Object> instancia = new ValidarDatosConsultarProcesosCompraPorFiltroRule();

	private ValidarDatosConsultarProcesosCompraPorFiltroRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var filtro = (ProcesoCompraDominio) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var idCliente = filtro.getCliente().getId();
		var idEmpleado = filtro.getEmpleado().getId();
		var idEstado = filtro.getEstado().getId();

		if (!UtilUUID.esValorDefecto(idCliente)) {
			AsegurarClienteProcesoCompraExistaRule.obtenerInstancia().ejecutar(idCliente, daoFactory);
		}

		if (!UtilUUID.esValorDefecto(idEmpleado)) {
			AsegurarEmpleadoProcesoCompraExistaRule.obtenerInstancia().ejecutar(idEmpleado, daoFactory);
		}

		if (!UtilUUID.esValorDefecto(idEstado)) {
			AsegurarEstadoProcesoCompraExistaRule.obtenerInstancia().ejecutar(idEstado, daoFactory);
		}
	}
}
