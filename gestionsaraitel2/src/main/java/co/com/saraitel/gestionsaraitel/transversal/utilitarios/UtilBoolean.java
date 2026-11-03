package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

public final class UtilBoolean {

	public static final Boolean FALSO = Boolean.FALSE;
	public static final Boolean TRUE = Boolean.TRUE;

	private UtilBoolean() {
	}

	public static Boolean obtenerValorDefecto(final Boolean valor, final Boolean valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
	}

	public static Boolean obtenerValorDefectoFalso(final Boolean valor) {
		return obtenerValorDefecto(valor, FALSO);
	}

	public static Boolean obtenerValorDefectoVerdadero(final Boolean valor) {
		return obtenerValorDefecto(valor, TRUE);
	}
}