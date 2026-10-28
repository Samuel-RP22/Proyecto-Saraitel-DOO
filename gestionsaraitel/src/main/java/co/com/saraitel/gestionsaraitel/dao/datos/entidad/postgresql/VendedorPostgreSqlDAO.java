
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
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class VendedorPostgreSqlDAO extends SqlDAO implements VendedorDAO {

	public VendedorPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final VendedorEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.VendedorPostgreSqlDAO.SQL_CREAR, CatalogoMensajesSql.VendedorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_VENDEDOR,
				CatalogoMensajesSql.VendedorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_VENDEDOR, entidad.getId(),
				entidad.getEmpleado().getId());
	}

	@Override
	public VendedorEntidad consultarPorId(final UUID id) {
		var filtro = new VendedorEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new VendedorEntidad());
	}

	@Override
	public List<VendedorEntidad> consultarPorFiltro(final VendedorEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new VendedorEntidad());

		var consulta = new FiltroSql(CatalogoMensajesSql.VendedorPostgreSqlDAO.SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId()).conId("\"Empleado_id\"",
				filtroSeguro.getEmpleado().getId());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajesSql.VendedorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_VENDEDORES,
				CatalogoMensajesSql.VendedorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_VENDEDORES);
	}

	@Override
	public List<VendedorEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.VendedorPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear, CatalogoMensajesSql.VendedorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_VENDEDORES,
				CatalogoMensajesSql.VendedorPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_VENDEDORES);
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
