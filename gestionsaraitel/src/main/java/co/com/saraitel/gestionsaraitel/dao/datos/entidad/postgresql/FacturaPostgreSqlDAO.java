
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FacturaDAO;
import co.com.saraitel.gestionsaraitel.entidad.CompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.FacturaEntidad;

public class FacturaPostgreSqlDAO extends SqlDAO implements FacturaDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."Factura"
			("id", "Compra_id", "FechaEmision")
			VALUES (?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "Compra_id", "FechaEmision"
			FROM saraitel."Factura"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "Compra_id", "FechaEmision"
			FROM saraitel."Factura"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "Compra_id", "FechaEmision"
			FROM saraitel."Factura"
			""";

	public FacturaPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final FacturaEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear la factura", entidad.getId().toString(),
				entidad.getCompra().getId().toString(), entidad.getFechaEmision());
	}

	@Override
	public FacturaEntidad consultarPorId(final UUID id) {
		List<FacturaEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id.toString()), this::mapear,
				"Error al consultar la factura");

		if (resultado.isEmpty()) {
			return new FacturaEntidad();
		} else {
			return resultado.get(0);
		}
	}

	@Override
	public List<FacturaEntidad> consultarPorFiltro(final FacturaEntidad filtro) {
		FacturaEntidad filtroSeguro;

		if (filtro == null) {
			filtroSeguro = new FacturaEntidad();
		} else {
			filtroSeguro = filtro;
		}

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Compra_id\"", filtroSeguro.getCompra().getId())
				.conFechaHora("\"FechaEmision\"", filtroSeguro.getFechaEmision());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar facturas");
	}

	@Override
	public List<FacturaEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear, "Error al consultar facturas");
	}

	private FacturaEntidad mapear(final ResultSet resultados) throws SQLException {
		CompraEntidad compra = new CompraEntidad();
		compra.setId(leerUUID(resultados, "Compra_id"));

		return new FacturaEntidad(leerUUID(resultados, "id"), compra,
				resultados.getTimestamp("FechaEmision").toLocalDateTime());
	}
}
