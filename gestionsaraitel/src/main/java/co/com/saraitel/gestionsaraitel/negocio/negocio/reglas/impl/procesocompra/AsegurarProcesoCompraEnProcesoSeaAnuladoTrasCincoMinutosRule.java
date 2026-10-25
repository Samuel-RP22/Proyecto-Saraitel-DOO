package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.EstadoProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;

public class AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule implements Rule<Object> {

	private static final String CODIGO_ESTADO_EN_PROCESO = "EP";
	private static final String CODIGO_ESTADO_ANULADO = "AN";
	private static final long MINUTOS_MAXIMOS_INACTIVIDAD = 5;

	private static final Rule<Object> instancia = new AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule();

	private AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var procesoCompra = (ProcesoCompraEntidad) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var estadoEnProceso = consultarEstadoPorCodigo(CODIGO_ESTADO_EN_PROCESO, daoFactory);

		if (estadoEnProceso == null || !procesoCompra.getEstado().getId().equals(estadoEnProceso.getId())) {
			return;
		}

		var fechaLimite = procesoCompra.getFechaActualizacion().plusMinutes(MINUTOS_MAXIMOS_INACTIVIDAD);

		if (!UtilFecha.esAnterior(fechaLimite, UtilFecha.obtenerFechaHoraActual())) {
			return;
		}

		var estadoAnulado = consultarEstadoPorCodigo(CODIGO_ESTADO_ANULADO, daoFactory);

		if (estadoAnulado == null) {
			return;
		}

		procesoCompra.setEstado(estadoAnulado);
		procesoCompra.setFechaActualizacion(UtilFecha.obtenerFechaHoraActual());

		daoFactory.obtenerProcesoCompraDao().actualizar(procesoCompra.getId(), procesoCompra);
	}

	private EstadoProcesoCompraEntidad consultarEstadoPorCodigo(String codigo, DAOFactory daoFactory) {
		var filtro = new EstadoProcesoCompraEntidad();
		filtro.setCodigo(codigo);

		var resultados = daoFactory.obtenerEstadoProcesoCompraDao().consultarPorFiltro(filtro);

		return resultados.isEmpty() ? null : resultados.get(0);
	}
}
