
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.CompraDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.CompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EstadoCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class CompraPostgreSqlDAO extends SqlDAO implements CompraDAO {

	public CompraPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final CompraEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.CompraPostgreSqlDAO.SQL_CREAR, CatalogoMensajesSql.CompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_COMPRA, CatalogoMensajesSql.CompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_COMPRA,
				entidad.getId(), entidad.getProcesoCompra().getId(), entidad.getEstado().getId(),
				entidad.getFechaCompra());
	}

	@Override
	public CompraEntidad consultarPorId(final UUID id) {
		List<CompraEntidad> resultado = ejecutarConsulta(CatalogoMensajesSql.CompraPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id), this::mapear,
				CatalogoMensajesSql.CompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_COMPRA, CatalogoMensajesSql.CompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_COMPRA);

		return obtenerPrimeroOValorDefecto(resultado, new CompraEntidad());
	}

	@Override
	public List<CompraEntidad> consultarPorFiltro(final CompraEntidad filtro) {
		CompraEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new CompraEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoMensajesSql.CompraPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"ProcesoCompra_id\"", filtroSeguro.getProcesoCompra().getId())
				.conId("\"EstadoCompra_id\"", filtroSeguro.getEstado().getId())
				.conFechaHora("\"FechaCompra\"", filtroSeguro.getFechaCompra());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajesSql.CompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_COMPRAS, CatalogoMensajesSql.CompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_COMPRAS);
	}

	@Override
	public List<CompraEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.CompraPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear, CatalogoMensajesSql.CompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_COMPRAS,
				CatalogoMensajesSql.CompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_COMPRAS);
	}

	private CompraEntidad mapear(final ResultSet resultados) throws SQLException {
		ProcesoCompraEntidad procesoCompra = new ProcesoCompraEntidad();
		procesoCompra.setId(leerUUID(resultados, "ProcesoCompra_id"));

		EstadoCompraEntidad estado = new EstadoCompraEntidad();
		estado.setId(leerUUID(resultados, "EstadoCompra_id"));

		return new CompraEntidad(leerUUID(resultados, "id"), procesoCompra, estado,
				leerFechaHora(resultados, "FechaCompra"));
	}
}
