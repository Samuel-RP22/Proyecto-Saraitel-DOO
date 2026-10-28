
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
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class CiudadPostgreSqlDAO extends SqlDAO implements CiudadDAO {

	public CiudadPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public CiudadEntidad consultarPorId(final UUID id) {
		var filtro = new CiudadEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new CiudadEntidad());
	}

	@Override
	public List<CiudadEntidad> consultarPorFiltro(final CiudadEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new CiudadEntidad());

		var consulta = new FiltroSql(CatalogoMensajesSql.CiudadPostgreSqlDAO.SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Departamento_id\"", filtroSeguro.getDepartamento().getId())
				.conTexto("\"Nombre\"", filtroSeguro.getNombre());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajesSql.CiudadPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CIUDADES,
				CatalogoMensajesSql.CiudadPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDADES);
	}

	@Override
	public List<CiudadEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.CiudadPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear, CatalogoMensajesSql.CiudadPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CIUDADES,
				CatalogoMensajesSql.CiudadPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDADES);
	}

	private CiudadEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new CiudadEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("Nombre"));

		var departamento = new DepartamentoEntidad();
		departamento.setId(leerUUID(resultados, "Departamento_id"));
		entidad.setDepartamento(departamento);

		return entidad;
	}
}
