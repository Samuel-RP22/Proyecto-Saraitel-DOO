package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.PrefijoDTO;

public interface PrefijoFachada {

	List<PrefijoDTO> consultarPorFiltro(PrefijoDTO filtro);

	List<PrefijoDTO> consultarTodos();

	PrefijoDTO consultarPorId(UUID id);
}