
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PrefijoDAO;
import co.com.saraitel.gestionsaraitel.entidad.PrefijoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PrefijoPostgreSqlDAO extends SqlDAO implements PrefijoDAO {

	private static final String SQL_CONSULTAR = "SELECT \"id\", \"Codigo\" FROM saraitel.\"Prefijo\"";

	public PrefijoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public PrefijoEntidad consultarPorId(final UUID id) {
		var filtro = new PrefijoEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new PrefijoEntidad() : resultados.get(0);
	}

	@Override
	public List<PrefijoEntidad> consultarPorFiltro(final PrefijoEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new PrefijoEntidad());

		var consulta = new FiltroSql(SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId()).conTexto("\"Codigo\"",
				filtroSeguro.getCodigo());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				"Error al consultar prefijos.");
	}

	@Override
	public List<PrefijoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar prefijos.");
	}

	private PrefijoEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new PrefijoEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setCodigo(resultados.getString("Codigo"));

		return entidad;
	}
}
