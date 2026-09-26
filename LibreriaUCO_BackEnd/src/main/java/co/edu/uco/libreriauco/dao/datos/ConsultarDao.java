package co.edu.uco.libreriauco.dao.datos;

import java.util.List;

public interface ConsultarDao<E, ID> {
	
	E consultarPorId(ID id);
	
	List<E> consultarPorFiltro(E filtro);
	
	List<E> consultarTodos();
}
