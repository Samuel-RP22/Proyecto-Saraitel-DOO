package co.com.saraitel.gestionsaraitel.transversal.utilitarios;}

public final class UtilBoolean {

    private static final boolean DEFECTO = false;

    private UtilBoolean() {
        super();
    }

    // Ya los tienes
    public static boolean obtenerBooleanoDefecto() {
        return DEFECTO;
    }

    public static boolean obtenerValorDefecto(final Boolean valor) {
        return valor == null ? DEFECTO : valor;
    }

    // Sobrecarga: default distinto según el caso
    public static boolean obtenerValorDefecto(final Boolean valor, final boolean valorDefecto) {
        return valor == null ? valorDefecto : valor;
    }

    // Comprobaciones null-safe
    public static boolean esNulo(final Boolean valor) {
        return valor == null;
    }

    public static boolean esVerdadero(final Boolean valor) {
        return Boolean.TRUE.equals(valor);
    }

    public static boolean esFalso(final Boolean valor) {
        return Boolean.FALSE.equals(valor);
    }
