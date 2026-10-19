package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.AdministradorDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.AdministradorEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class AdministradorPostgreSqlDAO extends SqlDAO implements AdministradorDAO {

	private static final String SQL_CREAR = "INSERT INTO saraitel.\"Administrador\" (\"id\", \"Empleado_id\") VALUES (?, ?)";

	private static final String SQL_CONSULTAR = "SELECT \"id\", \"Empleado_id\" FROM saraitel.\"Administrador\"";

	public AdministradorPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final AdministradorEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear administrador.", entidad.getId().toString(),
				entidad.getEmpleado().getId().toString());
	}

	@Override
	public AdministradorEntidad consultarPorId(final UUID id) {
		var filtro = new AdministradorEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new AdministradorEntidad() : resultados.get(0);
	}

	@Override
	public List<AdministradorEntidad> consultarPorFiltro(final AdministradorEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new AdministradorEntidad());

		var consulta = new FiltroSql(SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId()).conId("\"Empleado_id\"",
				filtroSeguro.getEmpleado().getId());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				"Error al consultar administradores.");
	}

	@Override
	public List<AdministradorEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar administradores.");
	}

	private AdministradorEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new AdministradorEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		var empleado = new EmpleadoEntidad();
		empleado.setId(leerUUID(resultados, "Empleado_id"));
		entidad.setEmpleado(empleado);

		return entidad;
	}
}
