
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.MetodoPagoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.MetodoPagoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class MetodoPagoPostgreSqlDAO extends SqlDAO implements MetodoPagoDAO {

	public MetodoPagoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final MetodoPagoEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.MetodoPagoPostgreSqlDAO.SQL_CREAR, CatalogoMensajes.MetodoPagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_METODO_DE_PAGO,
				CatalogoMensajes.MetodoPagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_METODO_DE_PAGO, entidad.getId(),
				entidad.getNombre(), entidad.getEsActivo());
	}

	@Override
	public MetodoPagoEntidad consultarPorId(final UUID id) {
		List<MetodoPagoEntidad> resultado = ejecutarConsulta(CatalogoSentenciasSql.MetodoPagoPostgreSqlDAO.SQL_CONSULTAR_POR_ID, List.of(id),
				this::mapear, CatalogoMensajes.MetodoPagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_METODO_DE_PAGO,
				CatalogoMensajes.MetodoPagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_METODO_DE_PAGO);

		return obtenerPrimeroOValorDefecto(resultado, new MetodoPagoEntidad());
	}

	@Override
	public List<MetodoPagoEntidad> consultarPorFiltro(final MetodoPagoEntidad filtro) {

		MetodoPagoEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new MetodoPagoEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoSentenciasSql.MetodoPagoPostgreSqlDAO.SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conTexto("\"Nombre\"", filtroSeguro.getNombre())
				.conBooleano("\"EsActivo\"", filtroSeguro.getEsActivo(), true);

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajes.MetodoPagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_METODOS_DE_PAGO,
				CatalogoMensajes.MetodoPagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_METODOS_DE_PAGO);
	}

	@Override
	public List<MetodoPagoEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.MetodoPagoPostgreSqlDAO.SQL_CONSULTAR_TODOS, List.of(), this::mapear,
				CatalogoMensajes.MetodoPagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_METODOS_DE_PAGO,
				CatalogoMensajes.MetodoPagoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_METODOS_DE_PAGO);
	}

	private MetodoPagoEntidad mapear(final ResultSet resultados) throws SQLException {

		MetodoPagoEntidad entidad = new MetodoPagoEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("Nombre"));
		entidad.setEsActivo(resultados.getBoolean("EsActivo"));

		return entidad;
	}
}
