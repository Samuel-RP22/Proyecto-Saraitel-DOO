
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.TipoDocumentoDAO;
import co.com.saraitel.gestionsaraitel.entidad.TipoDocumentoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class TipoDocumentoPostgreSqlDao extends SqlDAO implements TipoDocumentoDAO {

    private static final String SQL_CONSULTAR =
            "SELECT \"id\", \"Tipo\" FROM saraitel.\"TipoDocumento\"";

    public TipoDocumentoPostgreSqlDao(final Connection conexion) {
        super(conexion);
    }

    @Override
    public TipoDocumentoEntidad consultarPorId(final UUID id) {
        var filtro = new TipoDocumentoEntidad();
        filtro.setId(id);

        var resultados = consultarPorFiltro(filtro);

        return resultados.isEmpty()
                ? new TipoDocumentoEntidad()
                : resultados.get(0);
    }

    @Override
    public List<TipoDocumentoEntidad> consultarPorFiltro(
            final TipoDocumentoEntidad filtro) {

        var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
                filtro, new TipoDocumentoEntidad());

        var consulta = new FiltroSql(SQL_CONSULTAR)
                .conId("\"id\"", filtroSeguro.getId())
                .conTexto("\"Tipo\"", filtroSeguro.getTipo());

        return ejecutarConsulta(
                consulta.getSentencia(),
                consulta.getParametros(),
                this::mapear,
                "Error al consultar tipos de documento."
        );
    }

    @Override
    public List<TipoDocumentoEntidad> consultarTodos() {
        return ejecutarConsulta(
                SQL_CONSULTAR,
                List.of(),
                this::mapear,
                "Error al consultar tipos de documento."
        );
    }

    private TipoDocumentoEntidad mapear(final ResultSet resultados)
            throws SQLException {

        var entidad = new TipoDocumentoEntidad();
        entidad.setId(leerUUID(resultados, "id"));
        entidad.setTipo(resultados.getString("Tipo"));

        return entidad;
    }
}
