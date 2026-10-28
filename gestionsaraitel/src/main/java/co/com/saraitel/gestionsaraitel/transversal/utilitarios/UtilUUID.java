package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

import java.util.UUID;
import java.util.function.UnaryOperator;

public final class UtilUUID {

	private static final UUID UUID_DEFECTO = new UUID(0L, 0L);

	private UtilUUID() {
	}

	public static UUID generar() {
		return UUID.ofEpochMillis(UtilFecha.obtenerEpochMilliActual());
	}

	public static UUID obtenerUUIDDefecto() {
		return UUID_DEFECTO;
	}

	public static String obtenerValorDefectoComoTexto(final String UUIDTexto) {
		return UtilTexto.esVacia(UUIDTexto) ? UUID_DEFECTO.toString() : UtilTexto.quitarEspaciosEnBlanco(UUIDTexto);
	}

	public static UUID convertirAUUID(final String UUIDTexto) {
		try {
			return UUID.fromString(obtenerValorDefectoComoTexto(UUIDTexto));
		} catch (IllegalArgumentException _) {
			return obtenerUUIDDefecto();
		}
	}

	public static UUID obtenerValorDefecto(final UUID valor, final UUID valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
	}

	public static UUID obtenerValorDefecto(final UUID valor) {
		return obtenerValorDefecto(valor, obtenerUUIDDefecto());
	}
	
	public static boolean esValorDefecto(final UUID valor) {
		return obtenerUUIDDefecto().equals(obtenerValorDefecto(valor));
	}

	public static String generarComoTexto() {
		return generar().toString();
	}

	public static UUID generarIdUnico(final UnaryOperator<UUID> consultarIdExistente) {
		UUID id;
		do {
			id = generar();
		} while (!consultarIdExistente.apply(id).equals(obtenerUUIDDefecto()));
		return id;
	}
}