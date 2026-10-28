
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.IngresoInventarioDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.EstadoInventarioEntidad;
import co.com.saraitel.gestionsaraitel.entidad.IngresoInventarioEntidad;
import co.com.saraitel.gestionsaraitel.entidad.SedeEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class IngresoInventarioPostgreSqlDAO extends SqlDAO implements IngresoInventarioDAO {

	public IngresoInventarioPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final IngresoInventarioEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.IngresoInventarioPostgreSqlDAO.SQL_INSERTAR, CatalogoMensajesSql.IngresoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_INGRESO_DE_INVENTARIO,
				CatalogoMensajesSql.IngresoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_INGRESO_DE_INVENTARIO, entidad.getId(),
				entidad.getSede().getId(), entidad.getEstado().getId(),
				Timestamp.valueOf(entidad.getFechaLlegada()), entidad.getTotal());
	}

	@Override
	public IngresoInventarioEntidad consultarPorId(final UUID id) {
		var filtro = new IngresoInventarioEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new IngresoInventarioEntidad());
	}

	@Override
	public List<IngresoInventarioEntidad> consultarPorFiltro(final IngresoInventarioEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new IngresoInventarioEntidad());

		var sentencia = new FiltroSql(CatalogoMensajesSql.IngresoInventarioPostgreSqlDAO.SQL_CONSULTAR);

		sentencia.conId("\"id\"", filtroSeguro.getId());
		sentencia.conId("\"Sede_id\"", filtroSeguro.getSede().getId());
		sentencia.conId("\"EstadoInventario_id\"", filtroSeguro.getEstado().getId());
		sentencia.conFechaHora("\"FechaLlegada\"", filtroSeguro.getFechaLlegada());

		return ejecutarConsulta(sentencia.getSentencia(), sentencia.getParametros(), this::mapear,
				CatalogoMensajesSql.IngresoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_INGRESOS_DE_INVENTARIO,
				CatalogoMensajesSql.IngresoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_INGRESOS_DE_INVENTARIO);
	}

	@Override
	public List<IngresoInventarioEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.IngresoInventarioPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear, CatalogoMensajesSql.IngresoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_INGRESOS_DE_INVENTARIO,
				CatalogoMensajesSql.IngresoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_INGRESOS_DE_INVENTARIO);
	}

	private IngresoInventarioEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new IngresoInventarioEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		var sede = new SedeEntidad();
		sede.setId(leerUUID(resultados, "Sede_id"));
		entidad.setSede(sede);

		var estado = new EstadoInventarioEntidad();
		estado.setId(leerUUID(resultados, "EstadoInventario_id"));
		entidad.setEstado(estado);

		entidad.setFechaLlegada(leerFechaHora(resultados, "FechaLlegada"));

		entidad.setTotal(resultados.getBigDecimal("Total"));

		return entidad;
	}
}
