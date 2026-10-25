package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.ClienteDominio;

public interface ClienteNegocio {

	void registrarInformacionNuevoCliente(ClienteDominio datos);

	void darBajaInformacionClienteExistente(UUID id);

	List<ClienteDominio> consultarPorFiltro(ClienteDominio filtro);

	List<ClienteDominio> consultarTodos();

	ClienteDominio consultarPorid(UUID id);
}
