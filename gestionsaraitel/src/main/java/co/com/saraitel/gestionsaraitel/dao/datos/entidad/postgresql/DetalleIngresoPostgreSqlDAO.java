
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DetalleIngresoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.DetalleIngresoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.IngresoInventarioEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProductoSedeEntidad;

public class DetalleIngresoPostgreSqlDAO extends SqlDAO implements DetalleIngresoDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."DetalleIngreso"
			("id", "IngresoInventario_id", "ProductoSede_id",
			 "Cantidad", "CostoUnitario", "Subtotal")
			VALUES (?, ?, ?, ?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "IngresoInventario_id", "ProductoSede_id",
			       "Cantidad", "CostoUnitario", "Subtotal"
			FROM saraitel."DetalleIngreso"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "IngresoInventario_id", "ProductoSede_id",
			       "Cantidad", "CostoUnitario", "Subtotal"
			FROM saraitel."DetalleIngreso"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "IngresoInventario_id", "ProductoSede_id",
			       "Cantidad", "CostoUnitario", "Subtotal"
			FROM saraitel."DetalleIngreso"
			""";

	private static final String SQL_ACTUALIZAR = """
			UPDATE saraitel."DetalleIngreso"
			SET "IngresoInventario_id" = ?,
			    "ProductoSede_id" = ?,
			    "Cantidad" = ?,
			    "CostoUnitario" = ?,
			    "Subtotal" = ?
			WHERE "id" = ?
			""";

	private static final String SQL_ELIMINAR = """
			DELETE FROM saraitel."DetalleIngreso"
			WHERE "id" = ?
			""";

	public DetalleIngresoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final DetalleIngresoEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear el detalle del ingreso", entidad.getId().toString(),
				entidad.getIngresoInventario().getId().toString(), entidad.getProductoSede().getId().toString(),
				entidad.getCantidad(), entidad.getCostoUnitario(), entidad.getSubtotal());
	}

	@Override
	public DetalleIngresoEntidad consultarPorId(final UUID id) {
		List<DetalleIngresoEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id.toString()),
				this::mapear, "Error al consultar el detalle del ingreso");

		return resultado.isEmpty() ? new DetalleIngresoEntidad() : resultado.get(0);
	}

	@Override
	public List<DetalleIngresoEntidad> consultarPorFiltro(final DetalleIngresoEntidad filtro) {

		DetalleIngresoEntidad filtroSeguro = filtro == null ? new DetalleIngresoEntidad() : filtro;

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"IngresoInventario_id\"", filtroSeguro.getIngresoInventario().getId())
				.conId("\"ProductoSede_id\"", filtroSeguro.getProductoSede().getId())
				.conEntero("\"Cantidad\"", filtroSeguro.getCantidad());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar detalles del ingreso");
	}

	@Override
	public List<DetalleIngresoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear,
				"Error al consultar los detalles del ingreso");
	}

	@Override
	public void actualizar(final UUID id, final DetalleIngresoEntidad entidad) {

		ejecutarActualizacion(SQL_ACTUALIZAR, "Error al actualizar el detalle del ingreso",
				entidad.getIngresoInventario().getId().toString(), entidad.getProductoSede().getId().toString(),
				entidad.getCantidad(), entidad.getCostoUnitario(), entidad.getSubtotal(), id.toString());
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, "Error al eliminar el detalle del ingreso", id.toString());
	}

	private DetalleIngresoEntidad mapear(final ResultSet resultados) throws SQLException {

		DetalleIngresoEntidad entidad = new DetalleIngresoEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		IngresoInventarioEntidad ingresoInventario = new IngresoInventarioEntidad();

		ingresoInventario.setId(leerUUID(resultados, "IngresoInventario_id"));

		entidad.setIngresoInventario(ingresoInventario);

		ProductoSedeEntidad productoSede = new ProductoSedeEntidad();

		productoSede.setId(leerUUID(resultados, "ProductoSede_id"));

		entidad.setProductoSede(productoSede);

		entidad.setCantidad(resultados.getInt("Cantidad"));
		entidad.setCostoUnitario(resultados.getBigDecimal("CostoUnitario"));
		entidad.setSubtotal(resultados.getBigDecimal("Subtotal"));

		return entidad;
	}
}
