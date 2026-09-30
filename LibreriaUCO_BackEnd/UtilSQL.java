package co.com.saraitel.gestionsaraitel.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOTranversalException;

public class UtilSQL {
	
	private UtilSQL() {
	}
	public static boolean conexionEstaAbierta(Connection conexion) {
		try {
			return(!conexionEstaVacia(conesxion) && !conexion.isClosed());
		}	catch (SQLException excepcion) {
			var mensajeUsuario = "";
			
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(), )
			
		} catch	(Exception excepcion) {
			excepcion.printStackTrace();
		}
	}
	
	public static void iniciarTransaccion(Connection conexion) {
		
	}
	
	public static boolean transaccionEstaIniciada(Conecction conexion) {
		return conexionEstaAbierta(conexion) && conexion
	}
	
	public static boolean conexionEstaVacia(Conecction conexion) {
		return UtilObjeto.esNulo(null)
	}

}
