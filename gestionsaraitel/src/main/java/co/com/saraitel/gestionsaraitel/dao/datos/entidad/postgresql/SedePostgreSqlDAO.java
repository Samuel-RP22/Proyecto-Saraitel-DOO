
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SedeDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.CiudadEntidad;
import co.com.saraitel.gestionsaraitel.entidad.SedeEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class SedePostgreSqlDAO extends SqlDAO implements SedeDAO {

	private static final String SQL_CREAR = "INSERT INTO saraitel.\"Sede\" "
			+ "(\"id\", \"Ciudad_id\", \"Nombre\", \"Nit\", \"Direccion\", \"EsActiva\") "
			+ "VALUES (?, ?, ?, ?, ?, ?)";

	private static final String SQL_CONSULTAR = "SELECT \"id\", \"Ciudad_id\", \"Nombre\", \"Nit\", \"Direccion\", \"EsActiva\" "
			+ "FROM saraitel.\"Sede\"";

	private static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Sede\" "
			+ "SET \"Ciudad_id\" = ?, \"Nombre\" = ?, \"Nit\" = ?, " + "\"Direccion\" = ?, \"EsActiva\" = ? "
			+ "WHERE \"id\" = ?";

	public SedePostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final SedeEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear sede", entidad.getId().toString(),
				entidad.getCiudad().getId().toString(), entidad.getNombre(), entidad.getNit(), entidad.getDireccion(),
				entidad.getEsActiva());
	}

	@Override
	public SedeEntidad consultarPorId(final UUID id) {
		var filtro = new SedeEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new SedeEntidad() : resultados.get(0);
	}

	@Override
	public List<SedeEntidad> consultarPorFiltro(final SedeEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new SedeEntidad());

		var consulta = new FiltroSql(SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Ciudad_id\"", filtroSeguro.getCiudad().getId())
				.conTexto("\"Nombre\"", filtroSeguro.getNombre()).conTexto("\"Nit\"", filtroSeguro.getNit())
				.conTexto("\"Direccion\"", filtroSeguro.getDireccion())
				.conBooleano("\"EsActiva\"", filtroSeguro.getEsActiva(), true);

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				"Error al consultar sedes.");
	}

	@Override
	public List<SedeEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar sedes.");
	}

	@Override
	public void actualizar(final UUID id, final SedeEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, "Error al actualizar sede.", entidad.getCiudad().getId().toString(),
				entidad.getNombre(), entidad.getNit(), entidad.getDireccion(), entidad.getEsActiva(), id.toString());
	}

	private SedeEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new SedeEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("Nombre"));
		entidad.setNit(resultados.getString("Nit"));
		entidad.setDireccion(resultados.getString("Direccion"));
		entidad.setEsActiva(resultados.getBoolean("EsActiva"));

		var ciudad = new CiudadEntidad();
		ciudad.setId(leerUUID(resultados, "Ciudad_id"));
		entidad.setCiudad(ciudad);

		return entidad;
	}
}
