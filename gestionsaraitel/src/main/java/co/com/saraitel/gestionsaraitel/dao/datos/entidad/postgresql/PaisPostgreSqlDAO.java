package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PaisDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.PaisEntidad;

public class PaisPostgreSqlDAO extends SqlDAO implements PaisDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."Pais"
			("id", "Nombre")
			VALUES (?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "Nombre"
			FROM saraitel."Pais"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "Nombre"
			FROM saraitel."Pais"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "Nombre"
			FROM saraitel."Pais"
			""";

	private static final String SQL_ACTUALIZAR = """
			UPDATE saraitel."Pais"
			SET "Nombre" = ?
			WHERE "id" = ?
			""";

	private static final String SQL_ELIMINAR = """
			DELETE FROM saraitel."Pais"
			WHERE "id" = ?
			""";

	public PaisPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final PaisEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear el país", entidad.getId().toString(),
				entidad.getNombre());
	}

	@Override
	public PaisEntidad consultarPorId(final UUID id) {
		List<PaisEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id.toString()), this::mapear,
				"Error al consultar el país");

		if (resultado.isEmpty()) {
			return new PaisEntidad();
		} else {
			return resultado.get(0);
		}
	}

	@Override
	public List<PaisEntidad> consultarPorFiltro(final PaisEntidad filtro) {

		PaisEntidad filtroSeguro = filtro == null ? new PaisEntidad() : filtro;

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conTexto("\"Nombre\"", filtroSeguro.getNombre());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar países");
	}

	@Override
	public List<PaisEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear, "Error al consultar los países");
	}

	@Override
	public void actualizar(final UUID id, final PaisEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, "Error al actualizar el país", entidad.getNombre(), id.toString());
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, "Error al eliminar el país", id.toString());
	}

	private PaisEntidad mapear(final ResultSet resultados) throws SQLException {

		PaisEntidad entidad = new PaisEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("Nombre"));

		return entidad;
	}
}
