package co.edu.uco.libreriauco.dao.factoria.impl;

import java.sql.Connection;
import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDao;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDao;
import co.edu.uco.libreriauco.dao.datos.entidad.postgresql.PaisPostgreSqlDao;
import co.edu.uco.libreriauco.dao.datos.entidad.postgresql.DepartamentoPostgreSqlDao;
import co.edu.uco.libreriauco.dao.factoria.DaoFactory;

public class PostgreSqlDaoFactory extends DaoFactory {

	@Override
	protected void abrirConexion() {
		// TODO Auto-generated method stub
		Connection conexion = null;
		setConexion(conexion);	
	}

	@Override
	public PaisDao obtenerPaisDao() {
		// TODO Auto-generated method stub
		return new PaisPostgreSqlDao();
	}

	@Override
	public DepartamentoDao obtenerDepartamentoDao() {
		// TODO Auto-generated method stub
		return new DepartamentoPostgreSqlDao();
	}

}
