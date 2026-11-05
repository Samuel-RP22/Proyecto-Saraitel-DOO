package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.AdministradorDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.AdministradorEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class AdministradorPostgreSqlDAO extends SqlDAO implements AdministradorDAO {

	public AdministradorPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final AdministradorEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.AdministradorPostgreSqlDAO.SQL_CREAR,
				CatalogoMensajes.AdministradorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_ADMINISTRADOR,
				CatalogoMensajes.AdministradorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_ADMINISTRADOR,
				entidad.getId(), entidad.getEmpleado().getId());
	}

	@Override
	public AdministradorEntidad consultarPorId(final UUID id) {
		AdministradorEntidad filtro = new AdministradorEntidad();
		filtro.setId(id);

		List<AdministradorEntidad> resultado = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultado, new AdministradorEntidad());
	}

	@Override
	public List<AdministradorEntidad> consultarPorFiltro(final AdministradorEntidad filtro) {

		AdministradorEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro,
				new AdministradorEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoSentenciasSql.AdministradorPostgreSqlDAO.SQL_CONSULTAR)
				.conId("\"id\"", filtroSeguro.getId()).conId("\"Empleado_id\"", filtroSeguro.getEmpleado().getId());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajes.AdministradorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ADMINISTRADORES,
				CatalogoMensajes.AdministradorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ADMINISTRADORES);
	}

	@Override
	public List<AdministradorEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.AdministradorPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.AdministradorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ADMINISTRADORES,
				CatalogoMensajes.AdministradorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ADMINISTRADORES);
	}

	private AdministradorEntidad mapear(final ResultSet resultados) throws SQLException {

		AdministradorEntidad entidad = new AdministradorEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		EmpleadoEntidad empleado = new EmpleadoEntidad();
		empleado.setId(leerUUID(resultados, "Empleado_id"));
		entidad.setEmpleado(empleado);

		return entidad;
	}
}
