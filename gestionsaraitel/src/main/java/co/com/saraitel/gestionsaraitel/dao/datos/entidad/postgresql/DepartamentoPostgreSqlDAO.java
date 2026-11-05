package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DepartamentoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.DepartamentoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PaisEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class DepartamentoPostgreSqlDAO extends SqlDAO implements DepartamentoDAO {

	public DepartamentoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public DepartamentoEntidad consultarPorId(final UUID id) {
		DepartamentoEntidad filtro = new DepartamentoEntidad();
		filtro.setId(id);

		List<DepartamentoEntidad> resultado = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultado, new DepartamentoEntidad());
	}

	@Override
	public List<DepartamentoEntidad> consultarPorFiltro(final DepartamentoEntidad filtro) {

		DepartamentoEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro,
				new DepartamentoEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoSentenciasSql.DepartamentoPostgreSqlDAO.SQL_CONSULTAR)
				.conId("\"id\"", filtroSeguro.getId()).conId("\"Pais_id\"", filtroSeguro.getPais().getId())
				.conTexto("\"Nombre\"", filtroSeguro.getNombre());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajes.DepartamentoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_DEPARTAMENTOS,
				CatalogoMensajes.DepartamentoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEPARTAMENTOS);
	}

	@Override
	public List<DepartamentoEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.DepartamentoPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.DepartamentoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_DEPARTAMENTOS,
				CatalogoMensajes.DepartamentoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEPARTAMENTOS);
	}

	private DepartamentoEntidad mapear(final ResultSet resultados) throws SQLException {

		DepartamentoEntidad entidad = new DepartamentoEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("Nombre"));
		PaisEntidad pais = new PaisEntidad();
		pais.setId(leerUUID(resultados, "Pais_id"));
		entidad.setPais(pais);

		return entidad;
	}
}
