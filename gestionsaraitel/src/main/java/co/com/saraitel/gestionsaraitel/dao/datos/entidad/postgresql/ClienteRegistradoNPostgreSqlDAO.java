
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.ClienteRegistradoNDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoNEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PrefijoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.TipoDocumentoEntidad;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajesSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class ClienteRegistradoNPostgreSqlDAO extends SqlDAO implements ClienteRegistradoNDAO {

	public ClienteRegistradoNPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final ClienteRegistradoNEntidad entidad) {
		ejecutarActualizacion(CatalogoMensajesSql.ClienteRegistradoNPostgreSqlDAO.SQL_INSERTAR, CatalogoMensajesSql.ClienteRegistradoNPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_CLIENTE_REGISTRADO,
				CatalogoMensajesSql.ClienteRegistradoNPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_CLIENTE_REGISTRADO, entidad.getId(),
				entidad.getClienteRegistrado().getId(), entidad.getPersona().getId());
	}

	@Override
	public ClienteRegistradoNEntidad consultarPorId(final UUID id) {
		var filtro = new ClienteRegistradoNEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultados, new ClienteRegistradoNEntidad());
	}

	@Override
	public List<ClienteRegistradoNEntidad> consultarPorFiltro(final ClienteRegistradoNEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new ClienteRegistradoNEntidad());

		var consulta = new FiltroSql(CatalogoMensajesSql.ClienteRegistradoNPostgreSqlDAO.SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conId("\"ClienteRegistrado_id\"", filtroSeguro.getClienteRegistrado().getId())
				.conId("\"Persona_id\"", filtroSeguro.getPersona().getId());

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				CatalogoMensajesSql.ClienteRegistradoNPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES_REGISTRADOS, CatalogoMensajesSql.ClienteRegistradoNPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_REGISTRADOS);
	}

	@Override
	public List<ClienteRegistradoNEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoMensajesSql.ClienteRegistradoNPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear, CatalogoMensajesSql.ClienteRegistradoNPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES_REGISTRADOS,
				CatalogoMensajesSql.ClienteRegistradoNPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_REGISTRADOS);
	}

	@Override
	public void eliminar(final UUID id) {
		ejecutarActualizacion(CatalogoMensajesSql.ClienteRegistradoNPostgreSqlDAO.SQL_ELIMINAR, CatalogoMensajesSql.ClienteRegistradoNPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_ELIMINANDO_CLIENTE_REGISTRADO,
				CatalogoMensajesSql.ClienteRegistradoNPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_CLIENTE_REGISTRADO, id);
	}

	private ClienteRegistradoNEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new ClienteRegistradoNEntidad();
		entidad.setId(leerUUID(resultados, "id"));

		var cliente = new ClienteEntidad(leerUUID(resultados, "Cliente_id"), true);
		var clienteRegistrado = new ClienteRegistradoEntidad(leerUUID(resultados, "ClienteRegistrado_id"), cliente,
				true);
		entidad.setClienteRegistrado(clienteRegistrado);

		var tipoDocumento = new TipoDocumentoEntidad();
		tipoDocumento.setId(leerUUID(resultados, "TipoDocumento_id"));

		var prefijo = new PrefijoEntidad();
		prefijo.setId(leerUUID(resultados, "Prefijo_id"));

		var persona = new PersonaEntidad();
		persona.setId(leerUUID(resultados, "Persona_id"));
		persona.setTipoDocumento(tipoDocumento);
		persona.setPrefijo(prefijo);
		persona.setNumeroDocumento(resultados.getString("NumeroDocumento"));
		persona.setTelefono(resultados.getString("Telefono"));
		persona.setNombre(resultados.getString("Nombre"));
		persona.setApellido(resultados.getString("Apellido"));
		persona.setCorreo(resultados.getString("Correo"));
		entidad.setPersona(persona);

		return entidad;
	}
}
