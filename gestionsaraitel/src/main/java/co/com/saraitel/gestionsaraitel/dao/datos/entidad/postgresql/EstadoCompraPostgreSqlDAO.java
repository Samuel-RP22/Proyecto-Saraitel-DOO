
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EstadoCompraDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.EstadoCompraEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EstadoCompraPostgreSqlDAO extends SqlDAO implements EstadoCompraDAO {

	public EstadoCompraPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final EstadoCompraEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.EstadoCompraPostgreSqlDAO.SQL_CREAR, CatalogoMensajes.EstadoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_ESTADO_DE_COMPRA,
				CatalogoMensajes.EstadoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_ESTADO_DE_COMPRA, entidad.getId(),
				entidad.getCodigo(), entidad.getNombre());
	}

	@Override
	public EstadoCompraEntidad consultarPorId(final UUID id) {
		List<EstadoCompraEntidad> resultado = ejecutarConsulta(CatalogoSentenciasSql.EstadoCompraPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, CatalogoMensajes.EstadoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADO_DE_COMPRA,
				CatalogoMensajes.EstadoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADO_DE_COMPRA);

		return obtenerPrimeroOValorDefecto(resultado, new EstadoCompraEntidad());
	}

	@Override
	public List<EstadoCompraEntidad> consultarPorFiltro(final EstadoCompraEntidad filtro) {

		EstadoCompraEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new EstadoCompraEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoSentenciasSql.EstadoCompraPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conTexto("\"Codigo\"", filtroSeguro.getCodigo()).conTexto("\"Nombre\"", filtroSeguro.getNombre());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajes.EstadoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADOS_DE_COMPRA,
				CatalogoMensajes.EstadoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_DE_COMPRA);
	}

	@Override
	public List<EstadoCompraEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.EstadoCompraPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear,
				CatalogoMensajes.EstadoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADOS_DE_COMPRA,
				CatalogoMensajes.EstadoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_DE_COMPRA);
	}

	private EstadoCompraEntidad mapear(final ResultSet resultados) throws SQLException {

		EstadoCompraEntidad entidad = new EstadoCompraEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setCodigo(resultados.getString("Codigo"));
		entidad.setNombre(resultados.getString("Nombre"));

		return entidad;
	}
}
