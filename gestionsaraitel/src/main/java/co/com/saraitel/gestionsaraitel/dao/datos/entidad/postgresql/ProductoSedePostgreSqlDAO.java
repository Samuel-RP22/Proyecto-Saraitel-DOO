
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ProductoSedeDAO;
import co.com.saraitel.gestionsaraitel.entidad.ProductoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProductoSedeEntidad;
import co.com.saraitel.gestionsaraitel.entidad.SedeEntidad;

public class ProductoSedePostgreSqlDAO extends SqlDAO implements ProductoSedeDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."ProductoSede"
			("id", "Producto_id", "Sede_id", "Precio", "TieneOferta",
			 "Oferta", "PrecioTrasOferta", "Stock", "StockGarantia")
			VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "Producto_id", "Sede_id", "Precio", "TieneOferta",
			       "Oferta", "PrecioTrasOferta", "Stock", "StockGarantia"
			FROM saraitel."ProductoSede"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "Producto_id", "Sede_id", "Precio", "TieneOferta",
			       "Oferta", "PrecioTrasOferta", "Stock", "StockGarantia"
			FROM saraitel."ProductoSede"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "Producto_id", "Sede_id", "Precio", "TieneOferta",
			       "Oferta", "PrecioTrasOferta", "Stock", "StockGarantia"
			FROM saraitel."ProductoSede"
			""";

	private static final String SQL_ACTUALIZAR = """
			UPDATE saraitel."ProductoSede"
			SET "Producto_id" = ?,
			    "Sede_id" = ?,
			    "Precio" = ?,
			    "TieneOferta" = ?,
			    "Oferta" = ?,
			    "PrecioTrasOferta" = ?,
			    "Stock" = ?,
			    "StockGarantia" = ?
			WHERE "id" = ?
			""";

	public ProductoSedePostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ProductoSedeEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear el producto por sede", entidad.getId().toString(),
				entidad.getProducto().getId().toString(), entidad.getSede().getId().toString(), entidad.getPrecio(),
				entidad.getTieneOferta(), entidad.getOferta(), entidad.getPrecioTrasOferta(), entidad.getStock(),
				entidad.getStockGarantia());
	}

	@Override
	public ProductoSedeEntidad consultarPorId(final UUID id) {
		List<ProductoSedeEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id.toString()),
				this::mapear, "Error al consultar el producto por sede");

		if (resultado.isEmpty()) {
			return new ProductoSedeEntidad();
		} else {
			return resultado.get(0);
		}
	}

	@Override
	public List<ProductoSedeEntidad> consultarPorFiltro(final ProductoSedeEntidad filtro) {
		ProductoSedeEntidad filtroSeguro;

		if (filtro == null) {
			filtroSeguro = new ProductoSedeEntidad();
		} else {
			filtroSeguro = filtro;
		}

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Producto_id\"", filtroSeguro.getProducto().getId())
				.conId("\"Sede_id\"", filtroSeguro.getSede().getId()).conEntero("\"Oferta\"", filtroSeguro.getOferta())
				.conEntero("\"Stock\"", filtroSeguro.getStock())
				.conEntero("\"StockGarantia\"", filtroSeguro.getStockGarantia());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar productos por sede");
	}

	@Override
	public List<ProductoSedeEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear, "Error al consultar productos por sede");
	}

	@Override
	public void actualizar(final UUID id, final ProductoSedeEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, "Error al actualizar el producto por sede",
				entidad.getProducto().getId().toString(), entidad.getSede().getId().toString(), entidad.getPrecio(),
				entidad.getTieneOferta(), entidad.getOferta(), entidad.getPrecioTrasOferta(), entidad.getStock(),
				entidad.getStockGarantia(), id.toString());
	}

	private ProductoSedeEntidad mapear(final ResultSet resultados) throws SQLException {
		ProductoEntidad producto = new ProductoEntidad();
		producto.setId(leerUUID(resultados, "Producto_id"));

		SedeEntidad sede = new SedeEntidad();
		sede.setId(leerUUID(resultados, "Sede_id"));

		return new ProductoSedeEntidad.Builder().id(leerUUID(resultados, "id")).producto(producto).sede(sede)
				.precio(resultados.getBigDecimal("Precio")).tieneOferta(resultados.getBoolean("TieneOferta"))
				.oferta(resultados.getInt("Oferta")).precioTrasOferta(resultados.getBigDecimal("PrecioTrasOferta"))
				.stock(resultados.getInt("Stock")).stockGarantia(resultados.getInt("StockGarantia")).construir();
	}
}
