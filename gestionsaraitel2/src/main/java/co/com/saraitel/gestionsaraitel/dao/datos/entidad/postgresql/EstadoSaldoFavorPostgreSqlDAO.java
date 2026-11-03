
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EstadoSaldoFavorDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.EstadoSaldoFavorEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EstadoSaldoFavorPostgreSqlDAO extends SqlDAO implements EstadoSaldoFavorDAO {

	public EstadoSaldoFavorPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final EstadoSaldoFavorEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.EstadoSaldoFavorPostgreSqlDAO.SQL_CREAR,
				CatalogoMensajes.EstadoSaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_ESTADO_DE_SALDO_A_FAVOR,
				CatalogoMensajes.EstadoSaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_ESTADO_DE_SALDO_A_FAVOR,
				entidad.getId(), entidad.getCodigo(), entidad.getNombre());
	}

	@Override
	public EstadoSaldoFavorEntidad consultarPorId(final UUID id) {
		List<EstadoSaldoFavorEntidad> resultado = ejecutarConsulta(
				CatalogoSentenciasSql.EstadoSaldoFavorPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id), this::mapear,
				CatalogoMensajes.EstadoSaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADO_DE_SALDO_A_FAVOR,
				CatalogoMensajes.EstadoSaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADO_DE_SALDO_A_FAVOR);

		return obtenerPrimeroOValorDefecto(resultado, new EstadoSaldoFavorEntidad());
	}

	@Override
	public List<EstadoSaldoFavorEntidad> consultarPorFiltro(final EstadoSaldoFavorEntidad filtro) {

		EstadoSaldoFavorEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro,
				new EstadoSaldoFavorEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoSentenciasSql.EstadoSaldoFavorPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO)
				.conId("\"id\"", filtroSeguro.getId()).conTexto("\"Codigo\"", filtroSeguro.getCodigo())
				.conTexto("\"Nombre\"", filtroSeguro.getNombre());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajes.EstadoSaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADOS_DE_SALDO_A_FAVOR,
				CatalogoMensajes.EstadoSaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_DE_SALDO_A_FAVOR);
	}

	@Override
	public List<EstadoSaldoFavorEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.EstadoSaldoFavorPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(),
				this::mapear,
				CatalogoMensajes.EstadoSaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADOS_DE_SALDO_A_FAVOR,
				CatalogoMensajes.EstadoSaldoFavorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_DE_SALDO_A_FAVOR);
	}

	private EstadoSaldoFavorEntidad mapear(final ResultSet resultados) throws SQLException {

		EstadoSaldoFavorEntidad entidad = new EstadoSaldoFavorEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setCodigo(resultados.getString("Codigo"));
		entidad.setNombre(resultados.getString("Nombre"));

		return entidad;
	}
}
