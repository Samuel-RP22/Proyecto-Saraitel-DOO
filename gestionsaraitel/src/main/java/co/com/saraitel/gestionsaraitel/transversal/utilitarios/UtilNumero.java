package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

import java.math.BigDecimal;

public final class UtilNumero {
	
	public static final BigDecimal CERO_DECIMAL = BigDecimal.ZERO;
	
	private UtilNumero () {
	}
	
	public static <N extends Number> N obtenerValorDefecto(final N valor, final N valorDefecto){
		return UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(valor, valorDefecto);
	}
	
	public static BigDecimal obtenerValorDefecto(final BigDecimal valor){
		return obtenerValorDefecto(valor, CERO_DECIMAL);
	}
	
	public static boolean mayorQue(final int numeroUno, final int numeroDos) {
	    return numeroUno > numeroDos;
	}
	
	public static boolean menorQue(final int numeroUno, final int numeroDos) {
	    return numeroUno < numeroDos;
	}

	public static boolean mayorIgualQue(final int numeroUno, final int numeroDos) {
	    return numeroUno >= numeroDos;
	}

	public static boolean menorIgualQue(final int numeroUno, final int numeroDos) {
	    return numeroUno <= numeroDos;
	}

	public static boolean diferenteQue(final int numeroUno, final int numeroDos) {
	    return numeroUno != numeroDos;
	}
	
	public static boolean estaEntreXyY(final int numero, final int limiteInferior, final int limiteSuperior) {
	    return numero >= limiteInferior && numero <= limiteSuperior;
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

	public static boolean estaEntreXyY(final BigDecimal numero, final BigDecimal limiteInferior, final BigDecimal limiteSuperior) {
		var numeroSanitizado = obtenerValorDefecto(numero);
	    return numeroSanitizado.compareTo(obtenerValorDefecto(limiteInferior)) >= 0
	            && numeroSanitizado.compareTo(obtenerValorDefecto(limiteSuperior)) <= 0;
	}

}