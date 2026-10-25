package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.ProcesoCompraDominio;

public interface ProcesoCompraNegocio {

	void registrarInformacionNuevoProcesoCompra(ProcesoCompraDominio datos);

	List<ProcesoCompraDominio> consultarPorFiltro(ProcesoCompraDominio filtro);

	List<ProcesoCompraDominio> consultarTodos();

	ProcesoCompraDominio consultarPorid(UUID id);
}
