package co.edu.uco.libreriauco.transversal.utilitarios;

public final class UtilObjeto {

    private UtilObjeto() {
    }

    public static <O> boolean esNulo(final O objeto) {
        return objeto == null;
    }

    public static <O> O obtenerValorDefectoSiValorOriginalEsNulo(final O valor, final O valorDefecto) {
        return esNulo(valor) ? valorDefecto : valor;
    }
}