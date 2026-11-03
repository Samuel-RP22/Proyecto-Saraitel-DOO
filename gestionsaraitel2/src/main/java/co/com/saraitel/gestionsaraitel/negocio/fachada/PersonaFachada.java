package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.PersonaDTO;

public interface PersonaFachada {

	void registrarInformacionNuevaPersona(PersonaDTO datos);

	void modificarInformacionPersonaExistente(UUID id, PersonaDTO datos);

	void darBajaInformacionPersonaExistente(UUID id);

	List<PersonaDTO> consultarPorFiltro(PersonaDTO filtro);

	List<PersonaDTO> consultarTodos();

	PersonaDTO consultarPorId(UUID id);
}
