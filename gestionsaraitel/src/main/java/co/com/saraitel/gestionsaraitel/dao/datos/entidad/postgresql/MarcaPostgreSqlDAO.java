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
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoSentenciasSql;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public class MarcaPostgreSqlDAO extends SqlDAO implements MarcaDAO {

	public MarcaPostgreSqlDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(final MarcaEntidad entidad) {
		ejecutarActualizacion(CatalogoSentenciasSql.MarcaPostgreSqlDAO.SQL_INSERTAR,
				CatalogoMensajes.MarcaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CREANDO_MARCA,
				CatalogoMensajes.MarcaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_MARCA, entidad.getId(),
				entidad.getNombre(), entidad.getEsActivo());
	}

	@Override
	public MarcaEntidad consultarPorId(final UUID id) {
		MarcaEntidad filtro = new MarcaEntidad();
		filtro.setId(id);

		List<MarcaEntidad> resultado = consultarPorFiltro(filtro);

		return obtenerPrimeroOValorDefecto(resultado, new MarcaEntidad());
	}

	@Override
	public List<MarcaEntidad> consultarPorFiltro(final MarcaEntidad filtro) {

		MarcaEntidad filtroSeguro = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new MarcaEntidad());

		FiltroSql filtroSql = new FiltroSql(CatalogoSentenciasSql.MarcaPostgreSqlDAO.SQL_CONSULTAR)
				.conId("\"id\"", filtroSeguro.getId()).conTexto("\"Nombre\"", filtroSeguro.getNombre())
				.conBooleano("\"EsActivo\"", filtroSeguro.getEsActivo(), true);

		return ejecutarConsulta(filtroSql.getSentencia(), filtroSql.getParametros(), this::mapear,
				CatalogoMensajes.MarcaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_MARCAS,
				CatalogoMensajes.MarcaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_MARCAS);
	}

	@Override
	public List<MarcaEntidad> consultarTodos() {
		return ejecutarConsulta(CatalogoSentenciasSql.MarcaPostgreSqlDAO.SQL_CONSULTAR, List.of(), this::mapear,
				CatalogoMensajes.MarcaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_MARCAS,
				CatalogoMensajes.MarcaPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_MARCAS);
	}

	private MarcaEntidad mapear(final ResultSet resultados) throws SQLException {

		MarcaEntidad entidad = new MarcaEntidad();
		entidad.setId(leerUUID(resultados, "id"));
		entidad.setNombre(resultados.getString("Nombre"));
		entidad.setEsActivo(resultados.getBoolean("EsActivo"));

		return entidad;
	}
}
