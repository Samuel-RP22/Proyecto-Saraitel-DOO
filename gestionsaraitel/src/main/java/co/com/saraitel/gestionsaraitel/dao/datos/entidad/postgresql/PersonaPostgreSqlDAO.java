
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PersonaDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PrefijoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.TipoDocumentoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PersonaPostgreSqlDAO extends SqlDAO implements PersonaDAO {

	private static final String SQL_INSERTAR = "INSERT INTO saraitel.\"Persona\" "
			+ "(\"id\", \"TipoDocumento_id\", \"Prefijo_id\", " + "\"NumeroDocumento\", \"Telefono\", \"Nombre\", "
			+ "\"Apellido\", \"Correo\", \"TelefonoConfirmado\", "
			+ "\"CorreoConfirmado\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String SQL_CONSULTAR = "SELECT \"id\", \"TipoDocumento_id\", \"Prefijo_id\", "
			+ "\"NumeroDocumento\", \"Telefono\", \"Nombre\", " + "\"Apellido\", \"Correo\", \"TelefonoConfirmado\", "
			+ "\"CorreoConfirmado\" FROM saraitel.\"Persona\"";

	private static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Persona\" SET "
			+ "\"TipoDocumento_id\" = ?, \"Prefijo_id\" = ?, " + "\"NumeroDocumento\" = ?, \"Telefono\" = ?, "
			+ "\"Nombre\" = ?, \"Apellido\" = ?, \"Correo\" = ?, "
			+ "\"TelefonoConfirmado\" = ?, \"CorreoConfirmado\" = ? " + "WHERE \"id\" = ?";

	private static final String SQL_ELIMINAR = "DELETE FROM saraitel.\"Persona\" WHERE \"id\" = ?";

	public PersonaPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final PersonaEntidad entidad) {
		ejecutarActualizacion(SQL_INSERTAR, "Error al crear persona.",
				"Error NO CONTROLADO al crear persona.", entidad.getId(),
				entidad.getTipoDocumento().getId(), entidad.getPrefijo().getId(),
				entidad.getNumeroDocumento(), entidad.getTelefono(), entidad.getNombre(), entidad.getApellido(),
				entidad.getCorreo(), entidad.getTelefonoConfirmado(), entidad.getCorreoConfirmado());
	}

	@Override
	public PersonaEntidad consultarPorId(final UUID id) {
		var filtro = new PersonaEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new PersonaEntidad() : resultados.get(0);
	}

	@Override
	public List<PersonaEntidad> consultarPorFiltro(final PersonaEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new PersonaEntidad());

		var consulta = new FiltroSql(SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conId("\"TipoDocumento_id\"", filtroSeguro.getTipoDocumento().getId())
				.conId("\"Prefijo_id\"", filtroSeguro.getPrefijo().getId())
				.conTexto("\"NumeroDocumento\"", filtroSeguro.getNumeroDocumento())
				.conTexto("\"Telefono\"", filtroSeguro.getTelefono()).conTexto("\"Nombre\"", filtroSeguro.getNombre())
				.conTexto("\"Apellido\"", filtroSeguro.getApellido()).conTexto("\"Correo\"", filtroSeguro.getCorreo())
				.conBooleano("\"TelefonoConfirmado\"", filtroSeguro.getTelefonoConfirmado(), false)
				.conBooleano("\"CorreoConfirmado\"", filtroSeguro.getCorreoConfirmado(), false);

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				"Error al consultar personas.",
				"Error NO CONTROLADO al consultar personas.");
	}

	@Override
	public List<PersonaEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar personas.",
				"Error NO CONTROLADO al consultar personas.");
	}

	@Override
	public void actualizar(final UUID id, final PersonaEntidad entidad) {
		ejecutarActualizacion(SQL_ACTUALIZAR, "Error al actualizar persona.",
				"Error NO CONTROLADO al actualizar persona.",
				entidad.getTipoDocumento().getId(), entidad.getPrefijo().getId(),
				entidad.getNumeroDocumento(), entidad.getTelefono(), entidad.getNombre(), entidad.getApellido(),
				entidad.getCorreo(), entidad.getTelefonoConfirmado(), entidad.getCorreoConfirmado(), id);
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(SQL_ELIMINAR, "Error al eliminar persona.",
				"Error NO CONTROLADO al eliminar persona.", id);
	}

	private PersonaEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new PersonaEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		var tipoDocumento = new TipoDocumentoEntidad();
		tipoDocumento.setId(leerUUID(resultados, "TipoDocumento_id"));
		entidad.setTipoDocumento(tipoDocumento);

		var prefijo = new PrefijoEntidad();
		prefijo.setId(leerUUID(resultados, "Prefijo_id"));
		entidad.setPrefijo(prefijo);

		entidad.setNumeroDocumento(resultados.getString("NumeroDocumento"));
		entidad.setTelefono(resultados.getString("Telefono"));
		entidad.setNombre(resultados.getString("Nombre"));
		entidad.setApellido(resultados.getString("Apellido"));
		entidad.setCorreo(resultados.getString("Correo"));
		entidad.setTelefonoConfirmado(resultados.getBoolean("TelefonoConfirmado"));
		entidad.setCorreoConfirmado(resultados.getBoolean("CorreoConfirmado"));

		return entidad;
	}
}
