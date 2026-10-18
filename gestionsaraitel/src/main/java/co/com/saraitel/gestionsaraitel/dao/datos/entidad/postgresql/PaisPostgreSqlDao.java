
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PaisDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.PaisEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class PaisPostgreSqlDao extends SqlDAO implements PaisDAO {

    private static final String SQL_CREAR =
            "INSERT INTO saraitel.\"Pais\" (\"id\", \"Nombre\") VALUES (?, ?)";

    private static final String SQL_CONSULTAR =
            "SELECT \"id\", \"Nombre\" FROM saraitel.\"Pais\"";

    private static final String SQL_ACTUALIZAR =
            "UPDATE saraitel.\"Pais\" SET \"Nombre\" = ? WHERE \"id\" = ?";

    private static final String SQL_ELIMINAR =
            "DELETE FROM saraitel.\"Pais\" WHERE \"id\" = ?";

    public PaisPostgreSqlDao(final Connection conexion) {
        super(conexion);
    }

    @Override
    public void crear(final PaisEntidad entidad) {
        ejecutarActualizacion(
                SQL_CREAR,
                CatalogoMensajes.PostgreSqlDAO.USUARIO_ERROR_CREANDO_REGISTRO,
                entidad.getId().toString(),
                entidad.getNombre()
        );
    }

    @Override
    public PaisEntidad consultarPorId(final UUID id) {
        var filtro = new PaisEntidad();
        filtro.setId(id);

        var resultados = consultarPorFiltro(filtro);

        return resultados.isEmpty()
                ? new PaisEntidad()
                : resultados.get(0);
    }

    @Override
    public List<PaisEntidad> consultarPorFiltro(final PaisEntidad filtro) {
        var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                filtro, new PaisEntidad());

        var consulta = new FiltroSql(SQL_CONSULTAR)
                .conId("\"id\"", filtroSeguro.getId())
                .conTexto("\"Nombre\"", filtroSeguro.getNombre());

        return ejecutarConsulta(
                consulta.getSentencia(),
                consulta.getParametros(),
                this::mapear,
                CatalogoMensajes.PostgreSqlDAO.USUARIO_ERROR_CONSULTANDO_REGISTROS
        );
    }

    @Override
    public List<PaisEntidad> consultarTodos() {
        return ejecutarConsulta(
                SQL_CONSULTAR,
                List.of(),
                this::mapear,
                CatalogoMensajes.PostgreSqlDAO.USUARIO_ERROR_CONSULTANDO_REGISTROS
        );
    }

    @Override
    public void actualizar(final UUID id, final PaisEntidad entidad) {
        ejecutarActualizacion(
                SQL_ACTUALIZAR,
                CatalogoMensajes.PostgreSqlDAO.USUARIO_ERROR_ACTUALIZANDO_REGISTRO,
                entidad.getNombre(),
                id.toString()
        );
    }

    @Override
    public void eliminar(final UUID id) {
        ejecutarActualizacion(
                SQL_ELIMINAR,
                CatalogoMensajes.PostgreSqlDAO.USUARIO_ERROR_ELIMINANDO_REGISTRO,
                id.toString()
        );
    }

    private PaisEntidad mapear(final ResultSet resultados)
            throws SQLException {
        var entidad = new PaisEntidad();
        entidad.setId(leerUUID(resultados, "id"));
        entidad.setNombre(resultados.getString("Nombre"));
        return entidad;
    }
}
