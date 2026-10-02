package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;
import co.com.saraitel.gestionsaraitel.dominio.PaisDominio;

public interface PaisNegocio {
	
	void registrarInformacionNuevoPais(PaisDominio datos);
	void modificarInformacionPaisExistente(UUID id, PaisDominio datos);
	void darBajaInformacionPaisExistente(UUID id);
	
	List<PaisDominio> consultarPorFiltro(PaisDominio filtro);
	
	List<PaisDominio> consultarTodos();

	PaisDominio consultarPorid(UUID id);
}
