package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.CiudadDTO;

public interface CiudadFachada {

	List<CiudadDTO> consultarPorFiltro(CiudadDTO filtro);

	List<CiudadDTO> consultarTodos();

	CiudadDTO consultarPorId(UUID id);
}
