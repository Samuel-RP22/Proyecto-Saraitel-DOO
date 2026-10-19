
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.CiudadDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.CiudadEntidad;
import co.com.saraitel.gestionsaraitel.entidad.DepartamentoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class CiudadPostgreSqlDAO extends SqlDAO implements CiudadDAO {

	private static final String SQL_CONSULTAR = "SELECT \"id\", \"Departamento_id\", \"Nombre\" FROM saraitel.\"Ciudad\"";

	public CiudadPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public CiudadEntidad consultarPorId(final UUID id) {
		var filtro = new CiudadEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new CiudadEntidad() : resultados.get(0);
	}

	@Override
	public List<CiudadEntidad> consultarPorFiltro(final CiudadEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new CiudadEntidad());

		var consulta = new FiltroSql(SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Departamento_id\"", filtroSeguro.getDepartamento().getId())
				.conTexto("\"Nombre\"", filtroSeguro.getNombre());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				"Error al consultar ciudades.");
	}

	@Override
	public List<CiudadEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar ciudades.");
	}

	private CiudadEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new CiudadEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("Nombre"));

		var departamento = new DepartamentoEntidad();
		departamento.setId(leerUUID(resultados, "Departamento_id"));
		entidad.setDepartamento(departamento);

		return entidad;
	}
}
