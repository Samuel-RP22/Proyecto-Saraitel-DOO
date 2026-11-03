
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PrefijoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.PrefijoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PrefijoPostgreSqlDAO extends SqlDAO implements PrefijoDAO {

	public PrefijoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public PrefijoEntidad consultarPorId(final UUID id) {
		var filtro = new PrefijoEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new PrefijoEntidad());
	}

	@Override
	public List<PrefijoEntidad> consultarPorFiltro(final PrefijoEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new PrefijoEntidad());

		var consulta = new FiltroSql(CatalogoSentenciasSql.PrefijoPostgreSqlDAO.SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId()).conTexto("\"Codigo\"",
				filtroSeguro.getCodigo());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.PrefijoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PREFIJOS,
				CatalogoMensajes.PrefijoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PREFIJOS);
	}

	@Override
	public List<PrefijoEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.PrefijoPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear, CatalogoMensajes.PrefijoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PREFIJOS,
				CatalogoMensajes.PrefijoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PREFIJOS);
	}

	private PrefijoEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new PrefijoEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setCodigo(resultados.getString("Codigo"));

		return entidad;
	}
}
