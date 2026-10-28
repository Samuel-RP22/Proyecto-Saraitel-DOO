package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PaisDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.PaisEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PaisPostgreSqlDAO extends SqlDAO implements PaisDAO {

	public PaisPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final PaisEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.PaisPostgreSqlDAO.SQL_CREAR, CatalogoMensajesSql.PaisPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_PAIS, CatalogoMensajesSql.PaisPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PAIS,
				entidad.getId(), entidad.getNombre());
	}

	@Override
	public PaisEntidad consultarPorId(final UUID id) {
		List<PaisEntidad> resultado = ejecutarConsulta(CatalogoMensajesSql.PaisPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id), this::mapear,
				CatalogoMensajesSql.PaisPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAIS, CatalogoMensajesSql.PaisPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAIS);

		return obtenerPrimeroOValorDefecto(resultado, new PaisEntidad());
	}

	@Override
	public List<PaisEntidad> consultarPorFiltro(final PaisEntidad filtro) {

		PaisEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new PaisEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoMensajesSql.PaisPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conTexto("\"Nombre\"", filtroSeguro.getNombre());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajesSql.PaisPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAISES, CatalogoMensajesSql.PaisPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAISES);
	}

	@Override
	public List<PaisEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.PaisPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear, CatalogoMensajesSql.PaisPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAISES,
				CatalogoMensajesSql.PaisPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAISES);
	}

	@Override
	public void actualizar(final UUID id, final PaisEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.PaisPostgreSqlDAO.SQL_ACTUALIZAR, CatalogoMensajesSql.PaisPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_PAIS,
				CatalogoMensajesSql.PaisPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_PAIS, entidad.getNombre(), id);
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(CatalogoMensajesSql.PaisPostgreSqlDAO.SQL_ELIMINAR, CatalogoMensajesSql.PaisPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ELIMINANDO_PAIS, CatalogoMensajesSql.PaisPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_PAIS, id);
	}

	private PaisEntidad mapear(final ResultSet resultados) throws SQLException {

		PaisEntidad entidad = new PaisEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("Nombre"));

		return entidad;
	}
}
