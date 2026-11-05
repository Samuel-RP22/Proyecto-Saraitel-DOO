package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.CiudadDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.CiudadEntidad;
import co.com.saraitel.gestionsaraitel.entidad.DepartamentoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class CiudadPostgreSqlDAO extends SqlDAO implements CiudadDAO {

	public CiudadPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public CiudadEntidad consultarPorId(final UUID id) {
		CiudadEntidad filtro = new CiudadEntidad();
		filtro.setId(id);

		List<CiudadEntidad> resultado = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultado, new CiudadEntidad());
	}

	@Override
	public List<CiudadEntidad> consultarPorFiltro(final CiudadEntidad filtro) {

		CiudadEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new CiudadEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoSentenciasSql.CiudadPostgreSqlDAO.SQL_CONSULTAR)
				.conId("\"id\"", filtroSeguro.getId())
				.conId("\"Departamento_id\"", filtroSeguro.getDepartamento().getId())
				.conTexto("\"Nombre\"", filtroSeguro.getNombre());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajes.CiudadPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CIUDADES,
				CatalogoMensajes.CiudadPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDADES);
	}

	@Override
	public List<CiudadEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.CiudadPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.CiudadPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CIUDADES,
				CatalogoMensajes.CiudadPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDADES);
	}

	private CiudadEntidad mapear(final ResultSet resultados) throws SQLException {

		CiudadEntidad entidad = new CiudadEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("Nombre"));
		DepartamentoEntidad departamento = new DepartamentoEntidad();
		departamento.setId(leerUUID(resultados, "Departamento_id"));
		entidad.setDepartamento(departamento);

		return entidad;
	}
}
