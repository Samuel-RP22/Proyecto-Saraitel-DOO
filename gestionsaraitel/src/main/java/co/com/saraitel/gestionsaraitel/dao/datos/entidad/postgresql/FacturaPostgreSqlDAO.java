
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FacturaDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.CompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.FacturaEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class FacturaPostgreSqlDAO extends SqlDAO implements FacturaDAO {

	public FacturaPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final FacturaEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.FacturaPostgreSqlDAO.SQL_CREAR, CatalogoMensajesSql.FacturaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_FACTURA, CatalogoMensajesSql.FacturaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_FACTURA,
				entidad.getId(), entidad.getCompra().getId(), entidad.getFechaEmision());
	}

	@Override
	public FacturaEntidad consultarPorId(final UUID id) {
		List<FacturaEntidad> resultado = ejecutarConsulta(CatalogoMensajesSql.FacturaPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id), this::mapear,
				CatalogoMensajesSql.FacturaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_FACTURA, CatalogoMensajesSql.FacturaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_FACTURA);

		return obtenerPrimeroOValorDefecto(resultado, new FacturaEntidad());
	}

	@Override
	public List<FacturaEntidad> consultarPorFiltro(final FacturaEntidad filtro) {
		FacturaEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new FacturaEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoMensajesSql.FacturaPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Compra_id\"", filtroSeguro.getCompra().getId())
				.conFechaHora("\"FechaEmision\"", filtroSeguro.getFechaEmision());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajesSql.FacturaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_FACTURAS, CatalogoMensajesSql.FacturaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_FACTURAS);
	}

	@Override
	public List<FacturaEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.FacturaPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear, CatalogoMensajesSql.FacturaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_FACTURAS,
				CatalogoMensajesSql.FacturaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_FACTURAS);
	}

	private FacturaEntidad mapear(final ResultSet resultados) throws SQLException {
		CompraEntidad compra = new CompraEntidad();
		compra.setId(leerUUID(resultados, "Compra_id"));

		return new FacturaEntidad(leerUUID(resultados, "id"), compra,
				leerFechaHora(resultados, "FechaEmision"));
	}
}
