
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DetalleIngresoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.DetalleIngresoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.IngresoInventarioEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProductoSedeEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DetalleIngresoPostgreSqlDAO extends SqlDAO implements DetalleIngresoDAO {

	public DetalleIngresoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final DetalleIngresoEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.SQL_CREAR, CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_DETALLE_DEL_INGRESO,
				CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_DETALLE_DEL_INGRESO, entidad.getId(),
				entidad.getIngresoInventario().getId(), entidad.getProductoSede().getId(),
				entidad.getCantidad(), entidad.getCostoUnitario(), entidad.getSubtotal());
	}

	@Override
	public DetalleIngresoEntidad consultarPorId(final UUID id) {
		List<DetalleIngresoEntidad> resultado = ejecutarConsulta(CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_DETALLE_DEL_INGRESO,
				CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DETALLE_DEL_INGRESO);

		return obtenerPrimeroOValorDefecto(resultado, new DetalleIngresoEntidad());
	}

	@Override
	public List<DetalleIngresoEntidad> consultarPorFiltro(final DetalleIngresoEntidad filtro) {

		DetalleIngresoEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new DetalleIngresoEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"IngresoInventario_id\"", filtroSeguro.getIngresoInventario().getId())
				.conId("\"ProductoSede_id\"", filtroSeguro.getProductoSede().getId())
				.conEntero("\"Cantidad\"", filtroSeguro.getCantidad());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_DETALLES_DEL_INGRESO,
				CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DETALLES_DEL_INGRESO);
	}

	@Override
	public List<DetalleIngresoEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear,
				CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_DETALLES_DEL_INGRESO,
				CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DETALLES_DEL_INGRESO);
	}

	@Override
	public void actualizar(final UUID id, final DetalleIngresoEntidad entidad) {

		ejecutarActualizacion(CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.SQL_ACTUALIZAR, CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_DETALLE_DEL_INGRESO,
				CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_DETALLE_DEL_INGRESO,
				entidad.getIngresoInventario().getId(), entidad.getProductoSede().getId(),
				entidad.getCantidad(), entidad.getCostoUnitario(), entidad.getSubtotal(), id);
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.SQL_ELIMINAR, CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ELIMINANDO_DETALLE_DEL_INGRESO,
				CatalogoMensajesSql.DetalleIngresoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_DETALLE_DEL_INGRESO, id);
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
