package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.MarcaDTO;

public interface MarcaFachada {

	void registrarInformacionNuevaMarca(MarcaDTO datos);

	List<MarcaDTO> consultarPorFiltro(MarcaDTO filtro);

	List<MarcaDTO> consultarTodos();

	MarcaDTO consultarPorId(UUID id);
}