package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.AplicacionSaldoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.AplicacionSaldoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PagoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.SaldoFavorEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class AplicacionSaldoPostgreSqlDAO extends SqlDAO implements AplicacionSaldoDAO {

	public AplicacionSaldoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final AplicacionSaldoEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.AplicacionSaldoPostgreSqlDAO.SQL_CREAR, CatalogoMensajesSql.AplicacionSaldoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_APLICACION_DE_SALDO,
				CatalogoMensajesSql.AplicacionSaldoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_APLICACION_DE_SALDO, entidad.getId(), entidad.getSaldoFavor().getId(),
				entidad.getPago().getId(), entidad.getValorAplicado());
	}

	@Override
	public AplicacionSaldoEntidad consultarPorId(final UUID id) {
		List<AplicacionSaldoEntidad> resultado = ejecutarConsulta(CatalogoMensajesSql.AplicacionSaldoPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id), this::mapear,
				CatalogoMensajesSql.AplicacionSaldoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_APLICACION_DE_SALDO, CatalogoMensajesSql.AplicacionSaldoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_APLICACION_DE_SALDO);

		return obtenerPrimeroOValorDefecto(resultado, new AplicacionSaldoEntidad());
	}

	@Override
	public List<AplicacionSaldoEntidad> consultarPorFiltro(final AplicacionSaldoEntidad filtro) {

		AplicacionSaldoEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new AplicacionSaldoEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoMensajesSql.AplicacionSaldoPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"SaldoFavor_id\"", filtroSeguro.getSaldoFavor().getId())
				.conId("\"Pago_id\"", filtroSeguro.getPago().getId())
				.conDecimal("\"ValorAplicado\"", filtroSeguro.getValorAplicado());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajesSql.AplicacionSaldoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_APLICACIONES_DE_SALDO, CatalogoMensajesSql.AplicacionSaldoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_APLICACIONES_DE_SALDO);
	}

	@Override
	public List<AplicacionSaldoEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.AplicacionSaldoPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear,
				CatalogoMensajesSql.AplicacionSaldoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_APLICACIONES_DE_SALDO,
				CatalogoMensajesSql.AplicacionSaldoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_APLICACIONES_DE_SALDO);
	}

	private AplicacionSaldoEntidad mapear(final ResultSet resultados) throws SQLException {

		AplicacionSaldoEntidad entidad = new AplicacionSaldoEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		SaldoFavorEntidad saldoFavor = new SaldoFavorEntidad();

		saldoFavor.setId(leerUUID(resultados, "SaldoFavor_id"));

		entidad.setSaldoFavor(saldoFavor);

		PagoEntidad pago = new PagoEntidad();

		pago.setId(leerUUID(resultados, "Pago_id"));

		entidad.setPago(pago);

		entidad.setValorAplicado(resultados.getBigDecimal("ValorAplicado"));

		return entidad;
	}
}
