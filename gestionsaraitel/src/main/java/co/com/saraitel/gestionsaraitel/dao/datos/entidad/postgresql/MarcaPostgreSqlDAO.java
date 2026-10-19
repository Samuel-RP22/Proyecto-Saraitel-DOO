
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.MarcaDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.sql.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.MarcaEntidad;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class MarcaPostgreSqlDAO extends SqlDAO implements MarcaDAO {

	private static final String SQL_INSERTAR = "INSERT INTO saraitel.\"Marca\" "
			+ "(\"id\", \"Nombre\", \"EsActivo\") VALUES (?, ?, ?)";

	private static final String SQL_CONSULTAR = "SELECT \"id\", \"Nombre\", \"EsActivo\" " + "FROM saraitel.\"Marca\"";

	public MarcaPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final MarcaEntidad entidad) {
		ejecutarActualizacion(SQL_INSERTAR, "Error al crear marca.",
				"Error NO CONTROLADO al crear marca.", entidad.getId(), entidad.getNombre(),
				entidad.getEsActivo());
	}

	@Override
	public MarcaEntidad consultarPorId(final UUID id) {
		var filtro = new MarcaEntidad();
		filtro.setId(id);

		var resultados = consultarPorFiltro(filtro);

		return resultados.isEmpty() ? new MarcaEntidad() : resultados.get(0);
	}

	@Override
	public List<MarcaEntidad> consultarPorFiltro(final MarcaEntidad filtro) {

		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new MarcaEntidad());

		var consulta = new FiltroSql(SQL_CONSULTAR).conId("\"id\"", filtroSeguro.getId())
				.conTexto("\"Nombre\"", filtroSeguro.getNombre())
				.conBooleano("\"EsActivo\"", filtroSeguro.getEsActivo(), true);

		return ejecutarConsulta(consulta.getSentencia(), consulta.getParametros(), this::mapear,
				"Error al consultar marcas.",
				"Error NO CONTROLADO al consultar marcas.");
	}

	@Override
	public List<MarcaEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR, List.of(), this::mapear, "Error al consultar marcas.",
				"Error NO CONTROLADO al consultar marcas.");
	}

	private MarcaEntidad mapear(final ResultSet resultados) throws SQLException {

		var entidad = new MarcaEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("Nombre"));
		entidad.setEsActivo(resultados.getBoolean("EsActivo"));

		return entidad;
	}
}
