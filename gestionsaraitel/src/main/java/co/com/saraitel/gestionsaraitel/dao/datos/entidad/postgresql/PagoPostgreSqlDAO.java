
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PagoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.CompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PagoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PagoPostgreSqlDAO extends SqlDAO implements PagoDAO {

	public PagoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final PagoEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.PagoPostgreSqlDAO.SQL_CREAR, CatalogoMensajesSql.PagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_PAGO,
				CatalogoMensajesSql.PagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PAGO, entidad.getId(),
				entidad.getCompra().getId(), entidad.getMontoPagado(), entidad.getFechaPago());
	}

	@Override
	public PagoEntidad consultarPorId(final UUID id) {
		List<PagoEntidad> resultado = ejecutarConsulta(CatalogoMensajesSql.PagoPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id), this::mapear,
				CatalogoMensajesSql.PagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAGO,
				CatalogoMensajesSql.PagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAGO);

		return obtenerPrimeroOValorDefecto(resultado, new PagoEntidad());
	}

	@Override
	public List<PagoEntidad> consultarPorFiltro(final PagoEntidad filtro) {

		PagoEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new PagoEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoMensajesSql.PagoPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Compra_id\"", filtroSeguro.getCompra().getId())
				.conDecimal("\"MontoPagado\"", filtroSeguro.getMontoPagado())
				.conFechaHora("\"FechaPago\"", filtroSeguro.getFechaPago());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajesSql.PagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAGOS,
				CatalogoMensajesSql.PagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAGOS);
	}

	@Override
	public List<PagoEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.PagoPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear, CatalogoMensajesSql.PagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAGOS,
				CatalogoMensajesSql.PagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAGOS);
	}

	private PagoEntidad mapear(final ResultSet resultados) throws SQLException {

		PagoEntidad entidad = new PagoEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		CompraEntidad compra = new CompraEntidad();

		compra.setId(leerUUID(resultados, "Compra_id"));

		entidad.setCompra(compra);

		entidad.setMontoPagado(resultados.getBigDecimal("MontoPagado"));
		entidad.setFechaPago(leerFechaHora(resultados, "FechaPago"));

		return entidad;
	}
}
