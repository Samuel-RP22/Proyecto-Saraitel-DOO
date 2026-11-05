package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoDominio;

public interface ClienteRegistradoNegocio {

	void registrarInformacionNuevoClienteRegistrado(ClienteRegistradoDominio datos);

	void darBajaInformacionClienteRegistradoExistente(UUID id);

	List<ClienteRegistradoDominio> consultarPorFiltro(ClienteRegistradoDominio filtro);

	List<ClienteRegistradoDominio> consultarTodos();

	ClienteRegistradoDominio consultarPorId(UUID id);
}
