package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoNDominio;

public interface ClienteRegistradoNNegocio {

	void registrarInformacionNuevoClienteNatural(ClienteRegistradoNDominio datos);

	List<ClienteRegistradoNDominio> consultarPorFiltro(ClienteRegistradoNDominio filtro);

	List<ClienteRegistradoNDominio> consultarTodos();

	ClienteRegistradoNDominio consultarPorid(UUID id);
}
