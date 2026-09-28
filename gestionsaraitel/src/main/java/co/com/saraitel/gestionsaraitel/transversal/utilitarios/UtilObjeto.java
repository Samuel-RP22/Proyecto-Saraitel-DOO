package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

public final class UtilObjeto {

    private UtilObjeto() {
    }
    public static boolean conexionEstaAbierta(Conecction conexion) {
    try {
    	return (!conexionEstaVacia(conexion) && !conexion.getConexion().isClosed());
    } catch
    }
    public static boolean conexionEstaVacia(Conecction conexion) {
    	return UtilObjeto.esNulo(conexion);
        
    }
    public static <O> boolean esNulo(final O objeto) {
        return objeto == null;
    }

    public static <O> O obtenerValorDefectoSiValorOriginalEsNulo(final O valor, final O valorDefecto) {
        return esNulo(valor) ? valorDefecto : valor;
    }
}