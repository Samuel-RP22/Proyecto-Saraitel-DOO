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
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ProductoPostgreSqlDAO extends SqlDAO implements ProductoDAO {

	public ProductoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ProductoEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.ProductoPostgreSqlDAO.SQL_INSERTAR,
				CatalogoMensajes.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_PRODUCTO,
				CatalogoMensajes.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PRODUCTO,
				entidad.getId(), entidad.getMarca().getId(), entidad.getCategoria().getId(), entidad.getModelo(),
				entidad.getNombre(), entidad.getDescripcion());
	}

	@Override
	public ProductoEntidad consultarPorId(final UUID id) {
		ProductoEntidad filtro = new ProductoEntidad();
		filtro.setId(id);

		List<ProductoEntidad> resultado = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultado, new ProductoEntidad());
	}

	@Override
	public List<ProductoEntidad> consultarPorFiltro(final ProductoEntidad filtro) {

		ProductoEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro,
				new ProductoEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoSentenciasSql.ProductoPostgreSqlDAO.SQL_CONSULTAR)
				.conId("\"id\"", filtroSeguro.getId()).conId("\"Marca_id\"", filtroSeguro.getMarca().getId())
				.conId("\"Categoria_id\"", filtroSeguro.getCategoria().getId())
				.conTexto("\"Modelo\"", filtroSeguro.getModelo()).conTexto("\"Nombre\"", filtroSeguro.getNombre())
				.conTexto("\"Descripcion\"", filtroSeguro.getDescripcion());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajes.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PRODUCTOS,
				CatalogoMensajes.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTOS);
	}

	@Override
	public List<ProductoEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.ProductoPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PRODUCTOS,
				CatalogoMensajes.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PRODUCTOS);
	}

	@Override
	public void actualizar(final UUID id, final ProductoEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.ProductoPostgreSqlDAO.SQL_ACTUALIZAR,
				CatalogoMensajes.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_PRODUCTO,
				CatalogoMensajes.ProductoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_PRODUCTO,
				entidad.getMarca().getId(), entidad.getCategoria().getId(), entidad.getModelo(), entidad.getNombre(),
				entidad.getDescripcion(), id);
	}

	private ProductoEntidad mapear(final ResultSet resultados) throws SQLException {

		ProductoEntidad entidad = new ProductoEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		MarcaEntidad marca = new MarcaEntidad();
		marca.setId(leerUUID(resultados, "Marca_id"));
		entidad.setMarca(marca);
		CategoriaEntidad categoria = new CategoriaEntidad();
		categoria.setId(leerUUID(resultados, "Categoria_id"));
		entidad.setCategoria(categoria);
		entidad.setModelo(resultados.getString("Modelo"));
		entidad.setNombre(resultados.getString("Nombre"));
		entidad.setDescripcion(resultados.getString("Descripcion"));

		return entidad;
	}
}
