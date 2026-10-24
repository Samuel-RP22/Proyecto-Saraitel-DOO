package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;

public interface PersonaNegocio {

	void registrarInformacionNuevoPais(PersonaDominio datos);

	void modificarInformacionPaisExistente(UUID id, PersonaDominio datos);

	void darBajaInformacionPaisExistente(UUID id);

	List<PersonaDominio> consultarPorFiltro(PersonaDominio filtro);

	List<PersonaDominio> consultarTodos();

	PersonaDominio consultarPorid(UUID id);
}
