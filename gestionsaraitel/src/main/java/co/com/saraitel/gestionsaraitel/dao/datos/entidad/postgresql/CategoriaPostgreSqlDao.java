
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.CategoriaDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.CategoriaEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class CategoriaPostgreSqlDao extends SqlDAO
        implements CategoriaDAO {

    private static final String SQL_INSERTAR =
            "INSERT INTO saraitel.\"Categoria\" "
            + "(\"id\", \"Nombre\", \"CategoriaPadre_id\", \"Nivel\") "
            + "VALUES (?, ?, ?, ?)";

    private static final String SQL_CONSULTAR =
            "SELECT \"id\", \"Nombre\", \"CategoriaPadre_id\", \"Nivel\" "
            + "FROM saraitel.\"Categoria\"";

    private static final String SQL_ACTUALIZAR =
            "UPDATE saraitel.\"Categoria\" "
            + "SET \"Nombre\" = ?, \"CategoriaPadre_id\" = ?, \"Nivel\" = ? "
            + "WHERE \"id\" = ?";

    private static final String SQL_ELIMINAR =
            "DELETE FROM saraitel.\"Categoria\" WHERE \"id\" = ?";

    public CategoriaPostgreSqlDao(final Connection conexion) {
        super(conexion);
    }

    @Override
    public void crear(final CategoriaEntidad entidad) {
        ejecutarActualizacion(
                SQL_INSERTAR,
                "Error al crear la categoría.",
                entidad.getId().toString(),
                entidad.getNombre(),
                entidad.getIdCategoriaPadre() == null
                        ? null
                        : entidad.getIdCategoriaPadre().toString(),
                entidad.getNivel()
        );
    }

    @Override
    public CategoriaEntidad consultarPorId(final UUID id) {
        var filtro = new CategoriaEntidad();
        filtro.setId(id);

        var resultados = consultarPorFiltro(filtro);

        return resultados.isEmpty()
                ? new CategoriaEntidad()
                : resultados.get(0);
    }

    @Override
    public List<CategoriaEntidad> consultarPorFiltro(
            final CategoriaEntidad filtro) {

        var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                filtro, new CategoriaEntidad());

        var sentencia = new FiltroSql(SQL_CONSULTAR);

        sentencia.conId("\"id\"", filtroSeguro.getId());
        sentencia.conTexto("\"Nombre\"", filtroSeguro.getNombre());
        sentencia.conId("\"CategoriaPadre_id\"",
                filtroSeguro.getIdCategoriaPadre());
        sentencia.conEntero("\"Nivel\"", filtroSeguro.getNivel());

        return ejecutarConsulta(
                sentencia.getSentencia(),
                sentencia.getParametros(),
                this::mapear,
                "Error al consultar categorías."
        );
    }

    @Override
    public List<CategoriaEntidad> consultarTodos() {
        return ejecutarConsulta(
                SQL_CONSULTAR,
                List.of(),
                this::mapear,
                "Error al consultar categorías."
        );
    }

    @Override
    public void actualizar(final UUID id, final CategoriaEntidad entidad) {
        ejecutarActualizacion(
                SQL_ACTUALIZAR,
                "Error al actualizar la categoría.",
                entidad.getNombre(),
                entidad.getIdCategoriaPadre() == null
                        ? null
                        : entidad.getIdCategoriaPadre().toString(),
                entidad.getNivel(),
                id.toString()
        );
    }

    @Override
    public void eliminar(final UUID id) {
        ejecutarActualizacion(
                SQL_ELIMINAR,
                "Error al eliminar la categoría.",
                id.toString()
        );
    }

    private CategoriaEntidad mapear(final ResultSet resultados)
            throws SQLException {

        var entidad = new CategoriaEntidad();

        entidad.setId(leerUUID(resultados, "id"));
        entidad.setNombre(resultados.getString("Nombre"));

        var idCategoriaPadre =
                resultados.getString("CategoriaPadre_id");

        if (idCategoriaPadre == null || idCategoriaPadre.isBlank()) {
            entidad.setIdCategoriaPadre(null);
        } else {
            entidad.setIdCategoriaPadre(
                    UUID.fromString(idCategoriaPadre)
            );
        }

        entidad.setNivel(resultados.getInt("Nivel"));

        return entidad;
    }
}
