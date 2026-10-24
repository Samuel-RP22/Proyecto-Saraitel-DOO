package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.DepartamentoDTO;

public interface CiudadFachada {
	
	List<DepartamentoDTO> consultarPorFiltro(DepartamentoDTO filtro);
	
	List<DepartamentoDTO> consultarTodos();

	DepartamentoDTO consultarPorId(UUID id);
}