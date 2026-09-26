package co.edu.uco.libreriauco.dao.datos.entidad.postgresql;

import java.util.UUID;
import java.util.List;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDao;
import co.edu.uco.libreriauco.entidad.DepartamentoEntidad;

public class DepartamentoPostgreSqlDao	implements DepartamentoDao {

	@Override
	public void crear(DepartamentoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DepartamentoEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoEntidad> consultarPorFiltro(DepartamentoEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, DepartamentoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}
	
}