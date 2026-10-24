package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.ClienteDTO;

public interface ClienteFachada {
	
	void registrarInformacionNuevoCliente(ClienteDTO datos);
	
	void darBajaInformacionClienteExistente(UUID id);
	
	List<ClienteDTO> consultarPorFiltro(ClienteDTO filtro);
	
	List<ClienteDTO> consultarTodos();

	ClienteDTO consultarPorId(UUID id);
}