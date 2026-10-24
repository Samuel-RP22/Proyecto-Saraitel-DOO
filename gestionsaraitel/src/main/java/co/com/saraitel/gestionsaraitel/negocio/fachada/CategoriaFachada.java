package co.com.saraitel.gestionsaraitel.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dto.CategoriaDTO;

public interface CategoriaFachada {
	
	void registrarInformacionNuevaCategoria(CategoriaDTO datos);
	
	void modificarInformacionCategoriaExistente(UUID id, CategoriaDTO datos);
	
	void darBajaInformacionCategoriaExistente(UUID id);
	
	List<CategoriaDTO> consultarPorFiltro(CategoriaDTO filtro);
	
	List<CategoriaDTO> consultarTodos();

	CategoriaDTO consultarPorId(UUID id);
}