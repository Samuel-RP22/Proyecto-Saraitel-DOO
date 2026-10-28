package co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public final class FiltroSql {

	private final String sentenciaBase;
	private final List<String> condiciones = new ArrayList<>();
	private final List<Object> parametros = new ArrayList<>();

	public FiltroSql(final String sentenciaBase) {
		this.sentenciaBase = sentenciaBase;
	}

	private void agregarCondicion(final String columna, final String operador, final Object valor) {
		condiciones.add(columna + " " + operador + " ?");
		parametros.add(valor);
	}

	private void agregar(final String columna, final Object valor) {
		agregarCondicion(columna, "=", valor);
	}

	public FiltroSql conId(final String columna, final UUID valor) {
		if (!UtilUUID.esValorDefecto(valor)) {
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
		if (UtilNumero.diferenteQue(valor, 0)) {
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
		if (!UtilObjeto.esNulo(valor) && !UtilFecha.FECHA_HORA_DEFECTO.equals(valor)) {
			agregar(columna, valor);
		}
		return this;
	}

	public FiltroSql conDecimal(final String columna, final BigDecimal valor) {
		if (!UtilObjeto.esNulo(valor) && UtilNumero.diferenteQue(valor, UtilNumero.CERO_DECIMAL)) {
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
			throw new IllegalArgumentException(UtilTexto
					.concatenar(CatalogoMensajes.FiltroSql.TECNICO_ERROR_LIMITE_INFERIOR_MAYOR_QUE_SUPERIOR, columna));
		}
		agregarCondicion(columna, ">=", desde);
		agregarCondicion(columna, "<=", hasta);
		return this;
	}

	public FiltroSql conDecimalDesde(final String columna, final BigDecimal desde) {
		if (!UtilObjeto.esNulo(desde)) {
			agregarCondicion(columna, ">=", desde);
		}
		return this;
	}

	public FiltroSql conDecimalHasta(final String columna, final BigDecimal hasta) {
		if (!UtilObjeto.esNulo(hasta)) {
			agregarCondicion(columna, "<=", hasta);
		}
		return this;
	}

	public FiltroSql conDecimalEntre(final String columna, final BigDecimal desde, final BigDecimal hasta) {
		if (!UtilObjeto.esNulo(desde) && !UtilObjeto.esNulo(hasta) && UtilNumero.mayorQue(desde, hasta)) {
			throw new IllegalArgumentException(UtilTexto
					.concatenar(CatalogoMensajes.FiltroSql.TECNICO_ERROR_LIMITE_INFERIOR_MAYOR_QUE_SUPERIOR, columna));
		}
		return conDecimalDesde(columna, desde).conDecimalHasta(columna, hasta);
	}

	public FiltroSql conFechaHoraDesde(final String columna, final LocalDateTime desde) {
		if (!UtilObjeto.esNulo(desde)) {
			agregarCondicion(columna, ">=", desde);
		}
		return this;
	}

	public FiltroSql conFechaHoraHasta(final String columna, final LocalDateTime hasta) {
		if (!UtilObjeto.esNulo(hasta)) {
			agregarCondicion(columna, "<=", hasta);
		}
		return this;
	}

	public FiltroSql conFechaHoraEntre(final String columna, final LocalDateTime desde, final LocalDateTime hasta) {
		if (!UtilObjeto.esNulo(desde) && !UtilObjeto.esNulo(hasta) && UtilFecha.esPosterior(desde, hasta)) {
			throw new IllegalArgumentException(UtilTexto
					.concatenar(CatalogoMensajes.FiltroSql.TECNICO_ERROR_FECHA_INICIAL_POSTERIOR_A_FINAL, columna));
		}
		return conFechaHoraDesde(columna, desde).conFechaHoraHasta(columna, hasta);
	}

	public FiltroSql conTextoIgnorandoMayusculas(final String columna, final String valor) {
		if (!UtilTexto.esVacia(valor)) {
			agregar(UtilTexto.concatenar("LOWER(", columna, ")"),
					UtilTexto.quitarEspaciosEnBlanco(valor).toLowerCase(Locale.ROOT));
		}
		return this;
	}

	public String getSentencia() {
		if (condiciones.isEmpty()) {
			return sentenciaBase;
		}
		return sentenciaBase + " WHERE " + String.join(" AND ", condiciones);
	}

	public List<Object> getParametros() {
		return List.copyOf(parametros);
	}
}