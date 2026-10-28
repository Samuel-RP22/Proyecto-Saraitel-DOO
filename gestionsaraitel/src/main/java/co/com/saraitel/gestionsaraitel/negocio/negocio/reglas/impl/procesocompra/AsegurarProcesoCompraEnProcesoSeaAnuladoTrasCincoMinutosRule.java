package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import java.util.Optional;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.EstadoProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;

public class AsegurarProcesoCompraEnProcesoSeaAnuladoTrasCincoMinutosRule implements Rule<Object> {

	private static final String CODIGO_ESTADO_EN_PROCESO = "EP";
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
		var estadoEnProceso = consultarEstadoPorCodigo(CODIGO_ESTADO_EN_PROCESO, daoFactory);
		if (estadoEnProceso.isEmpty() || !procesoCompra.getEstado().getId().equals(estadoEnProceso.get().getId())) {
			return;
		}
		var fechaLimite = UtilFecha.sumarMinutos(procesoCompra.getFechaActualizacion(), MINUTOS_MAXIMOS_INACTIVIDAD);
		if (!UtilFecha.esFechaPasada(fechaLimite)) {
			return;
		}
		var estadoAnulado = consultarEstadoPorCodigo(CODIGO_ESTADO_ANULADO, daoFactory);
		if (estadoAnulado.isEmpty()) {
			return;
		}
		procesoCompra.setEstado(estadoAnulado.get());
		procesoCompra.setFechaActualizacion(UtilFecha.obtenerFechaHoraActual());
		daoFactory.obtenerProcesoCompraDao().actualizar(procesoCompra.getId(), procesoCompra);
	}

	private Optional<EstadoProcesoCompraEntidad> consultarEstadoPorCodigo(final String codigo,
			final DAOFactory daoFactory) {
		var filtro = new EstadoProcesoCompraEntidad();
		filtro.setCodigo(codigo);

		return daoFactory.obtenerEstadoProcesoCompraDao().consultarPorFiltro(filtro).stream().findFirst();
	}
}