package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.PrefijoDominio;

public interface PrefijoNegocio {

	List<PrefijoDominio> consultarPorFiltro(PrefijoDominio filtro);

	List<PrefijoDominio> consultarTodos();

	PrefijoDominio consultarPorId(UUID id);
}
