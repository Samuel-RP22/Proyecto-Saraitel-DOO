
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EstadoProcesoCompraDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.EstadoProcesoCompraEntidad;

public class EstadoProcesoCompraPostgreSqlDAO extends SqlDAO
        implements EstadoProcesoCompraDAO {

    private static final String SQL_CREAR = """
            INSERT INTO saraitel."EstadoProcesoCompra"
            ("id", "Codigo", "Nombre")
            VALUES (?, ?, ?)
            """;

    private static final String SQL_CONSULTAR_POR_ID = """
            SELECT "id", "Codigo", "Nombre"
            FROM saraitel."EstadoProcesoCompra"
            WHERE "id" = ?
            """;

    private static final String SQL_CONSULTAR_POR_FILTRO = """
            SELECT "id", "Codigo", "Nombre"
            FROM saraitel."EstadoProcesoCompra"
            """;

    private static final String SQL_CONSULTAR_TODOS = """
            SELECT "id", "Codigo", "Nombre"
            FROM saraitel."EstadoProcesoCompra"
            """;

    public EstadoProcesoCompraPostgreSqlDAO(final Connection conexion) {
        super(conexion);
    }

    @Override
    public void crear(final EstadoProcesoCompraEntidad entidad) {
        ejecutarActualizacion(
                SQL_CREAR,
                "Error al crear el estado del proceso de compra",
                entidad.getId().toString(),
                entidad.getCodigo(),
                entidad.getNombre()
        );
    }

    @Override
    public EstadoProcesoCompraEntidad consultarPorId(final UUID id) {
        List<EstadoProcesoCompraEntidad> resultado = ejecutarConsulta(
                SQL_CONSULTAR_POR_ID,
                List.of(id.toString()),
                this::mapear,
                "Error al consultar el estado del proceso de compra"
        );

        if (resultado.isEmpty()) {
            return new EstadoProcesoCompraEntidad();
        } else {
            return resultado.get(0);
        }
    }

    @Override
    public List<EstadoProcesoCompraEntidad> consultarPorFiltro(
            final EstadoProcesoCompraEntidad filtro) {

    	EstadoProcesoCompraEntidad filtroSeguro;

    	if (filtro == null) {
    	    filtroSeguro = new EstadoProcesoCompraEntidad();
    	} else {
    	    filtroSeguro = filtro;
    	}

        FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO)
                .conId("\"id\"", filtroSeguro.getId())
                .conTexto("\"Codigo\"", filtroSeguro.getCodigo())
                .conTexto("\"Nombre\"", filtroSeguro.getNombre());

        return ejecutarConsulta(
                filtroSql.getSentencia(),
                filtroSql.getParametros(),
                this::mapear,
                "Error al consultar estados del proceso de compra"
        );
    }

    @Override
    public List<EstadoProcesoCompraEntidad> consultarTodos() {
        return ejecutarConsulta(
                SQL_CONSULTAR_TODOS,
                List.of(),
                this::mapear,
                "Error al consultar los estados del proceso de compra"
        );
    }

    private EstadoProcesoCompraEntidad mapear(final ResultSet resultados)
            throws SQLException {

        EstadoProcesoCompraEntidad entidad =
                new EstadoProcesoCompraEntidad();

        entidad.setId(leerUUID(resultados, "id"));
        entidad.setCodigo(resultados.getString("Codigo"));
        entidad.setNombre(resultados.getString("Nombre"));

        return entidad;
    }
}
