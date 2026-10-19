
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SaldoFavorDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EstadoSaldoFavorEntidad;
import co.com.saraitel.gestionsaraitel.entidad.SaldoFavorEntidad;

public class SaldoFavorPostgreSqlDAO extends SqlDAO implements SaldoFavorDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."SaldoFavor"
			("id", "ClienteRegistrado_id", "EstadoSaldoFavor_id", "Monto", "FechaCreacion")
			VALUES (?, ?, ?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "ClienteRegistrado_id", "EstadoSaldoFavor_id", "Monto", "FechaCreacion"
			FROM saraitel."SaldoFavor"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "ClienteRegistrado_id", "EstadoSaldoFavor_id", "Monto", "FechaCreacion"
			FROM saraitel."SaldoFavor"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "ClienteRegistrado_id", "EstadoSaldoFavor_id", "Monto", "FechaCreacion"
			FROM saraitel."SaldoFavor"
			""";

	public SaldoFavorPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final SaldoFavorEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear el saldo a favor",
				entidad.getId().toString(), entidad.getClienteRegistrado().getId().toString(),
				entidad.getEstado().getId().toString(), entidad.getMonto(), entidad.getFechaCreacion());
	}

	@Override
	public SaldoFavorEntidad consultarPorId(final UUID id) {
		List<SaldoFavorEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id.toString()),
				this::mapear, "Error al consultar el saldo a favor");

		return resultado.isEmpty() ? new SaldoFavorEntidad() : resultado.get(0);
	}

	@Override
	public List<SaldoFavorEntidad> consultarPorFiltro(final SaldoFavorEntidad filtro) {

		SaldoFavorEntidad filtroSeguro = filtro == null ? new SaldoFavorEntidad() : filtro;

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO)
				.conId("\"id\"", filtroSeguro.getId())
				.conId("\"ClienteRegistrado_id\"", filtroSeguro.getClienteRegistrado().getId())
				.conId("\"EstadoSaldoFavor_id\"", filtroSeguro.getEstado().getId())
				.conDecimal("\"Monto\"", filtroSeguro.getMonto())
				.conFechaHora("\"FechaCreacion\"", filtroSeguro.getFechaCreacion());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar saldos a favor");
	}

	@Override
	public List<SaldoFavorEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear, "Error al consultar saldos a favor");
	}

	private SaldoFavorEntidad mapear(final ResultSet resultados) throws SQLException {

		SaldoFavorEntidad entidad = new SaldoFavorEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		ClienteRegistradoEntidad clienteRegistrado = new ClienteRegistradoEntidad();
		clienteRegistrado.setId(leerUUID(resultados, "ClienteRegistrado_id"));
		entidad.setClienteRegistrado(clienteRegistrado);

		EstadoSaldoFavorEntidad estado = new EstadoSaldoFavorEntidad();
		estado.setId(leerUUID(resultados, "EstadoSaldoFavor_id"));
		entidad.setEstado(estado);

		entidad.setMonto(resultados.getBigDecimal("Monto"));
		entidad.setFechaCreacion(resultados.getTimestamp("FechaCreacion").toLocalDateTime());

		return entidad;
	}
}
