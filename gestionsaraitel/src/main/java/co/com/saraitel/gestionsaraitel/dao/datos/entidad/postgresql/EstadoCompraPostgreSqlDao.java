
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EstadoCompraDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.EstadoCompraEntidad;

public class EstadoCompraPostgreSqlDao extends SqlDAO
        implements EstadoCompraDAO {

    private static final String SQL_CREAR = """
            INSERT INTO saraitel."EstadoCompra"
            ("id", "Codigo", "Nombre")
            VALUES (?, ?, ?)
            """;

    private static final String SQL_CONSULTAR_POR_ID = """
            SELECT "id", "Codigo", "Nombre"
            FROM saraitel."EstadoCompra"
            WHERE "id" = ?
            """;

    private static final String SQL_CONSULTAR_POR_FILTRO = """
            SELECT "id", "Codigo", "Nombre"
            FROM saraitel."EstadoCompra"
            """;

    private static final String SQL_CONSULTAR_TODOS = """
            SELECT "id", "Codigo", "Nombre"
            FROM saraitel."EstadoCompra"
            """;

    public EstadoCompraPostgreSqlDao(final Connection conexion) {
        super(conexion);
    }

    @Override
    public void crear(final EstadoCompraEntidad entidad) {
        ejecutarActualizacion(
                SQL_CREAR,
                "Error al crear el estado de compra",
                entidad.getId().toString(),
                entidad.getCodigo(),
                entidad.getNombre()
        );
    }

    @Override
    public EstadoCompraEntidad consultarPorId(final UUID id) {
        List<EstadoCompraEntidad> resultado = ejecutarConsulta(
                SQL_CONSULTAR_POR_ID,
                List.of(id.toString()),
                this::mapear,
                "Error al consultar el estado de compra"
        );

        if (resultado.isEmpty()) {
            return new EstadoCompraEntidad();
        } else {
            return resultado.get(0);
        }
    }

    @Override
    public List<EstadoCompraEntidad> consultarPorFiltro(
            final EstadoCompraEntidad filtro) {

    	EstadoCompraEntidad filtroSeguro;

    	if (filtro == null) {
    	    filtroSeguro = new EstadoCompraEntidad();
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
                "Error al consultar estados de compra"
        );
    }

    @Override
    public List<EstadoCompraEntidad> consultarTodos() {
        return ejecutarConsulta(
                SQL_CONSULTAR_TODOS,
                List.of(),
                this::mapear,
                "Error al consultar los estados de compra"
        );
    }

    private EstadoCompraEntidad mapear(final ResultSet resultados)
            throws SQLException {

        EstadoCompraEntidad entidad = new EstadoCompraEntidad();

        entidad.setId(leerUUID(resultados, "id"));
        entidad.setCodigo(resultados.getString("Codigo"));
        entidad.setNombre(resultados.getString("Nombre"));

        return entidad;
    }
}
