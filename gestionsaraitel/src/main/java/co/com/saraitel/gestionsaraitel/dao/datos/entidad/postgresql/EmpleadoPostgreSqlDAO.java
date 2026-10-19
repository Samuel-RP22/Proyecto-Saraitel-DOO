
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EmpleadoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.entidad.SedeEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EmpleadoPostgreSqlDAO extends SqlDAO implements EmpleadoDAO {

	private static final String SQL_CREAR = "INSERT INTO saraitel.\"Empleado\" "
			+ "(\"id\", \"Sede_id\", \"Persona_id\", \"EsActivo\") " + "VALUES (?, ?, ?, ?)";

	private static final String SQL_CONSULTAR = "SELECT \"id\", \"Sede_id\", \"Persona_id\", \"EsActivo\" "
			+ "FROM saraitel.\"Empleado\"";

	private static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Empleado\" "
			+ "SET \"Sede_id\" = ?, \"Persona_id\" = ?, \"EsActivo\" = ? " + "WHERE \"id\" = ?";

	public EmpleadoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final EmpleadoEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear empleado.",
				"Error NO CONTROLADO al crear empleado.", entidad.getId(),
				entidad.getSede().getId(), entidad.getPersona().getId(), entidad.getEsActivo());
	}

	@Override
	public EmpleadoEntidad consultarPorId(final UUID id) {
		var filtro = new EmpleadoEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new EmpleadoEntidad() : resultados.get(0);
	}

	@Override
	public List<EmpleadoEntidad> consultarPorFiltro(final EmpleadoEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new EmpleadoEntidad());

		var consulta = new FiltroSql(SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Sede_id\"", filtroSeguro.getSede().getId())
				.conId("\"Persona_id\"", filtroSeguro.getPersona().getId())
				.conBooleano("\"EsActivo\"", filtroSeguro.getEsActivo(), true);

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				"Error al consultar empleados.",
				"Error NO CONTROLADO al consultar empleados.");
	}

	@Override
	public List<EmpleadoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar empleados.",
				"Error NO CONTROLADO al consultar empleados.");
	}

	@Override
	public void actualizar(final UUID id, final EmpleadoEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, "Error al actualizar empleado.",
				"Error NO CONTROLADO al actualizar empleado.", entidad.getSede().getId(),
				entidad.getPersona().getId(), entidad.getEsActivo(), id);
	}

	private EmpleadoEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new EmpleadoEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setEsActivo(resultados.getBoolean("EsActivo"));

		var sede = new SedeEntidad();
		sede.setId(leerUUID(resultados, "Sede_id"));
		entidad.setSede(sede);

		var persona = new PersonaEntidad();
		persona.setId(leerUUID(resultados, "Persona_id"));
		entidad.setPersona(persona);

		return entidad;
	}
}
