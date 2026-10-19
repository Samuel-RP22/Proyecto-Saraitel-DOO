
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ProductoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.CategoriaEntidad;
import co.com.saraitel.gestionsaraitel.entidad.MarcaEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProductoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ProductoPostgreSqlDAO extends SqlDAO implements ProductoDAO {

	private static final String SQL_INSERTAR = "INSERT INTO saraitel.\"Producto\" "
			+ "(\"id\", \"Marca_id\", \"Categoria_id\", " + "\"Modelo\", \"Nombre\", \"Descripcion\") "
			+ "VALUES (?, ?, ?, ?, ?, ?)";

	private static final String SQL_CONSULTAR = "SELECT \"id\", \"Marca_id\", \"Categoria_id\", "
			+ "\"Modelo\", \"Nombre\", \"Descripcion\" " + "FROM saraitel.\"Producto\"";

	private static final String SQL_ACTUALIZAR = "UPDATE saraitel.\"Producto\" "
			+ "SET \"Marca_id\" = ?, \"Categoria_id\" = ?, " + "\"Modelo\" = ?, \"Nombre\" = ?, \"Descripcion\" = ? "
			+ "WHERE \"id\" = ?";

	public ProductoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ProductoEntidad entidad) {
		ejecutarActualizacion(SQL_INSERTAR, "Error al crear el producto.", entidad.getId().toString(),
				entidad.getMarca().getId().toString(), entidad.getCategoria().getId().toString(), entidad.getModelo(),
				entidad.getNombre(), entidad.getDescripcion());
	}

	@Override
	public ProductoEntidad consultarPorId(final UUID id) {
		var filtro = new ProductoEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new ProductoEntidad() : resultados.get(0);
	}

	@Override
	public List<ProductoEntidad> consultarPorFiltro(final ProductoEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new ProductoEntidad());

		var sentencia = new FiltroSql(SQL_CONSULTAR);

		sentencia.conId("\"id\"", filtroSeguro.getId());
		sentencia.conId("\"Marca_id\"", filtroSeguro.getMarca().getId());
		sentencia.conId("\"Categoria_id\"", filtroSeguro.getCategoria().getId());
		sentencia.conTexto("\"Modelo\"", filtroSeguro.getModelo());
		sentencia.conTexto("\"Nombre\"", filtroSeguro.getNombre());
		sentencia.conTexto("\"Descripcion\"", filtroSeguro.getDescripcion());

		return ejecutarConsulta(sentencia.getSentencia(), sentencia.getParametros(), this::mapear,
				"Error al consultar productos.");
	}

	@Override
	public List<ProductoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar productos.");
	}

	@Override
	public void actualizar(final UUID id, final ProductoEntidad entidad) {

		ejecutarActualizacion(SQL_ACTUALIZAR, "Error al actualizar el producto.", entidad.getMarca().getId().toString(),
				entidad.getCategoria().getId().toString(), entidad.getModelo(), entidad.getNombre(),
				entidad.getDescripcion(), id.toString());
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
