
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PagoNormalDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.MetodoPagoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PagoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PagoNormalEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PagoNormalPostgreSqlDAO extends SqlDAO implements PagoNormalDAO {

	public PagoNormalPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final PagoNormalEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.PagoNormalPostgreSqlDAO.SQL_CREAR, CatalogoMensajesSql.PagoNormalPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_PAGO_NORMAL,
				CatalogoMensajesSql.PagoNormalPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PAGO_NORMAL, entidad.getId(),
				entidad.getMetodoPago().getId(), entidad.getPago().getId(),
				entidad.getMontoPagar());
	}

	@Override
	public PagoNormalEntidad consultarPorId(final UUID id) {
		List<PagoNormalEntidad> resultado = ejecutarConsulta(CatalogoMensajesSql.PagoNormalPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, CatalogoMensajesSql.PagoNormalPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAGO_NORMAL,
				CatalogoMensajesSql.PagoNormalPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAGO_NORMAL);

		return obtenerPrimeroOValorDefecto(resultado, new PagoNormalEntidad());
	}

	@Override
	public List<PagoNormalEntidad> consultarPorFiltro(final PagoNormalEntidad filtro) {

		PagoNormalEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new PagoNormalEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoMensajesSql.PagoNormalPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"MetodoPago_id\"", filtroSeguro.getMetodoPago().getId())
				.conId("\"Pago_id\"", filtroSeguro.getPago().getId())
				.conDecimal("\"MontoPagar\"", filtroSeguro.getMontoPagar());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajesSql.PagoNormalPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAGOS_NORMALES,
				CatalogoMensajesSql.PagoNormalPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAGOS_NORMALES);
	}

	@Override
	public List<PagoNormalEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.PagoNormalPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear,
				CatalogoMensajesSql.PagoNormalPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAGOS_NORMALES,
				CatalogoMensajesSql.PagoNormalPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAGOS_NORMALES);
	}

	private PagoNormalEntidad mapear(final ResultSet resultados) throws SQLException {

		PagoNormalEntidad entidad = new PagoNormalEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		MetodoPagoEntidad metodoPago = new MetodoPagoEntidad();

		metodoPago.setId(leerUUID(resultados, "MetodoPago_id"));

		entidad.setMetodoPago(metodoPago);

		PagoEntidad pago = new PagoEntidad();

		pago.setId(leerUUID(resultados, "Pago_id"));

		entidad.setPago(pago);

		entidad.setMontoPagar(resultados.getBigDecimal("MontoPagar"));

		return entidad;
	}
}
