
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EstadoInventarioDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.EstadoInventarioEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EstadoInventarioPostgreSqlDAO extends SqlDAO implements EstadoInventarioDAO {

	public EstadoInventarioPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final EstadoInventarioEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.EstadoInventarioPostgreSqlDAO.SQL_CREAR, CatalogoMensajes.EstadoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_ESTADO_DEL_INVENTARIO,
				CatalogoMensajes.EstadoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_ESTADO_DEL_INVENTARIO, entidad.getId(),
				entidad.getCodigo(), entidad.getNombre());
	}

	@Override
	public EstadoInventarioEntidad consultarPorId(final UUID id) {
		List<EstadoInventarioEntidad> resultado = ejecutarConsulta(CatalogoSentenciasSql.EstadoInventarioPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, CatalogoMensajes.EstadoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADO_DEL_INVENTARIO,
				CatalogoMensajes.EstadoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADO_DEL_INVENTARIO);

		return obtenerPrimeroOValorDefecto(resultado, new EstadoInventarioEntidad());
	}

	@Override
	public List<EstadoInventarioEntidad> consultarPorFiltro(final EstadoInventarioEntidad filtro) {

		EstadoInventarioEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new EstadoInventarioEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoSentenciasSql.EstadoInventarioPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conTexto("\"Codigo\"", filtroSeguro.getCodigo()).conTexto("\"Nombre\"", filtroSeguro.getNombre());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajes.EstadoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADOS_DEL_INVENTARIO,
				CatalogoMensajes.EstadoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_DEL_INVENTARIO);
	}

	@Override
	public List<EstadoInventarioEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.EstadoInventarioPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear,
				CatalogoMensajes.EstadoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADOS_DEL_INVENTARIO,
				CatalogoMensajes.EstadoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_DEL_INVENTARIO);
	}

	private EstadoInventarioEntidad mapear(final ResultSet resultados) throws SQLException {

		EstadoInventarioEntidad entidad = new EstadoInventarioEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setCodigo(resultados.getString("Codigo"));
		entidad.setNombre(resultados.getString("Nombre"));

		return entidad;
	}
}
