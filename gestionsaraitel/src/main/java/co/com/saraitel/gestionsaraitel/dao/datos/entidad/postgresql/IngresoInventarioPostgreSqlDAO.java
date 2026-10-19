
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
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class IngresoInventarioPostgreSqlDAO extends SqlDAO implements IngresoInventarioDAO {

	private static final String SQL_INSERTAR = "INSERT INTO saraitel.\"IngresoInventario\" "
			+ "(\"id\", \"Sede_id\", \"EstadoInventario_id\", " + "\"FechaLlegada\", \"Total\") "
			+ "VALUES (?, ?, ?, ?, ?)";

	private static final String SQL_CONSULTAR = "SELECT \"id\", \"Sede_id\", \"EstadoInventario_id\", "
			+ "\"FechaLlegada\", \"Total\" " + "FROM saraitel.\"IngresoInventario\"";

	public IngresoInventarioPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final IngresoInventarioEntidad entidad) {
		ejecutarActualizacion(SQL_INSERTAR, "Error al crear el ingreso de inventario.",
				"Error NO CONTROLADO al crear el ingreso de inventario.", entidad.getId(),
				entidad.getSede().getId(), entidad.getEstado().getId(),
				Timestamp.valueOf(entidad.getFechaLlegada()), entidad.getTotal());
	}

	@Override
	public IngresoInventarioEntidad consultarPorId(final UUID id) {
		var filtro = new IngresoInventarioEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new IngresoInventarioEntidad() : resultados.get(0);
	}

	@Override
	public List<IngresoInventarioEntidad> consultarPorFiltro(final IngresoInventarioEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new IngresoInventarioEntidad());

		var sentencia = new FiltroSql(SQL_CONSULTAR);

		sentencia.conId("\"id\"", filtroSeguro.getId());
		sentencia.conId("\"Sede_id\"", filtroSeguro.getSede().getId());
		sentencia.conId("\"EstadoInventario_id\"", filtroSeguro.getEstado().getId());
		sentencia.conFechaHora("\"FechaLlegada\"", filtroSeguro.getFechaLlegada());

		return ejecutarConsulta(sentencia.getSentencia(), sentencia.getParametros(), this::mapear,
				"Error al consultar ingresos de inventario.",
				"Error NO CONTROLADO al consultar ingresos de inventario.");
	}

	@Override
	public List<IngresoInventarioEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar ingresos de inventario.",
				"Error NO CONTROLADO al consultar ingresos de inventario.");
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

		entidad.setFechaLlegada(resultados.getTimestamp("FechaLlegada").toLocalDateTime());

		entidad.setTotal(resultados.getBigDecimal("Total"));

		return entidad;
	}
}
