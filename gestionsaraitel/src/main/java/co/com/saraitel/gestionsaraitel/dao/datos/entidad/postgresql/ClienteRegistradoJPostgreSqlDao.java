
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteRegistradoJDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoJEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PrefijoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteRegistradoJPostgreSqlDao extends SqlDAO
        implements ClienteRegistradoJDAO {

    private static final String SQL_INSERTAR =
            "INSERT INTO saraitel.\"ClienteRegistradoJ\" "
            + "(\"id\", \"ClienteRegistrado_id\", \"Prefijo_id\", "
            + "\"Telefono\", \"Nit\", \"RazonSocial\", \"Correo\", "
            + "\"TelefonoConfirmado\", \"CorreoConfirmado\") "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String SQL_CONSULTAR =
            "SELECT \"id\", \"ClienteRegistrado_id\", \"Prefijo_id\", "
            + "\"Telefono\", \"Nit\", \"RazonSocial\", \"Correo\", "
            + "\"TelefonoConfirmado\", \"CorreoConfirmado\" "
            + "FROM saraitel.\"ClienteRegistradoJ\"";

    private static final String SQL_ACTUALIZAR =
            "UPDATE saraitel.\"ClienteRegistradoJ\" SET "
            + "\"ClienteRegistrado_id\" = ?, \"Prefijo_id\" = ?, "
            + "\"Telefono\" = ?, \"Nit\" = ?, \"RazonSocial\" = ?, "
            + "\"Correo\" = ?, \"TelefonoConfirmado\" = ?, "
            + "\"CorreoConfirmado\" = ? WHERE \"id\" = ?";

    private static final String SQL_ELIMINAR =
            "DELETE FROM saraitel.\"ClienteRegistradoJ\" "
            + "WHERE \"id\" = ?";

    public ClienteRegistradoJPostgreSqlDao(final Connection conexion) {
        super(conexion);
    }

    @Override
    public void crear(final ClienteRegistradoJEntidad entidad) {
        ejecutarActualizacion(
                SQL_INSERTAR,
                "Error al crear cliente registrado jurídico.",
                entidad.getId().toString(),
                entidad.getClienteRegistrado().getId().toString(),
                entidad.getPrefijo().getId().toString(),
                entidad.getTelefono(),
                entidad.getNit(),
                entidad.getRazonSocial(),
                entidad.getCorreo(),
                entidad.getTelefonoConfirmado(),
                entidad.getCorreoConfirmado()
        );
    }

    @Override
    public ClienteRegistradoJEntidad consultarPorId(final UUID id) {
        var filtro = new ClienteRegistradoJEntidad();
        filtro.setId(id);

        var resultados = consultarPorFiltro(filtro);

        return resultados.isEmpty()
                ? new ClienteRegistradoJEntidad()
                : resultados.get(0);
    }

    @Override
    public List<ClienteRegistradoJEntidad> consultarPorFiltro(
            final ClienteRegistradoJEntidad filtro) {

        var filtroSeguro =
                UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                        filtro, new ClienteRegistradoJEntidad());

        var consulta = new FiltroSql(SQL_CONSULTAR)
                .conId("\"id\"", filtroSeguro.getId())
                .conId("\"ClienteRegistrado_id\"",
                        filtroSeguro.getClienteRegistrado().getId())
                .conId("\"Prefijo_id\"",
                        filtroSeguro.getPrefijo().getId())
                .conTexto("\"Telefono\"", filtroSeguro.getTelefono())
                .conTexto("\"Nit\"", filtroSeguro.getNit())
                .conTexto("\"RazonSocial\"", filtroSeguro.getRazonSocial())
                .conTexto("\"Correo\"", filtroSeguro.getCorreo())
                .conBooleano("\"TelefonoConfirmado\"",
                        filtroSeguro.getTelefonoConfirmado(), false)
                .conBooleano("\"CorreoConfirmado\"",
                        filtroSeguro.getCorreoConfirmado(), false);

        return ejecutarConsulta(
                consulta.getSentencia(),
                consulta.getParametros(),
                this::mapear,
                "Error al consultar clientes registrados jurídicos."
        );
    }

    @Override
    public List<ClienteRegistradoJEntidad> consultarTodos() {
        return ejecutarConsulta(
                SQL_CONSULTAR,
                List.of(),
                this::mapear,
                "Error al consultar clientes registrados jurídicos."
        );
    }

    @Override
    public void actualizar(
            final UUID id,
            final ClienteRegistradoJEntidad entidad) {

        ejecutarActualizacion(
                SQL_ACTUALIZAR,
                "Error al actualizar cliente registrado jurídico.",
                entidad.getClienteRegistrado().getId().toString(),
                entidad.getPrefijo().getId().toString(),
                entidad.getTelefono(),
                entidad.getNit(),
                entidad.getRazonSocial(),
                entidad.getCorreo(),
                entidad.getTelefonoConfirmado(),
                entidad.getCorreoConfirmado(),
                id.toString()
        );
    }

    @Override
    public void eliminar(final UUID id) {
        ejecutarActualizacion(
                SQL_ELIMINAR,
                "Error al eliminar cliente registrado jurídico.",
                id.toString()
        );
    }

    private ClienteRegistradoJEntidad mapear(final ResultSet resultados)
            throws SQLException {

        var entidad = new ClienteRegistradoJEntidad();

        entidad.setId(leerUUID(resultados, "id"));

        var clienteRegistrado = new ClienteRegistradoEntidad();
        clienteRegistrado.setId(
                leerUUID(resultados, "ClienteRegistrado_id"));
        entidad.setClienteRegistrado(clienteRegistrado);

        var prefijo = new PrefijoEntidad();
        prefijo.setId(leerUUID(resultados, "Prefijo_id"));
        entidad.setPrefijo(prefijo);

        entidad.setTelefono(resultados.getString("Telefono"));
        entidad.setNit(resultados.getString("Nit"));
        entidad.setRazonSocial(resultados.getString("RazonSocial"));
        entidad.setCorreo(resultados.getString("Correo"));
        entidad.setTelefonoConfirmado(
                resultados.getBoolean("TelefonoConfirmado"));
        entidad.setCorreoConfirmado(
                resultados.getBoolean("CorreoConfirmado"));

        return entidad;
    }
}
