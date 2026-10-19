
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.CompraDAO;
import co.com.saraitel.gestionsaraitel.entidad.CompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EstadoCompraEntidad;

public class CompraPostgreSqlDAO extends SqlDAO implements CompraDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."Compra"
			("id", "ProcesoCompra_id", "EstadoCompra_id", "FechaCompra")
			VALUES (?, ?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "ProcesoCompra_id", "EstadoCompra_id", "FechaCompra"
			FROM saraitel."Compra"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "ProcesoCompra_id", "EstadoCompra_id", "FechaCompra"
			FROM saraitel."Compra"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "ProcesoCompra_id", "EstadoCompra_id", "FechaCompra"
			FROM saraitel."Compra"
			""";

	public CompraPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final CompraEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear la compra", entidad.getId().toString(),
				entidad.getProcesoCompra().getId().toString(), entidad.getEstado().getId().toString(),
				entidad.getFechaCompra());
	}

	@Override
	public CompraEntidad consultarPorId(final UUID id) {
		List<CompraEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id.toString()), this::mapear,
				"Error al consultar la compra");

		if (resultado.isEmpty()) {
			return new CompraEntidad();
		} else {
			return resultado.get(0);
		}
	}

	@Override
	public List<CompraEntidad> consultarPorFiltro(final CompraEntidad filtro) {
		CompraEntidad filtroSeguro;

		if (filtro == null) {
			filtroSeguro = new CompraEntidad();
		} else {
			filtroSeguro = filtro;
		}

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"ProcesoCompra_id\"", filtroSeguro.getProcesoCompra().getId())
				.conId("\"EstadoCompra_id\"", filtroSeguro.getEstado().getId())
				.conFechaHora("\"FechaCompra\"", filtroSeguro.getFechaCompra());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar compras");
	}

	@Override
	public List<CompraEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear, "Error al consultar compras");
	}

	private CompraEntidad mapear(final ResultSet resultados) throws SQLException {
		ProcesoCompraEntidad procesoCompra = new ProcesoCompraEntidad();
		procesoCompra.setId(leerUUID(resultados, "ProcesoCompra_id"));

		EstadoCompraEntidad estado = new EstadoCompraEntidad();
		estado.setId(leerUUID(resultados, "EstadoCompra_id"));

		return new CompraEntidad(leerUUID(resultados, "id"), procesoCompra, estado,
				resultados.getTimestamp("FechaCompra").toLocalDateTime());
	}
}
