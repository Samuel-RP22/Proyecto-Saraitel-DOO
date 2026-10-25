
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteRegistradoNDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoNEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PrefijoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.TipoDocumentoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteRegistradoNPostgreSqlDAO extends SqlDAO implements ClienteRegistradoNDAO {

	private static final String SQL_INSERTAR = "INSERT INTO saraitel.\"ClienteRegistradoN\" "
			+ "(\"id\", \"ClienteRegistrado_id\", \"Persona_id\") " + "VALUES (?, ?, ?)";

	// Tabla derivada: permite filtrar por las columnas de siempre y trae los datos de la persona
	// y el id del cliente, necesarios para mostrar el nombre en la interfaz.
	private static final String SQL_CONSULTAR = "SELECT * FROM (SELECT n.\"id\", n.\"ClienteRegistrado_id\", "
			+ "n.\"Persona_id\", cr.\"Cliente_id\", p.\"TipoDocumento_id\", p.\"Prefijo_id\", "
			+ "p.\"NumeroDocumento\", p.\"Telefono\", p.\"Nombre\", p.\"Apellido\", p.\"Correo\" "
			+ "FROM saraitel.\"ClienteRegistradoN\" n "
			+ "JOIN saraitel.\"ClienteRegistrado\" cr ON cr.\"id\" = n.\"ClienteRegistrado_id\" "
			+ "JOIN saraitel.\"Persona\" p ON p.\"id\" = n.\"Persona_id\") AS clientes_naturales";

	private static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"ClienteRegistradoN\" " + "WHERE \"id\" = ?";

	public ClienteRegistradoNPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ClienteRegistradoNEntidad entidad) {
		ejecutarActualizacion(SQL_INSERTAR, "Error al crear cliente registrado.",
				"Error NO CONTROLADO al crear cliente registrado.", entidad.getId(),
				entidad.getClienteRegistrado().getId(), entidad.getPersona().getId());
	}

	@Override
	public ClienteRegistradoNEntidad consultarPorId(final UUID id) {
		var filtro = new ClienteRegistradoNEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new ClienteRegistradoNEntidad() : resultados.get(0);
	}

	@Override
	public List<ClienteRegistradoNEntidad> consultarPorFiltro(final ClienteRegistradoNEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new ClienteRegistradoNEntidad());

		var consulta = new FiltroSql(SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conId("\"ClienteRegistrado_id\"", filtroSeguro.getClienteRegistrado().getId())
				.conId("\"Persona_id\"", filtroSeguro.getPersona().getId());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				"Error al consultar clientes registrados.", "Error NO CONTROLADO al consultar clientes registrados.");
	}

	@Override
	public List<ClienteRegistradoNEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar clientes registrados.",
				"Error NO CONTROLADO al consultar clientes registrados.");
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, "Error al eliminar cliente registrado.",
				"Error NO CONTROLADO al eliminar cliente registrado.", id);
	}

	private ClienteRegistradoNEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new ClienteRegistradoNEntidad();
		entidad.setId(leerUUID(resultados, "id"));

		var cliente = new ClienteEntidad(leerUUID(resultados, "Cliente_id"), true);
		var clienteRegistrado = new ClienteRegistradoEntidad(leerUUID(resultados, "ClienteRegistrado_id"), cliente,
				true);
		entidad.setClienteRegistrado(clienteRegistrado);

		var tipoDocumento = new TipoDocumentoEntidad();
		tipoDocumento.setId(leerUUID(resultados, "TipoDocumento_id"));

		var prefijo = new PrefijoEntidad();
		prefijo.setId(leerUUID(resultados, "Prefijo_id"));

		var persona = new PersonaEntidad();
		persona.setId(leerUUID(resultados, "Persona_id"));
		persona.setTipoDocumento(tipoDocumento);
		persona.setPrefijo(prefijo);
		persona.setNumeroDocumento(resultados.getString("NumeroDocumento"));
		persona.setTelefono(resultados.getString("Telefono"));
		persona.setNombre(resultados.getString("Nombre"));
		persona.setApellido(resultados.getString("Apellido"));
		persona.setCorreo(resultados.getString("Correo"));
		entidad.setPersona(persona);

		return entidad;
	}
}
