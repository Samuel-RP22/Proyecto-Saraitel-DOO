package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public final class FiltroSql {

	private final StringBuilder sentencia;
	private final List<Object> parametros = new ArrayList<>();

	public FiltroSql(final String sentenciaBase) {
		if (UtilTexto.esVacia(sentenciaBase)) {
			throw new IllegalArgumentException("La sentencia SQL base no puede estar vacía");
		}

		sentencia = new StringBuilder(sentenciaBase).append(" WHERE 1=1");
	}

	private void agregar(final String columna, final Object valor) {
		if (UtilTexto.esVacia(columna)) {
			throw new IllegalArgumentException("La columna del filtro no puede estar vacía");
		}

		sentencia.append(" AND ").append(columna).append(" = ?");
		parametros.add(valor);
	}

	public FiltroSql conId(final String columna, final UUID valor) {
		if (!UtilUUID.obtenerUUIDDefecto().equals(valor)) {
			agregar(columna, valor.toString());
		}
		return this;
	}

	public FiltroSql conTexto(final String columna, final String valor) {
		if (!UtilTexto.esVacia(valor)) {
			agregar(columna, UtilTexto.quitarEspaciosEnBlanco(valor));
		}
		return this;
	}

	public FiltroSql conEntero(final String columna, final int valor) {
		if (valor != 0) {
			agregar(columna, valor);
		}
		return this;
	}

	public FiltroSql conBooleano(final String columna, final boolean valor, final boolean valorDefecto) {

		if (valor != valorDefecto) {
			agregar(columna, valor);
		}
		return this;
	}

	public FiltroSql conFechaHora(final String columna, final LocalDateTime valor) {

		if (!UtilFecha.FECHA_HORA_DEFECTO.equals(valor)) {
			agregar(columna, valor);
		}
		return this;
	}
	
	public FiltroSql conDecimal(final String columna, final BigDecimal valor) {
		if (valor != null && valor.compareTo(BigDecimal.ZERO) != 0) {
			agregar(columna, valor);
		}
		return this;
	}

	public String getSentencia() {
		return sentencia.toString();
	}

	public List<Object> getParametros() {
		return new ArrayList<>(parametros);
	}
}
