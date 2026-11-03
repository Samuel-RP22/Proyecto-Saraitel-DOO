package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.EstadoProcesoCompraDominio;

public interface EstadoProcesoCompraNegocio {

	void registrarInformacionNuevoEstadoProcesoCompra(EstadoProcesoCompraDominio datos);

	List<EstadoProcesoCompraDominio> consultarPorFiltro(EstadoProcesoCompraDominio filtro);

	List<EstadoProcesoCompraDominio> consultarTodos();

	EstadoProcesoCompraDominio consultarPorId(UUID id);
}
