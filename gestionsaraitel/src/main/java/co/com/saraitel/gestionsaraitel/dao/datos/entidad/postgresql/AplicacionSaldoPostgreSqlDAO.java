
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.AplicacionSaldoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.AplicacionSaldoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.CompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.SaldoFavorEntidad;

public class AplicacionSaldoPostgreSqlDAO extends SqlDAO implements AplicacionSaldoDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."AplicacionSaldo"
			("id", "SaldoFavor_id", "Compra_id", "MontoAplicado", "FechaAplicacion")
			VALUES (?, ?, ?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "SaldoFavor_id", "Compra_id", "MontoAplicado", "FechaAplicacion"
			FROM saraitel."AplicacionSaldo"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "SaldoFavor_id", "Compra_id", "MontoAplicado", "FechaAplicacion"
			FROM saraitel."AplicacionSaldo"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "SaldoFavor_id", "Compra_id", "MontoAplicado", "FechaAplicacion"
			FROM saraitel."AplicacionSaldo"
			""";

	public AplicacionSaldoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final AplicacionSaldoEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear la aplicación de saldo",
				entidad.getId().toString(), entidad.getSaldoFavor().getId().toString(),
				entidad.getCompra().getId().toString(), entidad.getMontoAplicado(),
				entidad.getFechaAplicacion());
	}

	@Override
	public AplicacionSaldoEntidad consultarPorId(final UUID id) {
		List<AplicacionSaldoEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id.toString()),
				this::mapear, "Error al consultar la aplicación de saldo");

		return resultado.isEmpty() ? new AplicacionSaldoEntidad() : resultado.get(0);
	}

	@Override
	public List<AplicacionSaldoEntidad> consultarPorFiltro(final AplicacionSaldoEntidad filtro) {

		AplicacionSaldoEntidad filtroSeguro = filtro == null ? new AplicacionSaldoEntidad() : filtro;

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO)
				.conId("\"id\"", filtroSeguro.getId())
				.conId("\"SaldoFavor_id\"", filtroSeguro.getSaldoFavor().getId())
				.conId("\"Compra_id\"", filtroSeguro.getCompra().getId())
				.conDecimal("\"MontoAplicado\"", filtroSeguro.getMontoAplicado())
				.conFechaHora("\"FechaAplicacion\"", filtroSeguro.getFechaAplicacion());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar aplicaciones de saldo");
	}

	@Override
	public List<AplicacionSaldoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear, "Error al consultar aplicaciones de saldo");
	}

	private AplicacionSaldoEntidad mapear(final ResultSet resultados) throws SQLException {

		AplicacionSaldoEntidad entidad = new AplicacionSaldoEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		SaldoFavorEntidad saldoFavor = new SaldoFavorEntidad();
		saldoFavor.setId(leerUUID(resultados, "SaldoFavor_id"));
		entidad.setSaldoFavor(saldoFavor);

		CompraEntidad compra = new CompraEntidad();
		compra.setId(leerUUID(resultados, "Compra_id"));
		entidad.setCompra(compra);

		entidad.setMontoAplicado(resultados.getBigDecimal("MontoAplicado"));
		entidad.setFechaAplicacion(resultados.getTimestamp("FechaAplicacion").toLocalDateTime());

		return entidad;
	}
}
