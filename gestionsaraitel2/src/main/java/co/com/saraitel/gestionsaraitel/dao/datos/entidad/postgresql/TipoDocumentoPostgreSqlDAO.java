
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.TipoDocumentoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.TipoDocumentoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class TipoDocumentoPostgreSqlDAO extends SqlDAO implements TipoDocumentoDAO {

	public TipoDocumentoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public TipoDocumentoEntidad consultarPorId(final UUID id) {
		var filtro = new TipoDocumentoEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new TipoDocumentoEntidad());
	}

	@Override
	public List<TipoDocumentoEntidad> consultarPorFiltro(final TipoDocumentoEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new TipoDocumentoEntidad());

		var consulta = new FiltroSql(CatalogoSentenciasSql.TipoDocumentoPostgreSqlDAO.SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId()).conTexto("\"Tipo\"",
				filtroSeguro.getTipo());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.TipoDocumentoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_TIPOS_DE_DOCUMENTO,
				CatalogoMensajes.TipoDocumentoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TIPOS_DE_DOCUMENTO);
	}

	@Override
	public List<TipoDocumentoEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.TipoDocumentoPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear, CatalogoMensajes.TipoDocumentoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_TIPOS_DE_DOCUMENTO,
				CatalogoMensajes.TipoDocumentoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TIPOS_DE_DOCUMENTO);
	}

	private TipoDocumentoEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new TipoDocumentoEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setTipo(resultados.getString("Tipo"));

		return entidad;
	}
}
