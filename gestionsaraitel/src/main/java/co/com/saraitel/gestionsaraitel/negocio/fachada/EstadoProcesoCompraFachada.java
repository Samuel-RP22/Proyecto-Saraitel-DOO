package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.EstadoProcesoCompraDTO;

public interface EstadoProcesoCompraFachada {

	void registrarInformacionNuevoEstadoProcesoCompra(EstadoProcesoCompraDTO datos);

	List<EstadoProcesoCompraDTO> consultarPorFiltro(EstadoProcesoCompraDTO filtro);

	List<EstadoProcesoCompraDTO> consultarTodos();

	EstadoProcesoCompraDTO consultarPorId(UUID id);
}
