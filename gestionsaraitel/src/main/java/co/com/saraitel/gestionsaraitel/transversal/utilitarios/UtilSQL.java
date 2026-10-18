
package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;

import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionsaraitelTransversalException;

public final class UtilSQL {

	private UtilSQL() {
	}

	public static boolean conexionEstaVacia(Connection conexion) {
		return UtilObjeto.esNulo(conexion);
	}

	public static boolean conexionEstaAbierta(Connection conexion) {
		try {
			return (!conexionEstaVacia(conexion) && !conexion.isClosed());
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	public static boolean transaccionEstaIniciada(Connection conexion) {
		try {
			return (conexionEstaAbierta(conexion) && !conexion.getAutoCommit());
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	public static void iniciarTransaccion(Connection conexion) {
		if (!conexionEstaAbierta(conexion) || transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario);
		}

		try {
			conexion.setAutoCommit(false);
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_INICIANDO_TRANSACCION_SQL;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_INICIANDO_TRANSACCION_SQL;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}

	}

	public static void confirmarTransaccion(Connection conexion) {
		if (!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario);
		}

		try {
			conexion.commit();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CONFIRMANDO_TRANSACCION_SQL;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONFIRMANDO_TRANSACCION_SQL;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	public static void cancelarTransaccion(Connection conexion) {
		if (!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario);
		}

		try {
			conexion.rollback();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CANCELANDO_TRANSACCION_SQL;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CANCELANDO_TRANSACCION_SQL;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	public static void cerrarConexion(Connection conexion) {
		if (!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CERRAR_CONEXION_SQL;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario);
		}

		try {
			conexion.close();
		} catch (SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CERRANDO_CONEXION_SQL;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);
		} catch (Exception exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CERRANDO_CONEXION_SQL;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);
		}
	}
}