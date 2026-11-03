package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.SedeDominio;

public interface SedeNegocio {

	void registrarInformacionNuevaSede(SedeDominio datos);

	void modificarInformacionSedeExistente(UUID id, SedeDominio datos);

	List<SedeDominio> consultarPorFiltro(SedeDominio filtro);

	List<SedeDominio> consultarTodos();

	SedeDominio consultarPorId(UUID id);
}