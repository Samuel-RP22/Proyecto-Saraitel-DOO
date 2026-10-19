
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DevolucionDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.DetalleCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.DevolucionEntidad;
import co.com.saraitel.gestionsaraitel.entidad.MotivoEntidad;

public class DevolucionPostgreSqlDAO extends SqlDAO implements DevolucionDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."Devolucion"
			("id", "DetalleCompra_id", "Motivo_id", "FechaDevolucion",
			 "Cantidad", "MontoDevolucion", "Estado")
			VALUES (?, ?, ?, ?, ?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "DetalleCompra_id", "Motivo_id", "FechaDevolucion",
			       "Cantidad", "MontoDevolucion", "Estado"
			FROM saraitel."Devolucion"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "DetalleCompra_id", "Motivo_id", "FechaDevolucion",
			       "Cantidad", "MontoDevolucion", "Estado"
			FROM saraitel."Devolucion"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "DetalleCompra_id", "Motivo_id", "FechaDevolucion",
			       "Cantidad", "MontoDevolucion", "Estado"
			FROM saraitel."Devolucion"
			""";

	private static final String SQL_ACTUALIZAR = """
			UPDATE saraitel."Devolucion"
			SET "DetalleCompra_id" = ?,
			    "Motivo_id" = ?,
			    "FechaDevolucion" = ?,
			    "Cantidad" = ?,
			    "MontoDevolucion" = ?,
			    "Estado" = ?
			WHERE "id" = ?
			""";

	public DevolucionPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final DevolucionEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear la devolución",
				"Error NO CONTROLADO al crear la devolución", entidad.getId(),
				entidad.getDetalleCompra().getId(), entidad.getMotivo().getId(),
				entidad.getFechaDevolucion(), entidad.getCantidad(), entidad.getMontoDevolucion(),
				entidad.getEstado());
	}

	@Override
	public DevolucionEntidad consultarPorId(final UUID id) {
		List<DevolucionEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, "Error al consultar la devolución",
				"Error NO CONTROLADO al consultar la devolución");

		if (resultado.isEmpty()) {
			return new DevolucionEntidad();
		} else {
			return resultado.get(0);
		}
	}

	@Override
	public List<DevolucionEntidad> consultarPorFiltro(final DevolucionEntidad filtro) {

		DevolucionEntidad filtroSeguro = filtro == null ? new DevolucionEntidad() : filtro;

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"DetalleCompra_id\"", filtroSeguro.getDetalleCompra().getId())
				.conId("\"Motivo_id\"", filtroSeguro.getMotivo().getId())
				.conFechaHora("\"FechaDevolucion\"", filtroSeguro.getFechaDevolucion())
				.conEntero("\"Cantidad\"", filtroSeguro.getCantidad())
				.conDecimal("\"MontoDevolucion\"", filtroSeguro.getMontoDevolucion())
				.conTexto("\"Estado\"", filtroSeguro.getEstado());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar devoluciones",
				"Error NO CONTROLADO al consultar devoluciones");
	}

	@Override
	public List<DevolucionEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear, "Error al consultar las devoluciones",
				"Error NO CONTROLADO al consultar las devoluciones");
	}

	@Override
	public void actualizar(final UUID id, final DevolucionEntidad entidad) {

		ejecutarActualizacion(SQL_ACTUALIZAR, "Error al actualizar la devolución",
				"Error NO CONTROLADO al actualizar la devolución",
				entidad.getDetalleCompra().getId(), entidad.getMotivo().getId(),
				entidad.getFechaDevolucion(), entidad.getCantidad(), entidad.getMontoDevolucion(),
				entidad.getEstado(), id);
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

		entidad.setFechaDevolucion(resultados.getTimestamp("FechaDevolucion").toLocalDateTime());
		entidad.setCantidad(resultados.getInt("Cantidad"));
		entidad.setMontoDevolucion(resultados.getBigDecimal("MontoDevolucion"));
		entidad.setEstado(resultados.getString("Estado"));

		return entidad;
	}
}
