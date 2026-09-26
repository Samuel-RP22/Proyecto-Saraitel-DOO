package co.edu.uco.libreriauco.transversal.utilitarios;

public final class UtilTexto {

    private static UtilTexto INSTANCIA;
    public static final String VACIA = "";

    private UtilTexto() {
    }

    public static UtilTexto getUtilTexto() {
        if (UtilObjeto.esNulo(INSTANCIA)) {
            synchronized (UtilTexto.class) {
                if (UtilObjeto.esNulo(INSTANCIA)) {
                    INSTANCIA = new UtilTexto();
                }
            }
        }
        return INSTANCIA;
    }

    public boolean esNula(final String cadena) {
        return UtilObjeto.esNulo(cadena);
    }

    public boolean esVacia(final String cadena) {
        return VACIA.equals(quitarEspaciosEnBlanco(cadena));
    }

    public String obtenerValorDefecto(final String valor, final String valorDefecto) {
        return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
    }

    public String obtenerValorDefecto(final String valor) {
        return obtenerValorDefecto(valor, VACIA);
    }

    public String quitarEspaciosEnBlanco(final String valor) {
        return obtenerValorDefecto(valor).trim();
    }

    public int obtenerLongitudCadena(final String valor) {
        return obtenerValorDefecto(valor).length();
    }

    public int obtenerLongitudCadena(final String valor, final boolean quitarEspaciosBlanco) {
        return quitarEspaciosBlanco 
                ? obtenerLongitudCadena(quitarEspaciosEnBlanco(valor)) 
                : obtenerLongitudCadena(valor);
    }

    public boolean longitudCadenaEsValida(final String valor, final int longitudInicial, 
            final int longitudFinal, final boolean quitarEspaciosBlanco) {
        
        var valorSanitizado = quitarEspaciosBlanco ? quitarEspaciosEnBlanco(valor) : valor;
        var longitud = obtenerLongitudCadena(valorSanitizado);
        
        return longitud >= longitudInicial && longitud <= longitudFinal;
    }
}