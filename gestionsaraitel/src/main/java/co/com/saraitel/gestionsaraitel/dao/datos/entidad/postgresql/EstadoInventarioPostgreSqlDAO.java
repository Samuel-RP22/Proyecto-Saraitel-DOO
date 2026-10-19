
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EstadoInventarioDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.EstadoInventarioEntidad;

public class EstadoInventarioPostgreSqlDAO extends SqlDAO implements EstadoInventarioDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."EstadoInventario"
			("id", "Codigo", "Nombre")
			VALUES (?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "Codigo", "Nombre"
			FROM saraitel."EstadoInventario"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "Codigo", "Nombre"
			FROM saraitel."EstadoInventario"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "Codigo", "Nombre"
			FROM saraitel."EstadoInventario"
			""";

	public EstadoInventarioPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final EstadoInventarioEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear el estado del inventario",
				"Error NO CONTROLADO al crear el estado del inventario", entidad.getId(),
				entidad.getCodigo(), entidad.getNombre());
	}

	@Override
	public EstadoInventarioEntidad consultarPorId(final UUID id) {
		List<EstadoInventarioEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, "Error al consultar el estado del inventario",
				"Error NO CONTROLADO al consultar el estado del inventario");

		if (resultado.isEmpty()) {
			return new EstadoInventarioEntidad();
		} else {
			return resultado.get(0);
		}
	}

	@Override
	public List<EstadoInventarioEntidad> consultarPorFiltro(final EstadoInventarioEntidad filtro) {

		EstadoInventarioEntidad filtroSeguro = filtro == null ? new EstadoInventarioEntidad() : filtro;

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conTexto("\"Codigo\"", filtroSeguro.getCodigo()).conTexto("\"Nombre\"", filtroSeguro.getNombre());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar estados del inventario",
				"Error NO CONTROLADO al consultar estados del inventario");
	}

	@Override
	public List<EstadoInventarioEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear,
				"Error al consultar los estados del inventario",
				"Error NO CONTROLADO al consultar los estados del inventario");
	}

	private EstadoInventarioEntidad mapear(final ResultSet resultados) throws SQLException {

		EstadoInventarioEntidad entidad = new EstadoInventarioEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setCodigo(resultados.getString("Codigo"));
		entidad.setNombre(resultados.getString("Nombre"));

		return entidad;
	}
}
