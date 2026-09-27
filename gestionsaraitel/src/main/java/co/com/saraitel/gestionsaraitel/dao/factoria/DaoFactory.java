package co.com.saraitel.gestionsaraitel.dao.factoria;

import java.sql.Connection;

import co.edu.uco.libreriauco.dao.datos.entidad.*;

public abstract class DaoFactory {
	
	private Connection conexion;
	
	protected DaoFactory() {
		abrirConexion();
	}
	
	protected DaoFactory(Connection conexion) {
		setConexion(conexion);
	}
	
	protected Connection getConexion() {
		return conexion;
	}
	
	protected void setConexion(Connection conexion) {
		// Tarea: Asegurar que la conexión esté abierta y sea válida
		this.conexion = conexion;
	}
	
	protected abstract void abrirConexion();
	
	public void cerrarConexion() {
		// Tarea: ¿Como se cierra la conexión de forma segura?
	}
	
	public void iniciarTransaccion() {
		// Tarea: ¿Como se inicia una transacción de forma segura?
	}
	
	public void confirmarTransaccion() {
		// Tarea: ¿Como se confirma una transacción de forma segura?
	}
	
	public void cancelarTransaccion() {
		// Tarea: ¿Como se cancela una transacción de forma segura?
	}
	
	public abstract PaisDao obtenerPaisDao();
	
	public abstract DepartamentoDao obtenerDepartamentoDao();
	
}
