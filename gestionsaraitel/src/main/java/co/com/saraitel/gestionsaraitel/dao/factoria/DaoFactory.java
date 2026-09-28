package co.com.saraitel.gestionsaraitel.dao.factoria;

import java.sql.Connection;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DepartamentoDao;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PaisDao;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilSQL;

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
		UtilSQL.cerrarConexion(conexion);
	}
	
	public void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}
	
	public void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}
	
	public void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
	}
	
	public abstract PaisDao obtenerPaisDao();
	
	public abstract DepartamentoDao obtenerDepartamentoDao();
	
}
