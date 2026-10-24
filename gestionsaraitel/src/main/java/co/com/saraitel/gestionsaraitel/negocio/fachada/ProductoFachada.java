package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.ProductoDTO;

public interface ProductoFachada {

	void registrarInformacionNuevoProducto(ProductoDTO datos);

	void modificarInformacionProductoExistente(UUID id, ProductoDTO datos);

	List<ProductoDTO> consultarPorFiltro(ProductoDTO filtro);

	List<ProductoDTO> consultarTodos();

	ProductoDTO consultarPorId(UUID id);
}