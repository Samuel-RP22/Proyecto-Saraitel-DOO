
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PagoNormalDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.MetodoPagoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PagoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PagoNormalEntidad;

public class PagoNormalPostgreSqlDAO extends SqlDAO implements PagoNormalDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."PagoNormal"
			("id", "Pago_id", "MetodoPago_id")
			VALUES (?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "Pago_id", "MetodoPago_id"
			FROM saraitel."PagoNormal"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "Pago_id", "MetodoPago_id"
			FROM saraitel."PagoNormal"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "Pago_id", "MetodoPago_id"
			FROM saraitel."PagoNormal"
			""";

	public PagoNormalPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final PagoNormalEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear el pago normal",
				entidad.getId().toString(), entidad.getPago().getId().toString(),
				entidad.getMetodoPago().getId().toString());
	}

	@Override
	public PagoNormalEntidad consultarPorId(final UUID id) {
		List<PagoNormalEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id.toString()),
				this::mapear, "Error al consultar el pago normal");

		return resultado.isEmpty() ? new PagoNormalEntidad() : resultado.get(0);
	}

	@Override
	public List<PagoNormalEntidad> consultarPorFiltro(final PagoNormalEntidad filtro) {

		PagoNormalEntidad filtroSeguro = filtro == null ? new PagoNormalEntidad() : filtro;

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO)
				.conId("\"id\"", filtroSeguro.getId())
				.conId("\"Pago_id\"", filtroSeguro.getPago().getId())
				.conId("\"MetodoPago_id\"", filtroSeguro.getMetodoPago().getId());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar pagos normales");
	}

	@Override
	public List<PagoNormalEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear, "Error al consultar pagos normales");
	}

	private PagoNormalEntidad mapear(final ResultSet resultados) throws SQLException {

		PagoNormalEntidad entidad = new PagoNormalEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		PagoEntidad pago = new PagoEntidad();
		pago.setId(leerUUID(resultados, "Pago_id"));
		entidad.setPago(pago);

		MetodoPagoEntidad metodoPago = new MetodoPagoEntidad();
		metodoPago.setId(leerUUID(resultados, "MetodoPago_id"));
		entidad.setMetodoPago(metodoPago);


		return entidad;
	}
}
