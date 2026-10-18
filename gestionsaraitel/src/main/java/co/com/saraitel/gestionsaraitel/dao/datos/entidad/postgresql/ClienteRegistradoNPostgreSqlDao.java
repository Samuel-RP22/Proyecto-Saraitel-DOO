
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteRegistradoNDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoNEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteRegistradoNPostgreSqlDao extends SqlDAO
        implements ClienteRegistradoNDAO {

    private static final String SQL_INSERTAR =
            "INSERT INTO saraitel.\"ClienteRegistradoN\" "
            + "(\"id\", \"ClienteRegistrado_id\", \"Persona_id\") "
            + "VALUES (?, ?, ?)";

    private static final String SQL_CONSULTAR =
            "SELECT \"id\", \"ClienteRegistrado_id\", \"Persona_id\" "
            + "FROM saraitel.\"ClienteRegistradoN\"";

    private static final String SQL_ELIMINAR =
            "DELETE FROM saraitel.\"ClienteRegistradoN\" "
            + "WHERE \"id\" = ?";

    public ClienteRegistradoNPostgreSqlDao(final Connection conexion) {
        super(conexion);
    }

    @Override
    public void crear(final ClienteRegistradoNEntidad entidad) {
        ejecutarActualizacion(
                SQL_INSERTAR,
                "Error al crear cliente registrado.",
                entidad.getId().toString(),
                entidad.getClienteRegistrado().getId().toString(),
                entidad.getPersona().getId().toString()
        );
    }

    @Override
    public ClienteRegistradoNEntidad consultarPorId(final UUID id) {
        var filtro = new ClienteRegistradoNEntidad();
        filtro.setId(id);

        var resultados = consultarPorFiltro(filtro);

        return resultados.isEmpty()
                ? new ClienteRegistradoNEntidad()
                : resultados.get(0);
    }

    @Override
    public List<ClienteRegistradoNEntidad> consultarPorFiltro(
            final ClienteRegistradoNEntidad filtro) {

        var filtroSeguro =
                UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                        filtro, new ClienteRegistradoNEntidad());

        var consulta = new FiltroSql(SQL_CONSULTAR)
                .conId("\"id\"", filtroSeguro.getId())
                .conId("\"ClienteRegistrado_id\"",
                        filtroSeguro.getClienteRegistrado().getId())
                .conId("\"Persona_id\"",
                        filtroSeguro.getPersona().getId());

        return ejecutarConsulta(
                consulta.getSentencia(),
                consulta.getParametros(),
                this::mapear,
                "Error al consultar clientes registrados."
        );
    }

    @Override
    public List<ClienteRegistradoNEntidad> consultarTodos() {
        return ejecutarConsulta(
                SQL_CONSULTAR,
                List.of(),
                this::mapear,
                "Error al consultar clientes registrados."
        );
    }

    @Override
    public void eliminar(final UUID id) {
        ejecutarActualizacion(
                SQL_ELIMINAR,
                "Error al eliminar cliente registrado.",
                id.toString()
        );
    }

    private ClienteRegistradoNEntidad mapear(final ResultSet resultados)
            throws SQLException {

        var entidad = new ClienteRegistradoNEntidad();
        entidad.setId(leerUUID(resultados, "id"));

        var clienteRegistrado = new ClienteRegistradoEntidad();
        clienteRegistrado.setId(
                leerUUID(resultados, "ClienteRegistrado_id"));
        entidad.setClienteRegistrado(clienteRegistrado);

        var persona = new PersonaEntidad();
        persona.setId(leerUUID(resultados, "Persona_id"));
        entidad.setPersona(persona);

        return entidad;
    }
}
