
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ProductoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.CategoriaEntidad;
import co.com.saraitel.gestionsaraitel.entidad.MarcaEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProductoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ProductoPostgreSqlDAO extends SqlDAO implements ProductoDAO {

	public ProductoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ProductoEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.ProductoPostgreSqlDAO.SQL_INSERTAR, CatalogoMensajesSql.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_PRODUCTO,
				CatalogoMensajesSql.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PRODUCTO, entidad.getId(),
				entidad.getMarca().getId(), entidad.getCategoria().getId(), entidad.getModelo(),
				entidad.getNombre(), entidad.getDescripcion());
	}

	@Override
	public ProductoEntidad consultarPorId(final UUID id) {
		var filtro = new ProductoEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new ProductoEntidad());
	}

	@Override
	public List<ProductoEntidad> consultarPorFiltro(final ProductoEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new ProductoEntidad());

		var sentencia = new FiltroSql(CatalogoMensajesSql.ProductoPostgreSqlDAO.SQL_CONSULTAR);

		sentencia.conId("\"id\"", filtroSeguro.getId());
		sentencia.conId("\"Marca_id\"", filtroSeguro.getMarca().getId());
		sentencia.conId("\"Categoria_id\"", filtroSeguro.getCategoria().getId());
		sentencia.conTexto("\"Modelo\"", filtroSeguro.getModelo());
		sentencia.conTexto("\"Nombre\"", filtroSeguro.getNombre());
		sentencia.conTexto("\"Descripcion\"", filtroSeguro.getDescripcion());

		return ejecutarConsulta(sentencia.getSentencia(), sentencia.getParametros(), this::mapear,
				CatalogoMensajesSql.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PRODUCTOS,
				CatalogoMensajesSql.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTOS);
	}

	@Override
	public List<ProductoEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.ProductoPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear, CatalogoMensajesSql.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PRODUCTOS,
				CatalogoMensajesSql.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTOS);
	}

	@Override
	public void actualizar(final UUID id, final ProductoEntidad entidad) {

		ejecutarActualizacion(CatalogoMensajesSql.ProductoPostgreSqlDAO.SQL_ACTUALIZAR, CatalogoMensajesSql.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_PRODUCTO,
				CatalogoMensajesSql.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_PRODUCTO, entidad.getMarca().getId(),
				entidad.getCategoria().getId(), entidad.getModelo(), entidad.getNombre(),
				entidad.getDescripcion(), id);
	}

	private ProductoEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new ProductoEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		var marca = new MarcaEntidad();
		marca.setId(leerUUID(resultados, "Marca_id"));
		entidad.setMarca(marca);

		var categoria = new CategoriaEntidad();
		categoria.setId(leerUUID(resultados, "Categoria_id"));
		entidad.setCategoria(categoria);

		entidad.setModelo(resultados.getString("Modelo"));
		entidad.setNombre(resultados.getString("Nombre"));
		entidad.setDescripcion(resultados.getString("Descripcion"));

		return entidad;
	}
}
