package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.CiudadDominio;

public interface CiudadNegocio {

	List<CiudadDominio> consultarPorFiltro(CiudadDominio filtro);

	List<CiudadDominio> consultarTodos();

	CiudadDominio consultarPorid(UUID id);
}
