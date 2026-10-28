package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

public final class UtilTexto {

	public static final String VACIA = "";
	public static final String SOLO_LETRAS_Y_ESPACIOS = "^[a-zA-Z ñÑáÁéÉíÍóÓúÚ]*$";
	public static final String SOLO_NUMEROS = "^[0-9]+$";
	public static final String FORMATO_CORREO = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	public static final String FORMATO_NIT = "^[0-9]{9,10}(-[0-9])?$";

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
		return quitarEspaciosBlanco ? obtenerLongitudCadena(quitarEspaciosEnBlanco(valor))
				: obtenerLongitudCadena(valor);
	}

	public static boolean longitudCadenaEsValida(final String valor, final int longitudInicial, final int longitudFinal,
			final boolean quitarEspaciosBlanco) {

		var valorSanitizado = quitarEspaciosBlanco ? quitarEspaciosEnBlanco(valor) : valor;
		var longitud = obtenerLongitudCadena(valorSanitizado);

		return longitud >= longitudInicial && longitud <= longitudFinal;
	}

	public static boolean formatoEsValido(String valor, String patron) {
		return obtenerValorDefecto(valor).matches(obtenerValorDefecto(patron));
	}

	public static String concatenar(final String... textos) {
		var resultado = new StringBuilder();

		if (!UtilObjeto.esNulo(textos)) {
			for (var texto : textos) {
				resultado.append(obtenerValorDefecto(texto));
			}
		}
		return resultado.toString();
	}
}
