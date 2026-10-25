package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoJDominio;

public interface ClienteRegistradoJNegocio {

	void registrarInformacionNuevoClienteJuridico(ClienteRegistradoJDominio datos);

	List<ClienteRegistradoJDominio> consultarPorFiltro(ClienteRegistradoJDominio filtro);

	List<ClienteRegistradoJDominio> consultarTodos();

	ClienteRegistradoJDominio consultarPorid(UUID id);
}
