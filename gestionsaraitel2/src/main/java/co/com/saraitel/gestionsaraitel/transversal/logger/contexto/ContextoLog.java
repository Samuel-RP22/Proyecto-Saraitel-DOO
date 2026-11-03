package co.com.saraitel.gestionsaraitel.transversal.logger.contexto;

import org.slf4j.MDC;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public final class ContextoLog {

	public static final String CLAVE_CORRELATION_ID = "correlationId";

	private ContextoLog() {
	}

	public static String obtenerCorrelationId() {
		return MDC.get(CLAVE_CORRELATION_ID);
	}

	public static void establecerCorrelationId(final String correlationId) {
		if (UtilTexto.esVacia(correlationId)) {
			MDC.remove(CLAVE_CORRELATION_ID);
		} else {
			MDC.put(CLAVE_CORRELATION_ID, correlationId);
		}
	}
}