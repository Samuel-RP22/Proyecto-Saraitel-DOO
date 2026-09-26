package co.edu.uco.libreriauco.transversal.utilitarios;

import java.util.UUID;

public final class UtilUUID {

    public static final String UUID_DEFECTO_TEXTO = "00000000-0000-0000-0000-000000000000";

    private UtilUUID() {
    }

    public static UUID generar() {
        return UUID.randomUUID();
    }

    public static UUID obtenerUUIDDefecto() {
        return UUID.fromString(UUID_DEFECTO_TEXTO);
    }

    public static String obtenerValorDefectoComoTexto(final String UUIDTexto) {
        return UtilTexto.getUtilTexto().esVacia(UUIDTexto) 
                ? UUID_DEFECTO_TEXTO 
                : UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(UUIDTexto);
    }

    public static UUID convertirAUUID(final String UUIDTexto) {
        try {
            return UUID.fromString(obtenerValorDefectoComoTexto(UUIDTexto));
        } catch (IllegalArgumentException e) {
            return obtenerUUIDDefecto();
        }
    }

    public static UUID obtenerValorDefecto(final UUID valor, final UUID valorDefecto) {
        return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
    }

    public static UUID obtenerValorDefecto(final UUID valor) {
        return obtenerValorDefecto(valor, obtenerUUIDDefecto());
    }
}