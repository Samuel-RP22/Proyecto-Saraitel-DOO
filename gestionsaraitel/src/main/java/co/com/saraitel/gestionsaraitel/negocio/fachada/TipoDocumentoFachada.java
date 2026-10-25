package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.TipoDocumentoDTO;

public interface TipoDocumentoFachada {

	List<TipoDocumentoDTO> consultarPorFiltro(TipoDocumentoDTO filtro);

	List<TipoDocumentoDTO> consultarTodos();

	TipoDocumentoDTO consultarPorId(UUID id);
}
