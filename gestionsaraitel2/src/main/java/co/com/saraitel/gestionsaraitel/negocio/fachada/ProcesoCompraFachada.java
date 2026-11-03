package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.ProcesoCompraDTO;

public interface ProcesoCompraFachada {

	void registrarInformacionNuevoProcesoCompra(ProcesoCompraDTO datos);

	List<ProcesoCompraDTO> consultarPorFiltro(ProcesoCompraDTO filtro);

	List<ProcesoCompraDTO> consultarTodos();

	ProcesoCompraDTO consultarPorId(UUID id);

	void anularProcesosCompraVencidos();
}
