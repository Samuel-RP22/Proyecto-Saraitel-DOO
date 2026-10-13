
package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionsaraitelTransversalException;

public final class UtilSQL {

    private UtilSQL() {
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

    public static void iniciarTransaccion(Connection conexion) {

        if (!conexionEstaAbierta(conexion)) {
            var mensajeUsuario = CatalogoMensajes.DAOFactory.USUARIO_ERROR_FUENTE_INFORMACION_NO_HABILITADA;
            throw GestionsaraitelTransversalException.crear(mensajeUsuario);
        }

        if (transaccionEstaIniciada(conexion)) {
            var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
            throw GestionsaraitelTransversalException.crear(mensajeUsuario);
        }

        try {
            conexion.setAutoCommit(false);
        } catch (SQLException excepcion) {
            var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
            throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
        }
    }

    public static void confirmarTransaccion(Connection conexion) {
        if (!transaccionEstaIniciada(conexion)) {
            var mensajeUsuario = "No es posible confirmar una transaccion que no fue iniciada";
            throw GestionsaraitelTransversalException.crear(mensajeUsuario);
        }

        try {
            conexion.commit();
            conexion.setAutoCommit(true);
        } catch (SQLException excepcion) {
            var mensajeUsuario = "No fue posible confirmar la transaccion SQL";
            throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
        }
    }

    public static void cancelarTransaccion(Connection conexion) {
        if (!transaccionEstaIniciada(conexion)) {
            var mensajeUsuario = "No es posible cancelar una transaccion que no fue iniciada";
            throw GestionsaraitelTransversalException.crear(mensajeUsuario);
        }

        try {
            conexion.rollback();
            conexion.setAutoCommit(true);
        } catch (SQLException excepcion) {
            var mensajeUsuario = "No fue posible cancelar la transaccion SQL";
            throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
        }
    }

    public static void cerrarConexion(Connection conexion) {
        if (!conexionEstaAbierta(conexion)) {
            return;
        }

        try {
            if (transaccionEstaIniciada(conexion)) {
                conexion.rollback();
            }

            conexion.close();
        } catch (SQLException excepcion) {
            var mensajeUsuario = "No fue posible cerrar la conexion SQL de forma segura";
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

    public static boolean conexionEstaVacia(Connection conexion) {
        return UtilObjeto.esNulo(conexion);
    }
}