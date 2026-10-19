
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PagoNormalDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.MetodoPagoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PagoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PagoNormalEntidad;

public class PagoNormalPostgreSqlDAO extends SqlDAO implements PagoNormalDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."PagoNormal"
			("id", "MetodoPago_id", "Pago_id", "MontoPagar")
			VALUES (?, ?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "MetodoPago_id", "Pago_id", "MontoPagar"
			FROM saraitel."PagoNormal"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "MetodoPago_id", "Pago_id", "MontoPagar"
			FROM saraitel."PagoNormal"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "MetodoPago_id", "Pago_id", "MontoPagar"
			FROM saraitel."PagoNormal"
			""";

	public PagoNormalPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final PagoNormalEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear el pago normal",
				"Error NO CONTROLADO al crear el pago normal", entidad.getId(),
				entidad.getMetodoPago().getId(), entidad.getPago().getId(),
				entidad.getMontoPagar());
	}

	@Override
	public PagoNormalEntidad consultarPorId(final UUID id) {
		List<PagoNormalEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, "Error al consultar el pago normal",
				"Error NO CONTROLADO al consultar el pago normal");

		if (resultado.isEmpty()) {
			return new PagoNormalEntidad();
		} else {
			return resultado.get(0);
		}
	}

	@Override
	public List<PagoNormalEntidad> consultarPorFiltro(final PagoNormalEntidad filtro) {

		PagoNormalEntidad filtroSeguro = filtro == null ? new PagoNormalEntidad() : filtro;

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"MetodoPago_id\"", filtroSeguro.getMetodoPago().getId())
				.conId("\"Pago_id\"", filtroSeguro.getPago().getId())
				.conDecimal("\"MontoPagar\"", filtroSeguro.getMontoPagar());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar pagos normales",
				"Error NO CONTROLADO al consultar pagos normales");
	}

	@Override
	public List<PagoNormalEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear,
				"Error al consultar los pagos normales",
				"Error NO CONTROLADO al consultar los pagos normales");
	}

	private PagoNormalEntidad mapear(final ResultSet resultados) throws SQLException {

		PagoNormalEntidad entidad = new PagoNormalEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		MetodoPagoEntidad metodoPago = new MetodoPagoEntidad();

		metodoPago.setId(leerUUID(resultados, "MetodoPago_id"));

		entidad.setMetodoPago(metodoPago);

		PagoEntidad pago = new PagoEntidad();

		pago.setId(leerUUID(resultados, "Pago_id"));

		entidad.setPago(pago);

		entidad.setMontoPagar(resultados.getBigDecimal("MontoPagar"));

		return entidad;
	}
}
