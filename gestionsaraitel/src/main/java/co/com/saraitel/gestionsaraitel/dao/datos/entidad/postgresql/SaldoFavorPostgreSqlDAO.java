
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SaldoFavorDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.DevolucionEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EstadoSaldoFavorEntidad;
import co.com.saraitel.gestionsaraitel.entidad.SaldoFavorEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class SaldoFavorPostgreSqlDAO extends SqlDAO implements SaldoFavorDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."SaldoFavor"
			("id", "Devolucion_id", "EstadoSaldoFavor_id", "MontoUsado")
			VALUES (?, ?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "Devolucion_id", "EstadoSaldoFavor_id", "MontoUsado"
			FROM saraitel."SaldoFavor"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "Devolucion_id", "EstadoSaldoFavor_id", "MontoUsado"
			FROM saraitel."SaldoFavor"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "Devolucion_id", "EstadoSaldoFavor_id", "MontoUsado"
			FROM saraitel."SaldoFavor"
			""";

	public SaldoFavorPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final SaldoFavorEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear el saldo a favor",
				"Error NO CONTROLADO al crear el saldo a favor", entidad.getId(),
				entidad.getDevolucion().getId(), entidad.getEstado().getId(),
				entidad.getMontoUsado());
	}

	@Override
	public SaldoFavorEntidad consultarPorId(final UUID id) {
		List<SaldoFavorEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, "Error al consultar el saldo a favor",
				"Error NO CONTROLADO al consultar el saldo a favor");

		if (resultado.isEmpty()) {
			return new SaldoFavorEntidad();
		} else {
			return resultado.get(0);
		}
	}

	@Override
	public List<SaldoFavorEntidad> consultarPorFiltro(final SaldoFavorEntidad filtro) {

		SaldoFavorEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new SaldoFavorEntidad());

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Devolucion_id\"", filtroSeguro.getDevolucion().getId())
				.conId("\"EstadoSaldoFavor_id\"", filtroSeguro.getEstado().getId())
				.conDecimal("\"MontoUsado\"", filtroSeguro.getMontoUsado());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar saldos a favor",
				"Error NO CONTROLADO al consultar saldos a favor");
	}

	@Override
	public List<SaldoFavorEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear,
				"Error al consultar los saldos a favor",
				"Error NO CONTROLADO al consultar los saldos a favor");
	}

	private SaldoFavorEntidad mapear(final ResultSet resultados) throws SQLException {

		SaldoFavorEntidad entidad = new SaldoFavorEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		DevolucionEntidad devolucion = new DevolucionEntidad();

		devolucion.setId(leerUUID(resultados, "Devolucion_id"));

		entidad.setDevolucion(devolucion);

		EstadoSaldoFavorEntidad estado = new EstadoSaldoFavorEntidad();

		estado.setId(leerUUID(resultados, "EstadoSaldoFavor_id"));

		entidad.setEstado(estado);

		entidad.setMontoUsado(resultados.getBigDecimal("MontoUsado"));

		return entidad;
	}
}
