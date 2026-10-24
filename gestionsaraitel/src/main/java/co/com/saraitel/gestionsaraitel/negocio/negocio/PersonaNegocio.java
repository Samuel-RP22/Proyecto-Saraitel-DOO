package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;

public interface PersonaNegocio {

	void registrarInformacionNuevaPersona(PersonaDominio datos);

	void modificarInformacionPersonaExistente(UUID id, PersonaDominio datos);

	void darBajaInformacionPersonaExistente(UUID id);

	List<PersonaDominio> consultarPorFiltro(PersonaDominio filtro);

	List<PersonaDominio> consultarTodos();

	PersonaDominio consultarPorid(UUID id);
}
