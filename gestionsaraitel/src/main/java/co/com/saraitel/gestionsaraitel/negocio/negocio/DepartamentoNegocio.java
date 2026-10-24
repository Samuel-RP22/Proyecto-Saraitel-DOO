package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.DepartamentoDominio;

public interface DepartamentoNegocio {
	
	List<DepartamentoDominio> consultarPorFiltro(DepartamentoDominio filtro);
	
	List<DepartamentoDominio> consultarTodos();

	DepartamentoDominio consultarPorid(UUID id);
}
