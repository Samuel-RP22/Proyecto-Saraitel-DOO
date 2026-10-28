
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
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DevolucionPostgreSqlDAO extends SqlDAO implements DevolucionDAO {

	public DevolucionPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final DevolucionEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.DevolucionPostgreSqlDAO.SQL_CREAR, CatalogoMensajesSql.DevolucionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_DEVOLUCION,
				CatalogoMensajesSql.DevolucionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_DEVOLUCION, entidad.getId(),
				entidad.getDetalleCompra().getId(), entidad.getMotivo().getId(),
				entidad.getFechaDevolucion(), entidad.getCantidad(), entidad.getMontoDevolucion(),
				entidad.getEstado());
	}

	@Override
	public DevolucionEntidad consultarPorId(final UUID id) {
		List<DevolucionEntidad> resultado = ejecutarConsulta(CatalogoMensajesSql.DevolucionPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, CatalogoMensajesSql.DevolucionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_DEVOLUCION,
				CatalogoMensajesSql.DevolucionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEVOLUCION);

		return obtenerPrimeroOValorDefecto(resultado, new DevolucionEntidad());
	}

	@Override
	public List<DevolucionEntidad> consultarPorFiltro(final DevolucionEntidad filtro) {

		DevolucionEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new DevolucionEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoMensajesSql.DevolucionPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"DetalleCompra_id\"", filtroSeguro.getDetalleCompra().getId())
				.conId("\"Motivo_id\"", filtroSeguro.getMotivo().getId())
				.conFechaHora("\"FechaDevolucion\"", filtroSeguro.getFechaDevolucion())
				.conEntero("\"Cantidad\"", filtroSeguro.getCantidad())
				.conDecimal("\"MontoDevolucion\"", filtroSeguro.getMontoDevolucion())
				.conTexto("\"Estado\"", filtroSeguro.getEstado());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajesSql.DevolucionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_DEVOLUCIONES,
				CatalogoMensajesSql.DevolucionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEVOLUCIONES);
	}

	@Override
	public List<DevolucionEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.DevolucionPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear, CatalogoMensajesSql.DevolucionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_DEVOLUCIONES,
				CatalogoMensajesSql.DevolucionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEVOLUCIONES);
	}

	@Override
	public void actualizar(final UUID id, final DevolucionEntidad entidad) {

		ejecutarActualizacion(CatalogoMensajesSql.DevolucionPostgreSqlDAO.SQL_ACTUALIZAR, CatalogoMensajesSql.DevolucionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_DEVOLUCION,
				CatalogoMensajesSql.DevolucionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_DEVOLUCION,
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

		entidad.setFechaDevolucion(leerFechaHora(resultados, "FechaDevolucion"));
		entidad.setCantidad(resultados.getInt("Cantidad"));
		entidad.setMontoDevolucion(resultados.getBigDecimal("MontoDevolucion"));
		entidad.setEstado(resultados.getString("Estado"));

		return entidad;
	}
}
