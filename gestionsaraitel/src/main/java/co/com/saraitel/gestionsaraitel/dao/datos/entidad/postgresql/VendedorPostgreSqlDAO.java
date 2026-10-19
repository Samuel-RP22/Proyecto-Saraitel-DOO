
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.VendedorDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.VendedorEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class VendedorPostgreSqlDAO extends SqlDAO implements VendedorDAO {

	private static final String SQL_CREAR = "INSERT INTO saraitel.\"Vendedor\" (\"id\", \"Empleado_id\") VALUES (?, ?)";

	private static final String SQL_CONSULTAR = "SELECT \"id\", \"Empleado_id\" FROM saraitel.\"Vendedor\"";

	public VendedorPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final VendedorEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear vendedor.",
				"Error NO CONTROLADO al crear vendedor.", entidad.getId(),
				entidad.getEmpleado().getId());
	}

	@Override
	public VendedorEntidad consultarPorId(final UUID id) {
		var filtro = new VendedorEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new VendedorEntidad() : resultados.get(0);
	}

	@Override
	public List<VendedorEntidad> consultarPorFiltro(final VendedorEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new VendedorEntidad());

		var consulta = new FiltroSql(SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId()).conId("\"Empleado_id\"",
				filtroSeguro.getEmpleado().getId());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				"Error al consultar vendedores.",
				"Error NO CONTROLADO al consultar vendedores.");
	}

	@Override
	public List<VendedorEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar vendedores.",
				"Error NO CONTROLADO al consultar vendedores.");
	}

	private VendedorEntidad mapear(final ResultSet resultados) throws SQLException {
		var entidad = new VendedorEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		var empleado = new EmpleadoEntidad();
		empleado.setId(leerUUID(resultados, "Empleado_id"));
		entidad.setEmpleado(empleado);

		return entidad;
	}
}
