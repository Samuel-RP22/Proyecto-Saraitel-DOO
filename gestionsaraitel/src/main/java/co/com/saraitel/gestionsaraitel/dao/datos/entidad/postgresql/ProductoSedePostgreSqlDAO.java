
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ProductoSedeDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ProductoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProductoSedeEntidad;
import co.com.saraitel.gestionsaraitel.entidad.SedeEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ProductoSedePostgreSqlDAO extends SqlDAO implements ProductoSedeDAO {

	public ProductoSedePostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ProductoSedeEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.ProductoSedePostgreSqlDAO.SQL_CREAR, CatalogoMensajesSql.ProductoSedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_PRODUCTO_POR_SEDE,
				CatalogoMensajesSql.ProductoSedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PRODUCTO_POR_SEDE, entidad.getId(),
				entidad.getProducto().getId(), entidad.getSede().getId(), entidad.getPrecio(),
				entidad.getTieneOferta(), entidad.getOferta(), entidad.getPrecioTrasOferta(), entidad.getStock(),
				entidad.getStockGarantia());
	}

	@Override
	public ProductoSedeEntidad consultarPorId(final UUID id) {
		List<ProductoSedeEntidad> resultado = ejecutarConsulta(CatalogoMensajesSql.ProductoSedePostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, CatalogoMensajesSql.ProductoSedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PRODUCTO_POR_SEDE,
				CatalogoMensajesSql.ProductoSedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTO_POR_SEDE);

		return obtenerPrimeroOValorDefecto(resultado, new ProductoSedeEntidad());
	}

	@Override
	public List<ProductoSedeEntidad> consultarPorFiltro(final ProductoSedeEntidad filtro) {
		ProductoSedeEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new ProductoSedeEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoMensajesSql.ProductoSedePostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Producto_id\"", filtroSeguro.getProducto().getId())
				.conId("\"Sede_id\"", filtroSeguro.getSede().getId()).conEntero("\"Oferta\"", filtroSeguro.getOferta())
				.conEntero("\"Stock\"", filtroSeguro.getStock())
				.conEntero("\"StockGarantia\"", filtroSeguro.getStockGarantia());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajesSql.ProductoSedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PRODUCTOS_POR_SEDE,
				CatalogoMensajesSql.ProductoSedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTOS_POR_SEDE);
	}

	@Override
	public List<ProductoSedeEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.ProductoSedePostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear, CatalogoMensajesSql.ProductoSedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PRODUCTOS_POR_SEDE,
				CatalogoMensajesSql.ProductoSedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTOS_POR_SEDE);
	}

	@Override
	public void actualizar(final UUID id, final ProductoSedeEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.ProductoSedePostgreSqlDAO.SQL_ACTUALIZAR, CatalogoMensajesSql.ProductoSedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_PRODUCTO_POR_SEDE,
				CatalogoMensajesSql.ProductoSedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_PRODUCTO_POR_SEDE,
				entidad.getProducto().getId(), entidad.getSede().getId(), entidad.getPrecio(),
				entidad.getTieneOferta(), entidad.getOferta(), entidad.getPrecioTrasOferta(), entidad.getStock(),
				entidad.getStockGarantia(), id);
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
