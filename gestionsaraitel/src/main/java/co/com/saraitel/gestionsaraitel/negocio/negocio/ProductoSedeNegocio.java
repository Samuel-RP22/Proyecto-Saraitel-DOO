package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.ProductoSedeDominio;

public interface ProductoSedeNegocio {

	void registrarInformacionNuevoProductoSede(ProductoSedeDominio datos);

	void modificarInformacionProductoSedeExistente(UUID id, ProductoSedeDominio datos);

	List<ProductoSedeDominio> consultarPorFiltro(ProductoSedeDominio filtro);

	List<ProductoSedeDominio> consultarTodos();

	ProductoSedeDominio consultarPorId(UUID id);
}