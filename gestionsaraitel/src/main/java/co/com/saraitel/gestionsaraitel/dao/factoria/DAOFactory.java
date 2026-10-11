package co.com.saraitel.gestionsaraitel.dao.factoria;

import java.sql.Connection;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DepartamentoDao;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PaisDao;
import co.com.saraitel.gestionsaraitel.dao.factoria.enums.FactoriaEnum;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilSQL;

public abstract class DAOFactory {
	
	private Connection conexion;
	private static FactoriaEnum factoria = FactoriaEnum.POSTGRESQL;
	
	public static DAOFactory obtenerFactoria() {
		switch (factoria) {
		case SQLSERVER:
			return new SqlServerDAOFactory();
		default:
			CatalogoMensajes.DAOFactory.USUARIO_ERROR_FUENTE_INFORMACION_NO_HABILITADA;
			throw GestionSaraitelException.crear()
		}
	}
	protected DAOFactory() {
		abrirConexion();
	}
	
	protected DAOFactory(Connection conexion) {
		setConexion(conexion);
	}
	
	protected Connection getConexion() {
		return conexion;
	}
	
	protected void setConexion(Connection conexion) {
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
