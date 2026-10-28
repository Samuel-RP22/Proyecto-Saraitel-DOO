
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.CategoriaDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.CategoriaEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class CategoriaPostgreSqlDAO extends SqlDAO implements CategoriaDAO {

	public CategoriaPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final CategoriaEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.CategoriaPostgreSqlDAO.SQL_INSERTAR, CatalogoMensajes.CategoriaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_CATEGORIA,
				CatalogoMensajes.CategoriaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_CATEGORIA, entidad.getId(),
				entidad.getNombre(),
				entidad.getIdCategoriaPadre(),
				entidad.getNivel());
	}

	@Override
	public CategoriaEntidad consultarPorId(final UUID id) {
		var filtro = new CategoriaEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new CategoriaEntidad());
	}

	@Override
	public List<CategoriaEntidad> consultarPorFiltro(final CategoriaEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new CategoriaEntidad());

		var sentencia = new FiltroSql(CatalogoSentenciasSql.CategoriaPostgreSqlDAO.SQL_CONSULTAR);

		sentencia.conId("\"id\"", filtroSeguro.getId());
		sentencia.conTexto("\"Nombre\"", filtroSeguro.getNombre());
		sentencia.conId("\"CategoriaPadre_id\"", filtroSeguro.getIdCategoriaPadre());
		sentencia.conEntero("\"Nivel\"", filtroSeguro.getNivel());

		return ejecutarConsulta(sentencia.getSentencia(), sentencia.getParametros(), this::mapear,
				CatalogoMensajes.CategoriaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CATEGORIAS,
				CatalogoMensajes.CategoriaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CATEGORIAS);
	}

	@Override
	public List<CategoriaEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.CategoriaPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear, CatalogoMensajes.CategoriaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CATEGORIAS,
				CatalogoMensajes.CategoriaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CATEGORIAS);
	}

	@Override
	public void actualizar(final UUID id, final CategoriaEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.CategoriaPostgreSqlDAO.SQL_ACTUALIZAR, CatalogoMensajes.CategoriaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_CATEGORIA,
				CatalogoMensajes.CategoriaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_CATEGORIA, entidad.getNombre(),
				entidad.getIdCategoriaPadre(),
				entidad.getNivel(), id);
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(CatalogoSentenciasSql.CategoriaPostgreSqlDAO.SQL_ELIMINAR, CatalogoMensajes.CategoriaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ELIMINANDO_CATEGORIA,
				CatalogoMensajes.CategoriaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_CATEGORIA, id);
	}

	private CategoriaEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new CategoriaEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("Nombre"));

		var idCategoriaPadre = resultados.getString("CategoriaPadre_id");

		if (UtilTexto.esVacia(idCategoriaPadre)) {
			entidad.setIdCategoriaPadre(null);
		} else {
			entidad.setIdCategoriaPadre(UUID.fromString(idCategoriaPadre));
		}

		entidad.setNivel(resultados.getInt("Nivel"));

		return entidad;
	}
}
