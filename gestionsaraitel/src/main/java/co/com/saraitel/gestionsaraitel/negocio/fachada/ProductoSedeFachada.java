package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.ProductoSedeDTO;

public interface ProductoSedeFachada {

	void registrarInformacionNuevoProductoSede(ProductoSedeDTO datos);

	void modificarInformacionProductoSedeExistente(UUID id, ProductoSedeDTO datos);

	List<ProductoSedeDTO> consultarPorFiltro(ProductoSedeDTO filtro);

	List<ProductoSedeDTO> consultarTodos();

	ProductoSedeDTO consultarPorId(UUID id);
}