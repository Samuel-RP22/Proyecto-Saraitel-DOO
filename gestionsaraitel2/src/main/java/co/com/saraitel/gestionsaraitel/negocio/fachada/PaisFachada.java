package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.PaisDTO;

public interface PaisFachada {

	List<PaisDTO> consultarPorFiltro(PaisDTO filtro);

	List<PaisDTO> consultarTodos();

	PaisDTO consultarPorId(UUID id);
}
