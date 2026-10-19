
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteRegistradoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteRegistradoPostgreSqlDAO extends SqlDAO implements ClienteRegistradoDAO {

	private static final String SQL_INSERTAR = "INSERT INTO saraitel.\"ClienteRegistrado\" "
			+ "(\"id\", \"Cliente_id\") VALUES (?, ?)";

	private static final String SQL_CONSULTAR = "SELECT \"id\", \"Cliente_id\" "
			+ "FROM saraitel.\"ClienteRegistrado\"";

	private static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"ClienteRegistrado\" " + "WHERE \"id\" = ?";

	public ClienteRegistradoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ClienteRegistradoEntidad entidad) {
		ejecutarActualizacion(SQL_INSERTAR, "Error al crear cliente registrado.",
				"Error NO CONTROLADO al crear cliente registrado.", entidad.getId(),
				entidad.getCliente().getId());
	}

	@Override
	public ClienteRegistradoEntidad consultarPorId(final UUID id) {
		var filtro = new ClienteRegistradoEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new ClienteRegistradoEntidad() : resultados.get(0);
	}

	@Override
	public List<ClienteRegistradoEntidad> consultarPorFiltro(final ClienteRegistradoEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new ClienteRegistradoEntidad());

		var consulta = new FiltroSql(SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId()).conId("\"Cliente_id\"",
				filtroSeguro.getCliente().getId());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				"Error al consultar clientes registrados.",
				"Error NO CONTROLADO al consultar clientes registrados.");
	}

	@Override
	public List<ClienteRegistradoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar clientes registrados.",
				"Error NO CONTROLADO al consultar clientes registrados.");
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, "Error al eliminar cliente registrado.",
				"Error NO CONTROLADO al eliminar cliente registrado.", id);
	}

	private ClienteRegistradoEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new ClienteRegistradoEntidad();
		entidad.setId(leerUUID(resultados, "id"));

		var cliente = new ClienteEntidad();
		cliente.setId(leerUUID(resultados, "Cliente_id"));
		entidad.setCliente(cliente);

		return entidad;
	}
}
