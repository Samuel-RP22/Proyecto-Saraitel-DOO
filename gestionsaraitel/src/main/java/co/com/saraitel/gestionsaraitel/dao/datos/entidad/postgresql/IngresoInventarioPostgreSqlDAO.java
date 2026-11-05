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
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class IngresoInventarioPostgreSqlDAO extends SqlDAO implements IngresoInventarioDAO {

	public IngresoInventarioPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final IngresoInventarioEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.IngresoInventarioPostgreSqlDAO.SQL_INSERTAR,
				CatalogoMensajes.IngresoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_INGRESO_DE_INVENTARIO,
				CatalogoMensajes.IngresoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_INGRESO_DE_INVENTARIO,
				entidad.getId(), entidad.getSede().getId(), entidad.getEstado().getId(),
				Timestamp.valueOf(entidad.getFechaLlegada()), entidad.getTotal());
	}

	@Override
	public IngresoInventarioEntidad consultarPorId(final UUID id) {
		IngresoInventarioEntidad filtro = new IngresoInventarioEntidad();
		filtro.setId(id);

		List<IngresoInventarioEntidad> resultado = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultado, new IngresoInventarioEntidad());
	}

	@Override
	public List<IngresoInventarioEntidad> consultarPorFiltro(final IngresoInventarioEntidad filtro) {

		IngresoInventarioEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro,
				new IngresoInventarioEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoSentenciasSql.IngresoInventarioPostgreSqlDAO.SQL_CONSULTAR)
				.conId("\"id\"", filtroSeguro.getId()).conId("\"Sede_id\"", filtroSeguro.getSede().getId())
				.conId("\"EstadoInventario_id\"", filtroSeguro.getEstado().getId())
				.conFechaHora("\"FechaLlegada\"", filtroSeguro.getFechaLlegada());

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajes.IngresoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_INGRESOS_DE_INVENTARIO,
				CatalogoMensajes.IngresoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_INGRESOS_DE_INVENTARIO);
	}

	@Override
	public List<IngresoInventarioEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.IngresoInventarioPostgreSqlDAO.SQL_CONSULTAR, List.of(),
				this::mapear,
				CatalogoMensajes.IngresoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_INGRESOS_DE_INVENTARIO,
				CatalogoMensajes.IngresoInventarioPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_INGRESOS_DE_INVENTARIO);
	}

	private IngresoInventarioEntidad mapear(final ResultSet resultados) throws SQLException {

		IngresoInventarioEntidad entidad = new IngresoInventarioEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		SedeEntidad sede = new SedeEntidad();
		sede.setId(leerUUID(resultados, "Sede_id"));
		entidad.setSede(sede);
		EstadoInventarioEntidad estado = new EstadoInventarioEntidad();
		estado.setId(leerUUID(resultados, "EstadoInventario_id"));
		entidad.setEstado(estado);
		entidad.setFechaLlegada(leerFechaHora(resultados, "FechaLlegada"));
		entidad.setTotal(resultados.getBigDecimal("Total"));

		return entidad;
	}
}
