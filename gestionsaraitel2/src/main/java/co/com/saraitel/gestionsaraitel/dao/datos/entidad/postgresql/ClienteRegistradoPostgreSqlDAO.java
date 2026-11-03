
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteRegistradoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteRegistradoPostgreSqlDAO extends SqlDAO implements ClienteRegistradoDAO {

	public ClienteRegistradoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ClienteRegistradoEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.ClienteRegistradoPostgreSqlDAO.SQL_INSERTAR, CatalogoMensajes.ClienteRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_CLIENTE_REGISTRADO,
				CatalogoMensajes.ClienteRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_CLIENTE_REGISTRADO, entidad.getId(),
				entidad.getCliente().getId());
	}

	@Override
	public ClienteRegistradoEntidad consultarPorId(final UUID id) {
		var filtro = new ClienteRegistradoEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new ClienteRegistradoEntidad());
	}

	@Override
	public List<ClienteRegistradoEntidad> consultarPorFiltro(final ClienteRegistradoEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new ClienteRegistradoEntidad());

		var consulta = new FiltroSql(CatalogoSentenciasSql.ClienteRegistradoPostgreSqlDAO.SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId()).conId("\"Cliente_id\"",
				filtroSeguro.getCliente().getId());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.ClienteRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES_REGISTRADOS,
				CatalogoMensajes.ClienteRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_REGISTRADOS);
	}

	@Override
	public List<ClienteRegistradoEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.ClienteRegistradoPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear, CatalogoMensajes.ClienteRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES_REGISTRADOS,
				CatalogoMensajes.ClienteRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_REGISTRADOS);
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(CatalogoSentenciasSql.ClienteRegistradoPostgreSqlDAO.SQL_ELIMINAR, CatalogoMensajes.ClienteRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ELIMINANDO_CLIENTE_REGISTRADO,
				CatalogoMensajes.ClienteRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_CLIENTE_REGISTRADO, id);
	}

	private ClienteRegistradoEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new ClienteRegistradoEntidad();
		entidad.setId(leerUUID(resultados, "id"));

		var cliente = new ClienteEntidad();
		cliente.setId(leerUUID(resultados, "Cliente_id"));
		entidad.setCliente(cliente);

		return entidad;
	}
}
