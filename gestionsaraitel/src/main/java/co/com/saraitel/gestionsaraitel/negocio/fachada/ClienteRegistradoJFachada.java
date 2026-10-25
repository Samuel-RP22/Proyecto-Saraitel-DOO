package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.ClienteRegistradoJDTO;

public interface ClienteRegistradoJFachada {

	void registrarInformacionNuevoClienteJuridico(ClienteRegistradoJDTO datos);

	List<ClienteRegistradoJDTO> consultarPorFiltro(ClienteRegistradoJDTO filtro);

	List<ClienteRegistradoJDTO> consultarTodos();

	ClienteRegistradoJDTO consultarPorId(UUID id);
}
