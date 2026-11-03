package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.ClienteRegistradoNDTO;

public interface ClienteRegistradoNFachada {

	void registrarInformacionNuevoClienteNatural(ClienteRegistradoNDTO datos);

	List<ClienteRegistradoNDTO> consultarPorFiltro(ClienteRegistradoNDTO filtro);

	List<ClienteRegistradoNDTO> consultarTodos();

	ClienteRegistradoNDTO consultarPorId(UUID id);
}
