
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteNoRegistradoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteNoRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteNoRegistradoPostgreSqlDAO extends SqlDAO implements ClienteNoRegistradoDAO {

	public ClienteNoRegistradoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ClienteNoRegistradoEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.ClienteNoRegistradoPostgreSqlDAO.SQL_INSERTAR,
				CatalogoMensajes.ClienteNoRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_CLIENTE_NO_REGISTRADO,
				CatalogoMensajes.ClienteNoRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_CLIENTE_NO_REGISTRADO,
				entidad.getId(), entidad.getCliente().getId(), entidad.getNombre(), entidad.getApellido(),
				entidad.getNumeroDocumento());
	}

	@Override
	public ClienteNoRegistradoEntidad consultarPorId(final UUID id) {
		var filtro = new ClienteNoRegistradoEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new ClienteNoRegistradoEntidad());
	}

	@Override
	public List<ClienteNoRegistradoEntidad> consultarPorFiltro(final ClienteNoRegistradoEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro,
				new ClienteNoRegistradoEntidad());

		var consulta = new FiltroSql(CatalogoSentenciasSql.ClienteNoRegistradoPostgreSqlDAO.SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conId("\"Cliente_id\"", filtroSeguro.getCliente().getId())
				.conTexto("\"NumeroDocumento\"", filtroSeguro.getNumeroDocumento());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.ClienteNoRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES_NO_REGISTRADOS,
				CatalogoMensajes.ClienteNoRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_NO_REGISTRADOS);
	}

	@Override
	public List<ClienteNoRegistradoEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.ClienteNoRegistradoPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.ClienteNoRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES_NO_REGISTRADOS,
				CatalogoMensajes.ClienteNoRegistradoPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_NO_REGISTRADOS);
	}

	private ClienteNoRegistradoEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new ClienteNoRegistradoEntidad();
		entidad.setId(leerUUID(resultados, "id"));

		var cliente = new ClienteEntidad();
		cliente.setId(leerUUID(resultados, "Cliente_id"));
		entidad.setCliente(cliente);

		entidad.setNombre(resultados.getString("Nombre"));
		entidad.setApellido(resultados.getString("Apellido"));
		entidad.setNumeroDocumento(resultados.getString("NumeroDocumento"));

		return entidad;
	}
}
