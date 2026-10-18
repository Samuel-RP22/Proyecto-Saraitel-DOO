
package co.com.saraitel.gestionsaraitel.dao.datos.entidad;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelDatosExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilSQL;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public abstract class SqlDAO {

	private Connection conexion;

	protected SqlDAO(final Connection conexion) {
	    setConexion(conexion);
	}

	protected Connection getConexion() {
	    return conexion;
	}

	private void setConexion(final Connection conexion) {
	    if (!UtilSQL.conexionEstaAbierta(conexion)) {
	        throw GestionSaraitelDatosExcepcion.crear(
	            "No fue posible establecer la conexión con la base de datos.",
	            "La conexión SQL es nula o está cerrada."
	        );
	    }

	    this.conexion = conexion;
	}

    protected void ejecutarActualizacion(
            final String sql,
            final String mensajeUsuario,
            final Object... parametros) {

        try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {
            asignarParametros(sentencia, Arrays.asList(parametros));
            sentencia.executeUpdate();

        } catch (SQLException excepcion) {
            throw GestionSaraitelDatosExcepcion.crear(
                mensajeUsuario,
                excepcion.getMessage(),
                excepcion
            );
        }
    }

    protected <E> List<E> ejecutarConsulta(
            final String sql,
            final List<Object> parametros,
            final MapeadorFila<E> mapeador,
            final String mensajeUsuario) {

        List<E> resultadosConsulta = new ArrayList<>();

        try (PreparedStatement sentencia = getConexion().prepareStatement(sql)) {
            asignarParametros(sentencia, parametros);

            try (ResultSet resultados = sentencia.executeQuery()) {
                while (resultados.next()) {
                    resultadosConsulta.add(mapeador.mapear(resultados));
                }
            }

        } catch (SQLException excepcion) {
            throw GestionSaraitelDatosExcepcion.crear(
                mensajeUsuario,
                excepcion.getMessage(),
                excepcion
            );
        }

        return resultadosConsulta;
    }

    protected static UUID leerUUID(
            final ResultSet resultados,
            final String columna) throws SQLException {

        return UtilUUID.convertirAUUID(resultados.getString(columna));
    }

    private static void asignarParametros(
            final PreparedStatement sentencia,
            final List<Object> parametros) throws SQLException {

        for (int i = 0; i < parametros.size(); i++) {
            sentencia.setObject(i + 1, parametros.get(i));
        }
    }
}
