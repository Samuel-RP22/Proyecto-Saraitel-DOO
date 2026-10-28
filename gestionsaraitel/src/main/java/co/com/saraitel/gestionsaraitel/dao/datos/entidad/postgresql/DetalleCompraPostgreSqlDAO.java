package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DetalleCompraDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.DetalleCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProductoSedeEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DetalleCompraPostgreSqlDAO extends SqlDAO implements DetalleCompraDAO {

	public DetalleCompraPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final DetalleCompraEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.SQL_CREAR,
				CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_DETALLE_DE_LA_COMPRA,
				CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_DETALLE_DE_LA_COMPRA,
				entidad.getId(), entidad.getProcesoCompra().getId(), entidad.getProductoSede().getId(),
				entidad.getCantidad(), entidad.getPrecioUnitario(), entidad.getSubtotal());
	}

	@Override
	public DetalleCompraEntidad consultarPorId(final UUID id) {
		List<DetalleCompraEntidad> resultado = ejecutarConsulta(
				CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id), this::mapear,
				CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_DETALLE_DE_LA_COMPRA,
				CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DETALLE_DE_LA_COMPRA);

		return obtenerPrimeroOValorDefecto(resultado, new DetalleCompraEntidad());
	}

	@Override
	public List<DetalleCompraEntidad> consultarPorFiltro(final DetalleCompraEntidad filtro) {

		DetalleCompraEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro,
				new DetalleCompraEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO)
				.conId("\"id\"", filtroSeguro.getId())
				.conId("\"ProcesoCompra_id\"", filtroSeguro.getProcesoCompra().getId())
				.conId("\"ProductoSede_id\"", filtroSeguro.getProductoSede().getId())
				.conEntero("\"Cantidad\"", filtroSeguro.getCantidad());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_DETALLES_DE_LA_COMPRA,
				CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DETALLES_DE_LA_COMPRA);
	}

	@Override
	public List<DetalleCompraEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(),
				this::mapear,
				CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_DETALLES_DE_LA_COMPRA,
				CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DETALLES_DE_LA_COMPRA);
	}

	@Override
	public void actualizar(final UUID id, final DetalleCompraEntidad entidad) {

		ejecutarActualizacion(CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.SQL_ACTUALIZAR,
				CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_DETALLE_DE_LA_COMPRA,
				CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_DETALLE_DE_LA_COMPRA,
				entidad.getProcesoCompra().getId(), entidad.getProductoSede().getId(), entidad.getCantidad(),
				entidad.getPrecioUnitario(), entidad.getSubtotal(), id);
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.SQL_ELIMINAR,
				CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ELIMINANDO_DETALLE_DE_LA_COMPRA,
				CatalogoMensajesSql.DetalleCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_DETALLE_DE_LA_COMPRA,
				id);
	}

	private DetalleCompraEntidad mapear(final ResultSet resultados) throws SQLException {

		DetalleCompraEntidad entidad = new DetalleCompraEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		ProcesoCompraEntidad procesoCompra = new ProcesoCompraEntidad();

		procesoCompra.setId(leerUUID(resultados, "ProcesoCompra_id"));

		entidad.setProcesoCompra(procesoCompra);

		ProductoSedeEntidad productoSede = new ProductoSedeEntidad();

		productoSede.setId(leerUUID(resultados, "ProductoSede_id"));

		entidad.setProductoSede(productoSede);

		entidad.setCantidad(resultados.getInt("Cantidad"));
		entidad.setPrecioUnitario(resultados.getBigDecimal("PrecioUnitario"));
		entidad.setSubtotal(resultados.getBigDecimal("Subtotal"));

		return entidad;
	}
}
