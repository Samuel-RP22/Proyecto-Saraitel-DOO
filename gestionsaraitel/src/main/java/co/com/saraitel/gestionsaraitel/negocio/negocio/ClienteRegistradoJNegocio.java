package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoJDominio;

public interface ClienteRegistradoJNegocio {

	void registrarInformacionNuevoClienteJuridico(ClienteRegistradoJDominio datos);

	void modificarInformacionClienteJuridicoExistente(UUID id, ClienteRegistradoJDominio datos);

	void darBajaInformacionClienteJuridicoExistente(UUID id);

	List<ClienteRegistradoJDominio> consultarPorFiltro(ClienteRegistradoJDominio filtro);

	List<ClienteRegistradoJDominio> consultarTodos();

	ClienteRegistradoJDominio consultarPorId(UUID id);
}
