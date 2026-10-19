
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DevolucionDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.DetalleCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.DevolucionEntidad;
import co.com.saraitel.gestionsaraitel.entidad.MotivoEntidad;

public class DevolucionPostgreSqlDAO extends SqlDAO implements DevolucionDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."Devolucion"
			("id", "DetalleCompra_id", "Motivo_id", "Cantidad", "FechaDevolucion")
			VALUES (?, ?, ?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "DetalleCompra_id", "Motivo_id", "Cantidad", "FechaDevolucion"
			FROM saraitel."Devolucion"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "DetalleCompra_id", "Motivo_id", "Cantidad", "FechaDevolucion"
			FROM saraitel."Devolucion"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "DetalleCompra_id", "Motivo_id", "Cantidad", "FechaDevolucion"
			FROM saraitel."Devolucion"
			""";

	private static final String SQL_ACTUALIZAR = """
			UPDATE saraitel."Devolucion"
			SET "DetalleCompra_id" = ?,
			    "Motivo_id" = ?,
			    "Cantidad" = ?,
			    "FechaDevolucion" = ?
			WHERE "id" = ?
			""";

	public DevolucionPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final DevolucionEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear la devolución",
				entidad.getId().toString(), entidad.getDetalleCompra().getId().toString(),
				entidad.getMotivo().getId().toString(), entidad.getCantidad(), entidad.getFechaDevolucion());
	}

	@Override
	public DevolucionEntidad consultarPorId(final UUID id) {
		List<DevolucionEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id.toString()),
				this::mapear, "Error al consultar la devolución");

		return resultado.isEmpty() ? new DevolucionEntidad() : resultado.get(0);
	}

	@Override
	public List<DevolucionEntidad> consultarPorFiltro(final DevolucionEntidad filtro) {

		DevolucionEntidad filtroSeguro = filtro == null ? new DevolucionEntidad() : filtro;

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO)
				.conId("\"id\"", filtroSeguro.getId())
				.conId("\"DetalleCompra_id\"", filtroSeguro.getDetalleCompra().getId())
				.conId("\"Motivo_id\"", filtroSeguro.getMotivo().getId())
				.conEntero("\"Cantidad\"", filtroSeguro.getCantidad())
				.conFechaHora("\"FechaDevolucion\"", filtroSeguro.getFechaDevolucion());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar devoluciones");
	}

	@Override
	public List<DevolucionEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear, "Error al consultar devoluciones");
	}

	@Override
	public void actualizar(final UUID id, final DevolucionEntidad entidad) {

		ejecutarActualizacion(SQL_ACTUALIZAR, "Error al actualizar la devolución",
				entidad.getDetalleCompra().getId().toString(), entidad.getMotivo().getId().toString(),
				entidad.getCantidad(), entidad.getFechaDevolucion(), id.toString());
	}

	private DevolucionEntidad mapear(final ResultSet resultados) throws SQLException {

		DevolucionEntidad entidad = new DevolucionEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		DetalleCompraEntidad detalleCompra = new DetalleCompraEntidad();
		detalleCompra.setId(leerUUID(resultados, "DetalleCompra_id"));
		entidad.setDetalleCompra(detalleCompra);

		MotivoEntidad motivo = new MotivoEntidad();
		motivo.setId(leerUUID(resultados, "Motivo_id"));
		entidad.setMotivo(motivo);

		entidad.setCantidad(resultados.getInt("Cantidad"));
		entidad.setFechaDevolucion(resultados.getTimestamp("FechaDevolucion").toLocalDateTime());

		return entidad;
	}
}
