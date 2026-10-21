package co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql;

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
		sentencia = new StringBuilder(sentenciaBase).append(" WHERE 1=1");
		//QUITAR WHERE 1=1
	}

	private void agregarCondicion(final String columna, final String operador, final Object valor) {
		sentencia.append(" AND ").append(columna).append(' ').append(operador).append(" ?");
		parametros.add(valor);
	}

	private void agregar(final String columna, final Object valor) {
		agregarCondicion(columna, "=", valor);
	}

	public FiltroSql conId(final String columna, final UUID valor) {
		if (valor != null && !UtilUUID.obtenerUUIDDefecto().equals(valor)) {
			agregar(columna, valor);
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
		if (valor != null && !UtilFecha.FECHA_HORA_DEFECTO.equals(valor)) {
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

	public FiltroSql conEnteroDesde(final String columna, final int desde) {
		agregarCondicion(columna, ">=", desde);
		return this;
	}

	public FiltroSql conEnteroHasta(final String columna, final int hasta) {
		agregarCondicion(columna, "<=", hasta);
		return this;
	}

	public FiltroSql conEnteroEntre(final String columna, final int desde, final int hasta) {
		if (desde > hasta) {
			throw new IllegalArgumentException("El límite inferior no puede ser mayor al superior en " + columna);
		}
		agregarCondicion(columna, ">=", desde);
		agregarCondicion(columna, "<=", hasta);
		return this;
	}

	public FiltroSql conDecimalDesde(final String columna, final BigDecimal desde) {
		if (desde != null) {
			agregarCondicion(columna, ">=", desde);
		}
		return this;
	}

	public FiltroSql conDecimalHasta(final String columna, final BigDecimal hasta) {
		if (hasta != null) {
			agregarCondicion(columna, "<=", hasta);
		}
		return this;
	}

	public FiltroSql conDecimalEntre(final String columna, final BigDecimal desde, final BigDecimal hasta) {
		if (desde != null && hasta != null && desde.compareTo(hasta) > 0) {
			throw new IllegalArgumentException("El límite inferior no puede ser mayor al superior en " + columna);
		}
		return conDecimalDesde(columna, desde).conDecimalHasta(columna, hasta);
	}

	public FiltroSql conFechaHoraDesde(final String columna, final LocalDateTime desde) {
		if (desde != null) {
			agregarCondicion(columna, ">=", desde);
		}
		return this;
	}

	public FiltroSql conFechaHoraHasta(final String columna, final LocalDateTime hasta) {
		if (hasta != null) {
			agregarCondicion(columna, "<=", hasta);
		}
		return this;
	}

	public FiltroSql conFechaHoraEntre(final String columna, final LocalDateTime desde, final LocalDateTime hasta) {
		if (desde != null && hasta != null && desde.isAfter(hasta)) {
			throw new IllegalArgumentException("La fecha inicial no puede ser posterior a la final en " + columna);
		}
		return conFechaHoraDesde(columna, desde).conFechaHoraHasta(columna, hasta);
	}

	public String getSentencia() {
		return sentencia.toString();
	}

	public List<Object> getParametros() {
		return List.copyOf(parametros);
	}
}