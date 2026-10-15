package co.com.saraitel.gestionsaraitel.dao.factoria.impl;

import java.sql.Connection;

import co.com.saraitel.gestionsaraitel.dao.datos.entidad.DepartamentoDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.PaisDAO;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.DepartamentoPostgreSqlDao;
import co.com.saraitel.gestionsaraitel.dao.datos.entidad.postgresql.PaisPostgreSqlDao;
import co.com.saraitel.gestionsaraitel.dao.factoria.DaoFactory;

public class PostgreSqlDaoFactory2 extends DaoFactory {

	@Override
	protected void abrirConexion() {
		//Tarea:cómo abrir una conexion con postgresql desde java?
		Connection conexion = null;
		setConexion(conexion);	
	}

	@Override
	public PaisDAO obtenerPaisDao() {
		return new PaisPostgreSqlDao();
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDao() {
		return new DepartamentoPostgreSqlDao();
	}

}
