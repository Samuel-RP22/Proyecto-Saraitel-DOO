package co.com.saraitel.gestionsaraitel.transversal.logger;

import java.util.EnumSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.enums.Capa;
import co.com.saraitel.gestionsaraitel.transversal.logger.contexto.ContextoLog;

public final class GestionSaraitelLogger {

	private static final Set<Capa> CAPAS_CON_FALLAS_ESPERADAS = EnumSet.of(Capa.NEGOCIO);
	private static final String REGLA_INCUMPLIDA = "Regla incumplida en la capa {}: {}";
	private static final String FALLA_CAPA = "Falla en la capa {}: {}";
	private static final String FALLA_NO_CONTROLADA = "Falla no controlada: {}";

	private final Logger logger;

	private GestionSaraitelLogger(final Logger logger) {
		this.logger = logger;
	}

	public static GestionSaraitelLogger obtener(final Class<?> clase) {
		return new GestionSaraitelLogger(LoggerFactory.getLogger(clase));
	}

	public void debug(final String mensaje, final Object... argumentos) {
		logger.debug(mensaje, argumentos);
	}

	public void info(final String mensaje, final Object... argumentos) {
		logger.info(mensaje, argumentos);
	}

	public void advertencia(final String mensaje, final Object... argumentos) {
		logger.warn(mensaje, argumentos);
	}

	public void error(final String mensaje, final Object... argumentos) {
		logger.error(mensaje, argumentos);
	}

	public void registrarExcepcion(final Exception excepcion) {
		if (excepcion instanceof GestionSaraitelExcepcion excepcionPropia) {
			registrarExcepcionPropia(excepcionPropia);
		} else {
			error(FALLA_NO_CONTROLADA, excepcion.getMessage(), excepcion);
		}
	}

	public void registrarExcepcion(final String correlationId, final Exception excepcion) {
		var correlationIdAnterior = ContextoLog.obtenerCorrelationId();
		ContextoLog.establecerCorrelationId(correlationId);
		try {
			registrarExcepcion(excepcion);
		} finally {
			ContextoLog.establecerCorrelationId(correlationIdAnterior);
		}
	}

	private void registrarExcepcionPropia(final GestionSaraitelExcepcion excepcion) {
		if (CAPAS_CON_FALLAS_ESPERADAS.contains(excepcion.getCapa())) {
			advertencia(REGLA_INCUMPLIDA, excepcion.getCapa(), excepcion.getMensajeTecnico());
		} else {
			error(FALLA_CAPA, excepcion.getCapa(), excepcion.getMensajeTecnico(), excepcion);
		}
	}
}