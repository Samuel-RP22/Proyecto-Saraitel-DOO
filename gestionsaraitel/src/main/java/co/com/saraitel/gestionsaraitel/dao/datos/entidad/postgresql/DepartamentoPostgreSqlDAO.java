
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DepartamentoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.DepartamentoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PaisEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DepartamentoPostgreSqlDAO extends SqlDAO implements DepartamentoDAO {

	private static final String SQL_CONSULTAR = "SELECT \"id\", \"Pais_id\", \"Nombre\" FROM saraitel.\"Departamento\"";

	public DepartamentoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public DepartamentoEntidad consultarPorId(final UUID id) {
		var filtro = new DepartamentoEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new DepartamentoEntidad() : resultados.get(0);
	}

	@Override
	public List<DepartamentoEntidad> consultarPorFiltro(final DepartamentoEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new DepartamentoEntidad());

		var consulta = new FiltroSql(SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Pais_id\"", filtroSeguro.getPais().getId()).conTexto("\"Nombre\"", filtroSeguro.getNombre());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				"Error al consultar departamentos.",
				"Error NO CONTROLADO al consultar departamentos.");
	}

	@Override
	public List<DepartamentoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar departamentos.",
				"Error NO CONTROLADO al consultar departamentos.");
	}

	private DepartamentoEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new DepartamentoEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("Nombre"));

		var pais = new PaisEntidad();
		pais.setId(leerUUID(resultados, "Pais_id"));
		entidad.setPais(pais);

		return entidad;
	}
}
