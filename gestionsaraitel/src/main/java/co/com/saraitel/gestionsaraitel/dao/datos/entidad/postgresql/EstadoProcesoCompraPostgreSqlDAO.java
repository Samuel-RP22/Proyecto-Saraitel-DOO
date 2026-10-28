
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.EstadoProcesoCompraDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.EstadoProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class EstadoProcesoCompraPostgreSqlDAO extends SqlDAO
        implements EstadoProcesoCompraDAO {

    public EstadoProcesoCompraPostgreSqlDAO(final Connection conexion) {
        super(conexion);
    }

    @Override
    public void crear(final EstadoProcesoCompraEntidad entidad) {
        ejecutarActualizacion(
                CatalogoSentenciasSql.EstadoProcesoCompraPostgreSqlDAO.SQL_CREAR,
                CatalogoMensajes.EstadoProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_ESTADO_DEL_PROCESO_DE_COMPRA,
				CatalogoMensajes.EstadoProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_ESTADO_DEL_PROCESO_DE_COMPRA,
                entidad.getId(),
                entidad.getCodigo(),
                entidad.getNombre()
        );
    }

    @Override
    public EstadoProcesoCompraEntidad consultarPorId(final UUID id) {
        List<EstadoProcesoCompraEntidad> resultado = ejecutarConsulta(
                CatalogoSentenciasSql.EstadoProcesoCompraPostgreSqlDAO.SQL_CONSULTAR_POR_ID,
                List.of(id),
                this::mapear,
                CatalogoMensajes.EstadoProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADO_DEL_PROCESO_DE_COMPRA,
				CatalogoMensajes.EstadoProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADO_DEL_PROCESO_DE_COMPRA
        );

        return obtenerPrimeroOValorDefecto(resultado, new EstadoProcesoCompraEntidad());
    }

    @Override
    public List<EstadoProcesoCompraEntidad> consultarPorFiltro(
            final EstadoProcesoCompraEntidad filtro) {

    	EstadoProcesoCompraEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new EstadoProcesoCompraEntidad());

        FiltroSql filtroSql = new FiltroSql(CatalogoSentenciasSql.EstadoProcesoCompraPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO)
                .conId("\"id\"", filtroSeguro.getId())
                .conTexto("\"Codigo\"", filtroSeguro.getCodigo())
                .conTexto("\"Nombre\"", filtroSeguro.getNombre());

        return ejecutarConsulta(
                filtroSql.getSentencia(),
                filtroSql.getParametros(),
                this::mapear,
                CatalogoMensajes.EstadoProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADOS_DEL_PROCESO_DE_COMPRA,
				CatalogoMensajes.EstadoProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_DEL_PROCESO_DE_COMPRA
        );
    }

    @Override
    public List<EstadoProcesoCompraEntidad> consultarTodos() {
        return ejecutarConsulta(
                CatalogoSentenciasSql.EstadoProcesoCompraPostgreSqlDAO.SQL_CONSULTAR_TODOS,
                List.of(),
                this::mapear,
                CatalogoMensajes.EstadoProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_ESTADOS_DEL_PROCESO_DE_COMPRA,
				CatalogoMensajes.EstadoProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_DEL_PROCESO_DE_COMPRA
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
