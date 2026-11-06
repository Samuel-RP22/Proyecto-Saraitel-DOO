package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.EstadoProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;

public class AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule implements Rule<Object> {

	private static final String CODIGO_ESTADO_ANULADO = "AN";
	private static final int MINUTOS_MAXIMOS_INACTIVIDAD = 5;

	private static final Rule<Object> instancia = new AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule();

	private AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var procesoCompra = (ProcesoCompraEntidad) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var fechaLimite = UtilFecha.sumarMinutos(procesoCompra.getFechaActualizacion(), MINUTOS_MAXIMOS_INACTIVIDAD);

		if (UtilFecha.esFechaPasada(fechaLimite)) {
			procesoCompra.setEstado(consultarEstadoAnulado(daoFactory));
			procesoCompra.setFechaActualizacion(UtilFecha.obtenerFechaHoraActual());
			daoFactory.obtenerProcesoCompraDao().actualizar(procesoCompra.getId(), procesoCompra);
		}
	}

	private EstadoProcesoCompraEntidad consultarEstadoAnulado(DAOFactory daoFactory) {
		var estadoFiltro = new EstadoProcesoCompraEntidad();
		estadoFiltro.setCodigo(CODIGO_ESTADO_ANULADO);

		return daoFactory.obtenerEstadoProcesoCompraDao().consultarPorFiltro(estadoFiltro).get(0);
	}
}
