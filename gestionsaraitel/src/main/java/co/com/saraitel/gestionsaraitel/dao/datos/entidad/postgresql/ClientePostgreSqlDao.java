
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClientePostgreSqlDao extends SqlDAO implements ClienteDAO {

    private static final String SQL_INSERTAR =
            "INSERT INTO saraitel.\"Cliente\" "
            + "(\"id\", \"ClientePorDefecto\") VALUES (?, ?)";

    private static final String SQL_CONSULTAR =
            "SELECT \"id\", \"ClientePorDefecto\" "
            + "FROM saraitel.\"Cliente\"";

    private static final String SQL_ELIMINAR =
            "DELETE FROM saraitel.\"Cliente\" WHERE \"id\" = ?";

    public ClientePostgreSqlDao(final Connection conexion) {
        super(conexion);
    }

    @Override
    public void crear(final ClienteEntidad entidad) {
        ejecutarActualizacion(
                SQL_INSERTAR,
                "Error al crear cliente.",
                entidad.getId().toString(),
                entidad.getEsClienteRegistrado()
        );
    }

    @Override
    public ClienteEntidad consultarPorId(final UUID id) {
        var filtro = new ClienteEntidad();
        filtro.setId(id);

        var resultados = consultarPorFiltro(filtro);

        return resultados.isEmpty()
                ? new ClienteEntidad()
                : resultados.get(0);
    }

    @Override
    public List<ClienteEntidad> consultarPorFiltro(
            final ClienteEntidad filtro) {

        var filtroSeguro =
                UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                        filtro, new ClienteEntidad());

        var consulta = new FiltroSql(SQL_CONSULTAR)
                .conId("\"id\"", filtroSeguro.getId())
                .conBooleano(
                        "\"ClientePorDefecto\"",
                        filtroSeguro.getEsClienteRegistrado(),
                        true
                );

        return ejecutarConsulta(
                consulta.getSentencia(),
                consulta.getParametros(),
                this::mapear,
                "Error al consultar clientes."
        );
    }

    @Override
    public List<ClienteEntidad> consultarTodos() {
        return ejecutarConsulta(
                SQL_CONSULTAR,
                List.of(),
                this::mapear,
                "Error al consultar clientes."
        );
    }

    @Override
    public void eliminar(final UUID id) {
        ejecutarActualizacion(
                SQL_ELIMINAR,
                "Error al eliminar cliente.",
                id.toString()
        );
    }

    private ClienteEntidad mapear(final ResultSet resultados)
            throws SQLException {

        var entidad = new ClienteEntidad();
        entidad.setId(leerUUID(resultados, "id"));
        entidad.setEsClienteRegistrado(
                resultados.getBoolean("ClientePorDefecto"));

        return entidad;
    }
}
