
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SedeDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.CiudadEntidad;
import co.com.saraitel.gestionsaraitel.entidad.SedeEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class SedePostgreSqlDAO extends SqlDAO implements SedeDAO {

	public SedePostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final SedeEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.SedePostgreSqlDAO.SQL_CREAR, CatalogoMensajesSql.SedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_SEDE,
				CatalogoMensajesSql.SedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_SEDE, entidad.getId(),
				entidad.getCiudad().getId(), entidad.getNombre(), entidad.getNit(), entidad.getDireccion(),
				entidad.getEsActiva());
	}

	@Override
	public SedeEntidad consultarPorId(final UUID id) {
		var filtro = new SedeEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new SedeEntidad());
	}

	@Override
	public List<SedeEntidad> consultarPorFiltro(final SedeEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new SedeEntidad());

		var consulta = new FiltroSql(CatalogoMensajesSql.SedePostgreSqlDAO.SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Ciudad_id\"", filtroSeguro.getCiudad().getId())
				.conTexto("\"Nombre\"", filtroSeguro.getNombre()).conTexto("\"Nit\"", filtroSeguro.getNit())
				.conTexto("\"Direccion\"", filtroSeguro.getDireccion())
				.conBooleano("\"EsActiva\"", filtroSeguro.getEsActiva(), true);

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajesSql.SedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_SEDES,
				CatalogoMensajesSql.SedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SEDES);
	}

	@Override
	public List<SedeEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.SedePostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear, CatalogoMensajesSql.SedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_SEDES,
				CatalogoMensajesSql.SedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SEDES);
	}

	@Override
	public void actualizar(final UUID id, final SedeEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.SedePostgreSqlDAO.SQL_ACTUALIZAR, CatalogoMensajesSql.SedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_SEDE,
				CatalogoMensajesSql.SedePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_SEDE, entidad.getCiudad().getId(),
				entidad.getNombre(), entidad.getNit(), entidad.getDireccion(), entidad.getEsActiva(), id);
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
