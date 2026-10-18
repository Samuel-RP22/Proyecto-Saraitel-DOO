package co.com.saraitel.gestionsaraitel.dao.factoria;

import java.sql.Connection;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.CiudadDao;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DepartamentoDao;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PaisDao;
import co.com.saraitel.gestionsaraitel.dao.factoria.enums.FactoriaEnum;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilSQL;

public abstract class DAOFactory2 {
	
	private Connection conexion;
	private static FactoriaEnum factoria = FactoriaEnum.POSTGRESQL;
	
	public static DAOFactory2 obtenerFactoria() {
		switch (factoria) {
		case SQLSERVER:
			return new SqlServerDAOFactory();
		default:
			CatalogoMensajes.DAOFactory.USUARIO_ERROR_FUENTE_INFORMACION_NO_HABILITADA;
			throw GestionSaraitelException.crear()
		}
	}
	protected DAOFactory2() {
		abrirConexion();
	}
	
	protected DAOFactory2(Connection conexion) {
		setConexion(conexion);
	}
	
	protected Connection getConexion() {
		return conexion;
	}
	
	protected void setConexion(Connection conexion) {
		this.conexion = conexion;
		//Tarea: asegurar que la conexion esté abierta y sea válida
	}
	
	protected abstract void abrirConexion();
	
	public void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
		//Tarea: cómo se cierra la conexion de forma segura?
	}
	
	public void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
		//Tarea: cómo se inicia una transaccion de forma segura?
	}
	
	public void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
		//Tarea: cómo se cofirma una transaccion de forma segura?
	}
	
	public void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
		//Tarea: cómo se cancela una transaccion de forma segura?
	}
	
}
