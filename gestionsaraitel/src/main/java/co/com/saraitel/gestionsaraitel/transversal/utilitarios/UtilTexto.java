package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class UtilTexto {
	
	public static final String VACIA = "";
    private static final DecimalFormatSymbols SIMBOLOS = new DecimalFormatSymbols(Locale.forLanguageTag("es-CO"));
    private static final String FORMATO_DINERO = "$ #,##0.00";

    private UtilTexto() {
    }

    public static boolean esVacia(final String cadena) {
        return VACIA.equals(quitarEspaciosEnBlanco(cadena));
    }

    public static String obtenerValorDefecto(final String valor, final String valorDefecto) {
        return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
    }

    public static String obtenerValorDefecto(final String valor) {
        return obtenerValorDefecto(valor, VACIA);
    }

    public static String quitarEspaciosEnBlanco(final String valor) {
        return obtenerValorDefecto(valor).strip();
    }

    public static int obtenerLongitudCadena(final String valor) {
        return obtenerValorDefecto(valor).length();
    }

    public static int obtenerLongitudCadena(final String valor, final boolean quitarEspaciosBlanco) {
        return quitarEspaciosBlanco 
                ? obtenerLongitudCadena(quitarEspaciosEnBlanco(valor)) 
                : obtenerLongitudCadena(valor);
    }

    public static boolean longitudCadenaEsValida(final String valor, final int longitudInicial, 
            final int longitudFinal, final boolean quitarEspaciosBlanco) {
        
        var valorSanitizado = quitarEspaciosBlanco ? quitarEspaciosEnBlanco(valor) : valor;
        var longitud = obtenerLongitudCadena(valorSanitizado);
        
        return longitud >= longitudInicial && longitud <= longitudFinal;
    }
    
    public static String formatearDinero(final BigDecimal valor) {
        var formato = new DecimalFormat(FORMATO_DINERO, SIMBOLOS);
        return formato.format(UtilNumero.obtenerValorDefecto(valor));
    }

    public static String formatearPorcentaje(final int valor) {
        return valor + "%";
    }
}
