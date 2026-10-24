package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.SedeDTO;

public interface SedeFachada {

	void registrarInformacionNuevaSede(SedeDTO datos);

	void modificarInformacionSedeExistente(UUID id, SedeDTO datos);

	void darBajaInformacionSedeExistente(UUID id);

	List<SedeDTO> consultarPorFiltro(SedeDTO filtro);

	List<SedeDTO> consultarTodos();

	SedeDTO consultarPorId(UUID id);
}