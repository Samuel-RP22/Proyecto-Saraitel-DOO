package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.MotivoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.MotivoEntidad;

public class MotivoPostgreSqlDAO extends SqlDAO implements MotivoDAO {

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "Nombre"
			FROM saraitel."Motivo"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "Nombre"
			FROM saraitel."Motivo"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "Nombre"
			FROM saraitel."Motivo"
			""";

	public MotivoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public MotivoEntidad consultarPorId(final UUID id) {
		List<MotivoEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id), this::mapear,
				"Error al consultar el motivo",
				"Error NO CONTROLADO al consultar el motivo");

		if (resultado.isEmpty()) {
			return new MotivoEntidad();
		} else {
			return resultado.get(0);
		}
	}

	@Override
	public List<MotivoEntidad> consultarPorFiltro(final MotivoEntidad filtro) {
		MotivoEntidad filtroSeguro;

		if (filtro == null) {
			filtroSeguro = new MotivoEntidad();
		} else {
			filtroSeguro = filtro;
		}

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conTexto("\"Nombre\"", filtroSeguro.getNombre());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar motivos",
				"Error NO CONTROLADO al consultar motivos");
	}

	@Override
	public List<MotivoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear, "Error al consultar motivos",
				"Error NO CONTROLADO al consultar motivos");
	}

	private MotivoEntidad mapear(final ResultSet resultados) throws SQLException {
		return new MotivoEntidad(leerUUID(resultados, "id"), resultados.getString("Nombre"));
	}
}