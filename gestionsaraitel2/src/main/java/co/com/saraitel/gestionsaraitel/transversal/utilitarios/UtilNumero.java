package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

import java.math.BigDecimal;

public final class UtilNumero {

	public static final BigDecimal CERO_DECIMAL = BigDecimal.ZERO;
	public static final Integer CERO_INTEGER = 0;

	private UtilNumero() {
	}

	public static <N extends Number> N obtenerValorDefecto(final N valor, final N valorDefecto) {
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
	}

	public static BigDecimal obtenerValorDefecto(final BigDecimal valor) {
		return obtenerValorDefecto(valor, CERO_DECIMAL);
	}

	public static Integer obtenerValorDefecto(final Integer valor) {
		return obtenerValorDefecto(valor, CERO_INTEGER);
	}

	public static boolean mayorQue(final Integer numeroUno, final Integer numeroDos) {
		return obtenerValorDefecto(numeroUno).compareTo(obtenerValorDefecto(numeroDos)) > 0;
	}

	public static boolean menorQue(final Integer numeroUno, final Integer numeroDos) {
		return obtenerValorDefecto(numeroUno).compareTo(obtenerValorDefecto(numeroDos)) < 0;
	}

	public static boolean mayorIgualQue(final Integer numeroUno, final Integer numeroDos) {
		return obtenerValorDefecto(numeroUno).compareTo(obtenerValorDefecto(numeroDos)) >= 0;
	}

	public static boolean menorIgualQue(final Integer numeroUno, final Integer numeroDos) {
		return obtenerValorDefecto(numeroUno).compareTo(obtenerValorDefecto(numeroDos)) <= 0;
	}

	public static boolean diferenteQue(final Integer numeroUno, final Integer numeroDos) {
		return obtenerValorDefecto(numeroUno).compareTo(obtenerValorDefecto(numeroDos)) != 0;
	}

	public static boolean estaEntreXyY(final Integer numero, final Integer limiteInferior,
			final Integer limiteSuperior) {
		return mayorIgualQue(numero, limiteInferior) && menorIgualQue(numero, limiteSuperior);
	}

	public static boolean mayorQue(final BigDecimal numeroUno, final BigDecimal numeroDos) {
		return obtenerValorDefecto(numeroUno).compareTo(obtenerValorDefecto(numeroDos)) > 0;
	}

	public static boolean menorQue(final BigDecimal numeroUno, final BigDecimal numeroDos) {
		return obtenerValorDefecto(numeroUno).compareTo(obtenerValorDefecto(numeroDos)) < 0;
	}

	public static boolean mayorIgualQue(final BigDecimal numeroUno, final BigDecimal numeroDos) {
		return obtenerValorDefecto(numeroUno).compareTo(obtenerValorDefecto(numeroDos)) >= 0;
	}

	public static boolean menorIgualQue(final BigDecimal numeroUno, final BigDecimal numeroDos) {
		return obtenerValorDefecto(numeroUno).compareTo(obtenerValorDefecto(numeroDos)) <= 0;
	}

	public static boolean diferenteQue(final BigDecimal numeroUno, final BigDecimal numeroDos) {
		return obtenerValorDefecto(numeroUno).compareTo(obtenerValorDefecto(numeroDos)) != 0;
	}

	public static boolean estaEntreXyY(final BigDecimal numero, final BigDecimal limiteInferior,
			final BigDecimal limiteSuperior) {
		return mayorIgualQue(numero, limiteInferior) && menorIgualQue(numero, limiteSuperior);
	}
}
