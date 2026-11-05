package co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql;

public enum OperadorSql {

	IGUAL("="), MAYOR_O_IGUAL(">="), MENOR_O_IGUAL("<=");

	private final String simbolo;

	OperadorSql(final String simbolo) {
		this.simbolo = simbolo;
	}

	public String getSimbolo() {
		return simbolo;
	}
}