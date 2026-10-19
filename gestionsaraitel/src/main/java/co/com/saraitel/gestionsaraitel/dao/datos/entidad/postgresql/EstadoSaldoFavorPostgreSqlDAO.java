
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EstadoSaldoFavorDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.EstadoSaldoFavorEntidad;

public class EstadoSaldoFavorPostgreSqlDAO extends SqlDAO implements EstadoSaldoFavorDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."EstadoSaldoFavor"
			("id", "Codigo", "Nombre")
			VALUES (?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "Codigo", "Nombre"
			FROM saraitel."EstadoSaldoFavor"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "Codigo", "Nombre"
			FROM saraitel."EstadoSaldoFavor"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "Codigo", "Nombre"
			FROM saraitel."EstadoSaldoFavor"
			""";

	public EstadoSaldoFavorPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final EstadoSaldoFavorEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear el estado de saldo a favor",
				"Error NO CONTROLADO al crear el estado de saldo a favor", entidad.getId(),
				entidad.getCodigo(), entidad.getNombre());
	}

	@Override
	public EstadoSaldoFavorEntidad consultarPorId(final UUID id) {
		List<EstadoSaldoFavorEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, "Error al consultar el estado de saldo a favor",
				"Error NO CONTROLADO al consultar el estado de saldo a favor");

		if (resultado.isEmpty()) {
			return new EstadoSaldoFavorEntidad();
		} else {
			return resultado.get(0);
		}
	}

	@Override
	public List<EstadoSaldoFavorEntidad> consultarPorFiltro(final EstadoSaldoFavorEntidad filtro) {

		EstadoSaldoFavorEntidad filtroSeguro = filtro == null ? new EstadoSaldoFavorEntidad() : filtro;

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conTexto("\"Codigo\"", filtroSeguro.getCodigo()).conTexto("\"Nombre\"", filtroSeguro.getNombre());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar estados de saldo a favor",
				"Error NO CONTROLADO al consultar estados de saldo a favor");
	}

	@Override
	public List<EstadoSaldoFavorEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear,
				"Error al consultar los estados de saldo a favor",
				"Error NO CONTROLADO al consultar los estados de saldo a favor");
	}

	private EstadoSaldoFavorEntidad mapear(final ResultSet resultados) throws SQLException {

		EstadoSaldoFavorEntidad entidad = new EstadoSaldoFavorEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setCodigo(resultados.getString("Codigo"));
		entidad.setNombre(resultados.getString("Nombre"));

		return entidad;
	}
}
