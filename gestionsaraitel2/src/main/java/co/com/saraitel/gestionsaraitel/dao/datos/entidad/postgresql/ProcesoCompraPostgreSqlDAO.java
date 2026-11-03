
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ProcesoCompraDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EmpleadoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.EstadoProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ProcesoCompraPostgreSqlDAO extends SqlDAO implements ProcesoCompraDAO {

	public ProcesoCompraPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ProcesoCompraEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.ProcesoCompraPostgreSqlDAO.SQL_CREAR, CatalogoMensajes.ProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_PROCESO_DE_COMPRA,
				CatalogoMensajes.ProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PROCESO_DE_COMPRA, entidad.getId(),
				entidad.getCliente().getId(), entidad.getEmpleado().getId(),
				entidad.getEstado().getId(), entidad.getFechaInicio(), entidad.getFechaActualizacion(),
				entidad.getTotal());
	}

	@Override
	public ProcesoCompraEntidad consultarPorId(final UUID id) {
		List<ProcesoCompraEntidad> resultado = ejecutarConsulta(CatalogoSentenciasSql.ProcesoCompraPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, CatalogoMensajes.ProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PROCESO_DE_COMPRA,
				CatalogoMensajes.ProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PROCESO_DE_COMPRA);

		return obtenerPrimeroOValorDefecto(resultado, new ProcesoCompraEntidad());
	}

	@Override
	public List<ProcesoCompraEntidad> consultarPorFiltro(final ProcesoCompraEntidad filtro) {
		ProcesoCompraEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new ProcesoCompraEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoSentenciasSql.ProcesoCompraPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Cliente_id\"", filtroSeguro.getCliente().getId())
				.conId("\"Empleado_id\"", filtroSeguro.getEmpleado().getId())
				.conId("\"EstadoProcesoCompra_id\"", filtroSeguro.getEstado().getId())
				.conFechaHora("\"FechaInicio\"", filtroSeguro.getFechaInicio())
				.conFechaHora("\"FechaActualizacion\"", filtroSeguro.getFechaActualizacion());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajes.ProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PROCESOS_DE_COMPRA,
				CatalogoMensajes.ProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PROCESOS_DE_COMPRA);
	}

	@Override
	public List<ProcesoCompraEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.ProcesoCompraPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear, CatalogoMensajes.ProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PROCESOS_DE_COMPRA,
				CatalogoMensajes.ProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PROCESOS_DE_COMPRA);
	}

	@Override
	public void actualizar(final UUID id, final ProcesoCompraEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.ProcesoCompraPostgreSqlDAO.SQL_ACTUALIZAR, CatalogoMensajes.ProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_PROCESO_DE_COMPRA,
				CatalogoMensajes.ProcesoCompraPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_PROCESO_DE_COMPRA, entidad.getCliente().getId(),
				entidad.getEmpleado().getId(), entidad.getEstado().getId(), entidad.getFechaInicio(),
				entidad.getFechaActualizacion(), entidad.getTotal(), id);
	}

	private ProcesoCompraEntidad mapear(final ResultSet resultados) throws SQLException {
		ClienteEntidad cliente = new ClienteEntidad();
		cliente.setId(leerUUID(resultados, "Cliente_id"));

		EmpleadoEntidad empleado = new EmpleadoEntidad();
		empleado.setId(leerUUID(resultados, "Empleado_id"));

		EstadoProcesoCompraEntidad estado = new EstadoProcesoCompraEntidad();
		estado.setId(leerUUID(resultados, "EstadoProcesoCompra_id"));

		return new ProcesoCompraEntidad(leerUUID(resultados, "id"), cliente, empleado, estado,
				leerFechaHora(resultados, "FechaInicio"),
				leerFechaHora(resultados, "FechaActualizacion"),
				resultados.getBigDecimal("TotalCompra"));
	}
}
