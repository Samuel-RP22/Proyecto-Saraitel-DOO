
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ProcesoCompraDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EstadoProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;

public class ProcesoCompraPostgreSqlDAO extends SqlDAO implements ProcesoCompraDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."ProcesoCompra"
			("id", "Cliente_id", "Empleado_id", "EstadoProcesoCompra_id",
			 "FechaInicio", "FechaActualizacion", "TotalCompra")
			VALUES (?, ?, ?, ?, ?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "Cliente_id", "Empleado_id", "EstadoProcesoCompra_id",
			       "FechaInicio", "FechaActualizacion", "TotalCompra"
			FROM saraitel."ProcesoCompra"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "Cliente_id", "Empleado_id", "EstadoProcesoCompra_id",
			       "FechaInicio", "FechaActualizacion", "TotalCompra"
			FROM saraitel."ProcesoCompra"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "Cliente_id", "Empleado_id", "EstadoProcesoCompra_id",
			       "FechaInicio", "FechaActualizacion", "TotalCompra"
			FROM saraitel."ProcesoCompra"
			""";

	public ProcesoCompraPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ProcesoCompraEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear el proceso de compra", entidad.getId().toString(),
				entidad.getCliente().getId().toString(), entidad.getEmpleado().getId().toString(),
				entidad.getEstado().getId().toString(), entidad.getFechaInicio(), entidad.getFechaActualizacion(),
				entidad.getTotal());
	}

	@Override
	public ProcesoCompraEntidad consultarPorId(final UUID id) {
		List<ProcesoCompraEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id.toString()),
				this::mapear, "Error al consultar el proceso de compra");

		if (resultado.isEmpty()) {
			return new ProcesoCompraEntidad();
		} else {
			return resultado.get(0);
		}
	}

	@Override
	public List<ProcesoCompraEntidad> consultarPorFiltro(final ProcesoCompraEntidad filtro) {
		ProcesoCompraEntidad filtroSeguro;

		if (filtro == null) {
			filtroSeguro = new ProcesoCompraEntidad();
		} else {
			filtroSeguro = filtro;
		}

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Cliente_id\"", filtroSeguro.getCliente().getId())
				.conId("\"Empleado_id\"", filtroSeguro.getEmpleado().getId())
				.conId("\"EstadoProcesoCompra_id\"", filtroSeguro.getEstado().getId())
				.conFechaHora("\"FechaInicio\"", filtroSeguro.getFechaInicio())
				.conFechaHora("\"FechaActualizacion\"", filtroSeguro.getFechaActualizacion());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar procesos de compra");
	}

	@Override
	public List<ProcesoCompraEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear, "Error al consultar procesos de compra");
	}

	private ProcesoCompraEntidad mapear(final ResultSet resultados) throws SQLException {
		ClienteEntidad cliente = new ClienteEntidad();
		cliente.setId(leerUUID(resultados, "Cliente_id"));

		EmpleadoEntidad empleado = new EmpleadoEntidad();
		empleado.setId(leerUUID(resultados, "Empleado_id"));

		EstadoProcesoCompraEntidad estado = new EstadoProcesoCompraEntidad();
		estado.setId(leerUUID(resultados, "EstadoProcesoCompra_id"));

		return new ProcesoCompraEntidad(leerUUID(resultados, "id"), cliente, empleado, estado,
				resultados.getTimestamp("FechaInicio").toLocalDateTime(),
				resultados.getTimestamp("FechaActualizacion").toLocalDateTime(),
				resultados.getBigDecimal("TotalCompra"));
	}
}
