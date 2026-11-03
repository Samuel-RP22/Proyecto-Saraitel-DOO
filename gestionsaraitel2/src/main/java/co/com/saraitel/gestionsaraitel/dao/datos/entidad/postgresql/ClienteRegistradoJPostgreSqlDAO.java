
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteRegistradoJDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoJEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PrefijoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteRegistradoJPostgreSqlDAO extends SqlDAO implements ClienteRegistradoJDAO {

	public ClienteRegistradoJPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ClienteRegistradoJEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.ClienteRegistradoJPostgreSqlDAO.SQL_INSERTAR, CatalogoMensajes.ClienteRegistradoJPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_CLIENTE_REGISTRADO_JURIDICO,
				CatalogoMensajes.ClienteRegistradoJPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_CLIENTE_REGISTRADO_JURIDICO, entidad.getId(),
				entidad.getClienteRegistrado().getId(), entidad.getPrefijo().getId(),
				entidad.getTelefono(), entidad.getNit(), entidad.getRazonSocial(), entidad.getCorreo(),
				entidad.getTelefonoConfirmado(), entidad.getCorreoConfirmado());
	}

	@Override
	public ClienteRegistradoJEntidad consultarPorId(final UUID id) {
		var filtro = new ClienteRegistradoJEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new ClienteRegistradoJEntidad());
	}

	@Override
	public List<ClienteRegistradoJEntidad> consultarPorFiltro(final ClienteRegistradoJEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new ClienteRegistradoJEntidad());

		var consulta = new FiltroSql(CatalogoSentenciasSql.ClienteRegistradoJPostgreSqlDAO.SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conId("\"ClienteRegistrado_id\"", filtroSeguro.getClienteRegistrado().getId())
				.conId("\"Prefijo_id\"", filtroSeguro.getPrefijo().getId())
				.conTexto("\"Telefono\"", filtroSeguro.getTelefono()).conTexto("\"Nit\"", filtroSeguro.getNit())
				.conTexto("\"RazonSocial\"", filtroSeguro.getRazonSocial())
				.conTexto("\"Correo\"", filtroSeguro.getCorreo())
				.conBooleano("\"TelefonoConfirmado\"", filtroSeguro.getTelefonoConfirmado(), false)
				.conBooleano("\"CorreoConfirmado\"", filtroSeguro.getCorreoConfirmado(), false);

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajes.ClienteRegistradoJPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES_REGISTRADOS_JURIDICOS,
				CatalogoMensajes.ClienteRegistradoJPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_REGISTRADOS_JURIDICOS);
	}

	@Override
	public List<ClienteRegistradoJEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.ClienteRegistradoJPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.ClienteRegistradoJPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES_REGISTRADOS_JURIDICOS,
				CatalogoMensajes.ClienteRegistradoJPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_REGISTRADOS_JURIDICOS);
	}

	@Override
	public void actualizar(final UUID id, final ClienteRegistradoJEntidad entidad) {

		ejecutarActualizacion(CatalogoSentenciasSql.ClienteRegistradoJPostgreSqlDAO.SQL_ACTUALIZAR, CatalogoMensajes.ClienteRegistradoJPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_CLIENTE_REGISTRADO_JURIDICO,
				CatalogoMensajes.ClienteRegistradoJPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_CLIENTE_REGISTRADO_JURIDICO,
				entidad.getClienteRegistrado().getId(), entidad.getPrefijo().getId(),
				entidad.getTelefono(), entidad.getNit(), entidad.getRazonSocial(), entidad.getCorreo(),
				entidad.getTelefonoConfirmado(), entidad.getCorreoConfirmado(), id);
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(CatalogoSentenciasSql.ClienteRegistradoJPostgreSqlDAO.SQL_ELIMINAR, CatalogoMensajes.ClienteRegistradoJPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ELIMINANDO_CLIENTE_REGISTRADO_JURIDICO,
				CatalogoMensajes.ClienteRegistradoJPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_CLIENTE_REGISTRADO_JURIDICO, id);
	}

	private ClienteRegistradoJEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new ClienteRegistradoJEntidad();

		entidad.setId(leerUUID(resultados, "id"));

		var cliente = new ClienteEntidad(leerUUID(resultados, "Cliente_id"), true);
		var clienteRegistrado = new ClienteRegistradoEntidad(leerUUID(resultados, "ClienteRegistrado_id"), cliente,
				false);
		entidad.setClienteRegistrado(clienteRegistrado);

		var prefijo = new PrefijoEntidad();
		prefijo.setId(leerUUID(resultados, "Prefijo_id"));
		entidad.setPrefijo(prefijo);

		entidad.setTelefono(resultados.getString("Telefono"));
		entidad.setNit(resultados.getString("Nit"));
		entidad.setRazonSocial(resultados.getString("RazonSocial"));
		entidad.setCorreo(resultados.getString("Correo"));
		entidad.setTelefonoConfirmado(resultados.getBoolean("TelefonoConfirmado"));
		entidad.setCorreoConfirmado(resultados.getBoolean("CorreoConfirmado"));

		return entidad;
	}
}
