package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.DetalleCompraDTO;

public interface DetalleCompraFachada {
	
	void registrarInformacionNuevoDetalleCompra(DetalleCompraDTO datos);
	
	void modificarInformacionDetalleCompraExistente(UUID id, DetalleCompraDTO datos);
	
	void darBajaInformacionDetalleCompraExistente(UUID id);
	
	List<DetalleCompraDTO> consultarPorFiltro(DetalleCompraDTO filtro);
	
	List<DetalleCompraDTO> consultarTodos();

	DetalleCompraDTO consultarPorId(UUID id);
}