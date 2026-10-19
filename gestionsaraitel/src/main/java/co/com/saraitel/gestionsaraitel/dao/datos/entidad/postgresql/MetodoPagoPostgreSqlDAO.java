
package co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.FiltroSql;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.MetodoPagoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.SqlDAO;
import co.com.saraitel.gestionsaraitel.entidad.MetodoPagoEntidad;

public class MetodoPagoPostgreSqlDAO extends SqlDAO implements MetodoPagoDAO {

	private static final String SQL_CREAR = """
			INSERT INTO saraitel."MetodoPago"
			("id", "Nombre", "EsActivo")
			VALUES (?, ?, ?)
			""";

	private static final String SQL_CONSULTAR_POR_ID = """
			SELECT "id", "Nombre", "EsActivo"
			FROM saraitel."MetodoPago"
			WHERE "id" = ?
			""";

	private static final String SQL_CONSULTAR_POR_FILTRO = """
			SELECT "id", "Nombre", "EsActivo"
			FROM saraitel."MetodoPago"
			""";

	private static final String SQL_CONSULTAR_TODOS = """
			SELECT "id", "Nombre", "EsActivo"
			FROM saraitel."MetodoPago"
			""";

	public MetodoPagoPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final MetodoPagoEntidad entidad) {
		ejecutarActualizacion(SQL_CREAR, "Error al crear el método de pago", entidad.getId().toString(),
				entidad.getNombre(), entidad.getEsActivo());
	}

	@Override
	public MetodoPagoEntidad consultarPorId(final UUID id) {
		List<MetodoPagoEntidad> resultado = ejecutarConsulta(SQL_CONSULTAR_POR_ID, List.of(id.toString()),
				this::mapear, "Error al consultar el método de pago");

		if (resultado.isEmpty()) {
			return new MetodoPagoEntidad();
		} else {
			return resultado.get(0);
		}
	}

	@Override
	public List<MetodoPagoEntidad> consultarPorFiltro(final MetodoPagoEntidad filtro) {

		MetodoPagoEntidad filtroSeguro = filtro == null ? new MetodoPagoEntidad() : filtro;

		FiltroSql filtroSql = new FiltroSql(SQL_CONSULTAR_POR_FILTRO).conId("\"id\"", filtroSeguro.getId())
				.conTexto("\"Nombre\"", filtroSeguro.getNombre())
				.conBooleano("\"EsActivo\"", filtroSeguro.getEsActivo(), true);

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				"Error al consultar métodos de pago");
	}

	@Override
	public List<MetodoPagoEntidad> consultarTodos() {
		return ejecutarConsulta(SQL_CONSULTAR_TODOS, List.of(), this::mapear,
				"Error al consultar los métodos de pago");
	}

	private MetodoPagoEntidad mapear(final ResultSet resultados) throws SQLException {

		MetodoPagoEntidad entidad = new MetodoPagoEntidad();

		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("Nombre"));
		entidad.setEsActivo(resultados.getBoolean("EsActivo"));

		return entidad;
	}
}
