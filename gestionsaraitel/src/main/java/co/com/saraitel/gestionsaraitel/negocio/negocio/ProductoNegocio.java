package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.ProductoDominio;

public interface ProductoNegocio {

	void registrarInformacionNuevoProducto(ProductoDominio datos);

	void modificarInformacionProductoExistente(UUID id, ProductoDominio datos);

	List<ProductoDominio> consultarPorFiltro(ProductoDominio filtro);

	List<ProductoDominio> consultarTodos();

	ProductoDominio consultarPorId(UUID id);
}