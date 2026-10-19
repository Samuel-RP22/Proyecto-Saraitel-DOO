
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DetalleCompraDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.CompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.DetalleCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProductoSedeEntidad;

public class DetalleCompraPostgreSqlDAO extends SqlDAO implements DetalleCompraDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."DetalleCompra"
			("id", "Compra_id", "ProductoSede_id", "Cantidad", "PrecioUnitario", "Subtotal")
			VALUES (?, ?, ?, ?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "Compra_id", "ProductoSede_id", "Cantidad", "PrecioUnitario", "Subtotal"
			FROM saraitel."DetalleCompra"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "Compra_id", "ProductoSede_id", "Cantidad", "PrecioUnitario", "Subtotal"
			FROM saraitel."DetalleCompra"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "Compra_id", "ProductoSede_id", "Cantidad", "PrecioUnitario", "Subtotal"
			FROM saraitel."DetalleCompra"
			""";

	private static final String SQL_ACTUALIZAR = """
			UPDATE saraitel."DetalleCompra"
			SET "Compra_id" = ?,
			    "ProductoSede_id" = ?,
			    "Cantidad" = ?,
			    "PrecioUnitario" = ?,
			    "Subtotal" = ?
			WHERE "id" = ?
			""";

	private static final String SQL_ELIMINAR = """
			DELETE FROM saraitel."DetalleCompra"
			WHERE "id" = ?
			""";

	public DetalleCompraPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final DetalleCompraEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear el detalle de la compra",
				entidad.getId().toString(), entidad.getCompra().getId().toString(),
				entidad.getProductoSede().getId().toString(), entidad.getCantidad(),
				entidad.getPrecioUnitario(), entidad.getSubtotal());
	}

	@Override
	public DetalleCompraEntidad consultarPorId(final UUID id) {
		List<DetalleCompraEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id.toString()),
				this::mapear, "Error al consultar el detalle de la compra");

		return resultado.isEmpty() ? new DetalleCompraEntidad() : resultado.get(0);
	}

	@Override
	public List<DetalleCompraEntidad> consultarPorFiltro(final DetalleCompraEntidad filtro) {

		DetalleCompraEntidad filtroSeguro = filtro == null ? new DetalleCompraEntidad() : filtro;

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO)
				.conId("\"id\"", filtroSeguro.getId())
				.conId("\"Compra_id\"", filtroSeguro.getCompra().getId())
				.conId("\"ProductoSede_id\"", filtroSeguro.getProductoSede().getId())
				.conEntero("\"Cantidad\"", filtroSeguro.getCantidad())
				.conDecimal("\"PrecioUnitario\"", filtroSeguro.getPrecioUnitario())
				.conDecimal("\"Subtotal\"", filtroSeguro.getSubtotal());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar detalles de la compra");
	}

	@Override
	public List<DetalleCompraEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear, "Error al consultar detalles de la compra");
	}

	@Override
	public void actualizar(final UUID id, final DetalleCompraEntidad entidad) {

		ejecutarActualizacion(SQL_ACTUALIZAR, "Error al actualizar el detalle de la compra",
				entidad.getCompra().getId().toString(), entidad.getProductoSede().getId().toString(),
				entidad.getCantidad(), entidad.getPrecioUnitario(), entidad.getSubtotal(), id.toString());
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, "Error al eliminar el detalle de la compra", id.toString());
	}

	private DetalleCompraEntidad mapear(final ResultSet resultados) throws SQLException {

		DetalleCompraEntidad entidad = new DetalleCompraEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		CompraEntidad compra = new CompraEntidad();
		compra.setId(leerUUID(resultados, "Compra_id"));
		entidad.setCompra(compra);

		ProductoSedeEntidad productoSede = new ProductoSedeEntidad();
		productoSede.setId(leerUUID(resultados, "ProductoSede_id"));
		entidad.setProductoSede(productoSede);

		entidad.setCantidad(resultados.getInt("Cantidad"));
		entidad.setPrecioUnitario(resultados.getBigDecimal("PrecioUnitario"));
		entidad.setSubtotal(resultados.getBigDecimal("Subtotal"));

		return entidad;
	}
}
