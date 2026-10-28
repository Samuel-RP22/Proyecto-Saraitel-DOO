
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SaldoFavorDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.DevolucionEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EstadoSaldoFavorEntidad;
import co.com.saraitel.gestionsaraitel.entidad.SaldoFavorEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class SaldoFavorPostgreSqlDAO extends SqlDAO implements SaldoFavorDAO {

	public SaldoFavorPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final SaldoFavorEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.SaldoFavorPostgreSqlDAO.SQL_CREAR, CatalogoMensajes.SaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_SALDO_A_FAVOR,
				CatalogoMensajes.SaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_SALDO_A_FAVOR, entidad.getId(),
				entidad.getDevolucion().getId(), entidad.getEstado().getId(),
				entidad.getMontoUsado());
	}

	@Override
	public SaldoFavorEntidad consultarPorId(final UUID id) {
		List<SaldoFavorEntidad> resultado = ejecutarConsulta(CatalogoSentenciasSql.SaldoFavorPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, CatalogoMensajes.SaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_SALDO_A_FAVOR,
				CatalogoMensajes.SaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SALDO_A_FAVOR);

		return obtenerPrimeroOValorDefecto(resultado, new SaldoFavorEntidad());
	}

	@Override
	public List<SaldoFavorEntidad> consultarPorFiltro(final SaldoFavorEntidad filtro) {

		SaldoFavorEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new SaldoFavorEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoSentenciasSql.SaldoFavorPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Devolucion_id\"", filtroSeguro.getDevolucion().getId())
				.conId("\"EstadoSaldoFavor_id\"", filtroSeguro.getEstado().getId())
				.conDecimal("\"MontoUsado\"", filtroSeguro.getMontoUsado());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajes.SaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_SALDOS_A_FAVOR,
				CatalogoMensajes.SaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SALDOS_A_FAVOR);
	}

	@Override
	public List<SaldoFavorEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.SaldoFavorPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear,
				CatalogoMensajes.SaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_SALDOS_A_FAVOR,
				CatalogoMensajes.SaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SALDOS_A_FAVOR);
	}

	private SaldoFavorEntidad mapear(final ResultSet resultados) throws SQLException {

		SaldoFavorEntidad entidad = new SaldoFavorEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		DevolucionEntidad devolucion = new DevolucionEntidad();

		devolucion.setId(leerUUID(resultados, "Devolucion_id"));

		entidad.setDevolucion(devolucion);

		EstadoSaldoFavorEntidad estado = new EstadoSaldoFavorEntidad();

		estado.setId(leerUUID(resultados, "EstadoSaldoFavor_id"));

		entidad.setEstado(estado);

		entidad.setMontoUsado(resultados.getBigDecimal("MontoUsado"));

		return entidad;
	}
}
