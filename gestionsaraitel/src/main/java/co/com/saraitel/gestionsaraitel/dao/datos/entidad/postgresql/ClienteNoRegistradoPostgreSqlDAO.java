
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteNoRegistradoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteNoRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteNoRegistradoPostgreSqlDAO extends SqlDAO implements ClienteNoRegistradoDAO {

	private static final String SQL_INSERTAR = "INSERT INTO saraitel.\"ClienteNoRegistrado\" "
			+ "(\"id\", \"Cliente_id\") VALUES (?, ?)";

	private static final String SQL_CONSULTAR = "SELECT \"id\", \"Cliente_id\" "
			+ "FROM saraitel.\"ClienteNoRegistrado\"";

	public ClienteNoRegistradoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ClienteNoRegistradoEntidad entidad) {
		ejecutarActualizacion(SQL_INSERTAR, "Error al crear cliente no registrado.", entidad.getId().toString(),
				entidad.getCliente().getId().toString());
	}

	@Override
	public ClienteNoRegistradoEntidad consultarPorId(final UUID id) {
		var filtro = new ClienteNoRegistradoEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new ClienteNoRegistradoEntidad() : resultados.get(0);
	}

	@Override
	public List<ClienteNoRegistradoEntidad> consultarPorFiltro(final ClienteNoRegistradoEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro,
				new ClienteNoRegistradoEntidad());

		var consulta = new FiltroSql(SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId()).conId("\"Cliente_id\"",
				filtroSeguro.getCliente().getId());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				"Error al consultar clientes no registrados.");
	}

	@Override
	public List<ClienteNoRegistradoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar clientes no registrados.");
	}

	private ClienteNoRegistradoEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new ClienteNoRegistradoEntidad();
		entidad.setId(leerUUID(resultados, "id"));

		var cliente = new ClienteEntidad();
		cliente.setId(leerUUID(resultados, "Cliente_id"));
		entidad.setCliente(cliente);

		return entidad;
	}
}
