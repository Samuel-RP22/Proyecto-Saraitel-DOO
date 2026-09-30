package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionsaraitelTransversalException;

public class UtilSQL {
	
	private UtilSQL() {
	}
	public static boolean conexionEstaAbierta(Connection conexion) {
		try {
			return(!conexionEstaVacia(conexion) && !conexion.isClosed());
		}	catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
		
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
			
		} catch	(Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}
	
	public static void iniciarTransaccion(Connection conexion) {
		
		if(transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario);
		}
		
	}
	
	public static void confirmarTransaccion(Connection conexion) {
		if(!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = "Mensaje de error porque no es posible confirmar una transaccion que no fue iniciada";
			throw GestionsaraitelTransversalException.crear(mensajeUsuario);}
	}

	public static void cancelarTransaccion(Connection conexion) {
		if(!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = "Mensaje de error porque no es posible cancelar una transaccion que no fue iniciada";
			throw GestionsaraitelTransversalException.crear(mensajeUsuario);}
		}

	public static void cerrarConexion(Connection conexion) {
		if(!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = "Mensaje de error porque no es posible cerrar una conexion que no esta abierta";
			throw GestionsaraitelTransversalException.crear(mensajeUsuario);}
			}

	
	
	public static boolean transaccionEstaIniciada(Connection conexion) {
		try {
			return(!conexionEstaAbierta(conexion) && !conexion.isClosed());
		}	catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
			
		} catch	(Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw GestionsaraitelTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}
	
	public static boolean conexionEstaVacia(Connection conexion) {
		return UtilObjeto.esNulo(conexion);}
	}


