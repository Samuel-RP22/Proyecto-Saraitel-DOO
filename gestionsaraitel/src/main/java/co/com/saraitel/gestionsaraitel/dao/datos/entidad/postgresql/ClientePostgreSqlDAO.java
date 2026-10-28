package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClientePostgreSqlDAO extends SqlDAO implements ClienteDAO {

	public ClientePostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ClienteEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.ClientePostgreSqlDAO.SQL_INSERTAR, CatalogoMensajesSql.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_CLIENTE,
				CatalogoMensajesSql.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_CLIENTE, entidad.getId(),
				entidad.getEsClienteRegistrado());
	}

	@Override
	public ClienteEntidad consultarPorId(final UUID id) {
		var filtro = new ClienteEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new ClienteEntidad());
	}

	@Override
	public List<ClienteEntidad> consultarPorFiltro(final ClienteEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new ClienteEntidad());

		var consulta = new FiltroSql(CatalogoMensajesSql.ClientePostgreSqlDAO.SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conBooleano("\"EsClienteRegistrado\"", filtroSeguro.getEsClienteRegistrado(), false);

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajesSql.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES,
				CatalogoMensajesSql.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES);
	}

	@Override
	public List<ClienteEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.ClientePostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear, CatalogoMensajesSql.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES,
				CatalogoMensajesSql.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES);
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(CatalogoMensajesSql.ClientePostgreSqlDAO.SQL_ELIMINAR, CatalogoMensajesSql.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ELIMINANDO_CLIENTE,
				CatalogoMensajesSql.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_CLIENTE, id);
	}

	private ClienteEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new ClienteEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setEsClienteRegistrado(resultados.getBoolean("EsClienteRegistrado"));

		return entidad;
	}
}
