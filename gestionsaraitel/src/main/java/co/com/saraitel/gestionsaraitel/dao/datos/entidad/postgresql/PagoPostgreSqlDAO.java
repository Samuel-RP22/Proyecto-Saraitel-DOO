
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PagoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.CompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PagoEntidad;

public class PagoPostgreSqlDAO extends SqlDAO implements PagoDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."Pago"
			("id", "Compra_id", "MontoPagado", "FechaPago")
			VALUES (?, ?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "Compra_id", "MontoPagado", "FechaPago"
			FROM saraitel."Pago"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "Compra_id", "MontoPagado", "FechaPago"
			FROM saraitel."Pago"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "Compra_id", "MontoPagado", "FechaPago"
			FROM saraitel."Pago"
			""";

	public PagoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final PagoEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear el pago", entidad.getId().toString(),
				entidad.getCompra().getId().toString(), entidad.getMontoPagado(), entidad.getFechaPago());
	}

	@Override
	public PagoEntidad consultarPorId(final UUID id) {
		List<PagoEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id.toString()), this::mapear,
				"Error al consultar el pago");

		if (resultado.isEmpty()) {
			return new PagoEntidad();
		} else {
			return resultado.get(0);
		}
	}

	@Override
	public List<PagoEntidad> consultarPorFiltro(final PagoEntidad filtro) {

		PagoEntidad filtroSeguro = filtro == null ? new PagoEntidad() : filtro;

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Compra_id\"", filtroSeguro.getCompra().getId())
				.conDecimal("\"MontoPagado\"", filtroSeguro.getMontoPagado())
				.conFechaHora("\"FechaPago\"", filtroSeguro.getFechaPago());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar pagos");
	}

	@Override
	public List<PagoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear, "Error al consultar los pagos");
	}

	private PagoEntidad mapear(final ResultSet resultados) throws SQLException {

		PagoEntidad entidad = new PagoEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		CompraEntidad compra = new CompraEntidad();

		compra.setId(leerUUID(resultados, "Compra_id"));

		entidad.setCompra(compra);

		entidad.setMontoPagado(resultados.getBigDecimal("MontoPagado"));
		entidad.setFechaPago(resultados.getTimestamp("FechaPago").toLocalDateTime());

		return entidad;
	}
}
