
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
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EmpleadoPostgreSqlDAO extends SqlDAO implements EmpleadoDAO {

	public EmpleadoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final EmpleadoEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.EmpleadoPostgreSqlDAO.SQL_CREAR, CatalogoMensajes.EmpleadoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_EMPLEADO,
				CatalogoMensajes.EmpleadoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_EMPLEADO, entidad.getId(),
				entidad.getSede().getId(), entidad.getPersona().getId(), entidad.getEsActivo());
	}

	@Override
	public EmpleadoEntidad consultarPorId(final UUID id) {
		var filtro = new EmpleadoEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new EmpleadoEntidad());
	}

	@Override
	public List<EmpleadoEntidad> consultarPorFiltro(final EmpleadoEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new EmpleadoEntidad());

		var consulta = new FiltroSql(CatalogoSentenciasSql.EmpleadoPostgreSqlDAO.SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Sede_id\"", filtroSeguro.getSede().getId())
				.conId("\"Persona_id\"", filtroSeguro.getPersona().getId())
				.conTextoIgnorandoMayusculas("\"Correo\"", filtroSeguro.getPersona().getCorreo())
				.conBooleano("\"EsActivo\"", filtroSeguro.getEsActivo(), true);

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.EmpleadoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_EMPLEADOS,
				CatalogoMensajes.EmpleadoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_EMPLEADOS);
	}

	@Override
	public List<EmpleadoEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.EmpleadoPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear, CatalogoMensajes.EmpleadoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_EMPLEADOS,
				CatalogoMensajes.EmpleadoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_EMPLEADOS);
	}

	@Override
	public void actualizar(final UUID id, final EmpleadoEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.EmpleadoPostgreSqlDAO.SQL_ACTUALIZAR, CatalogoMensajes.EmpleadoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_EMPLEADO,
				CatalogoMensajes.EmpleadoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_EMPLEADO, entidad.getSede().getId(),
				entidad.getPersona().getId(), entidad.getEsActivo(), id);
	}

	private EmpleadoEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new EmpleadoEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setEsActivo(resultados.getBoolean("EsActivo"));

		var sede = new SedeEntidad();
		sede.setId(leerUUID(resultados, "Sede_id"));
		sede.setNombre(resultados.getString("NombreSede"));
		entidad.setSede(sede);

		var persona = new PersonaEntidad();
		persona.setId(leerUUID(resultados, "Persona_id"));
		persona.setNumeroDocumento(resultados.getString("NumeroDocumento"));
		persona.setNombre(resultados.getString("Nombre"));
		persona.setApellido(resultados.getString("Apellido"));
		persona.setCorreo(resultados.getString("Correo"));
		entidad.setPersona(persona);

		return entidad;
	}
}
