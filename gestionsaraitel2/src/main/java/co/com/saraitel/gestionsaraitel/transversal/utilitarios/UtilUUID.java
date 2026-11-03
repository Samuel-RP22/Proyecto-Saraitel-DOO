package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

import java.util.Objects;
import java.util.UUID;
import java.util.function.UnaryOperator;

public final class UtilUUID {

	private static final UUID UUID_DEFECTO = new UUID(0L, 0L);
	private static final String UUID_DEFECTO_TEXTO = "00000000-0000-0000-0000-000000000000";

	private UtilUUID() {
	}

	public static UUID generar() {
		return UUID.ofEpochMillis(UtilFecha.obtenerEpochMilliActual());
	}

	public static UUID obtenerUUIDDefecto() {
		return UUID_DEFECTO;
	}

	public static String obtenerValorDefectoComoTexto(final String UUIDTexto) {
		var textoSanitizado = UtilTexto.quitarEspaciosEnBlanco(UUIDTexto);
		return UtilTexto.esVacia(textoSanitizado) ? UUID_DEFECTO_TEXTO : textoSanitizado;
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
		return Objects.equals(obtenerValorDefecto(valor), obtenerUUIDDefecto());
	}

	public static String generarComoTexto() {
		return generar().toString();
	}

	public static UUID generarIdUnico(final UnaryOperator<UUID> consultarIdExistente) {
		UUID id;
		do {
			id = generar();
		} while (!esValorDefecto(consultarIdExistente.apply(id)));
		return id;
	}
}