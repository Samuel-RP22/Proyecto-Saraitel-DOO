package co.com.saraitel.gestionsaraitel.negocio.negocio;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dominio.TipoDocumentoDominio;

public interface TipoDocumentoNegocio {

	List<TipoDocumentoDominio> consultarPorFiltro(TipoDocumentoDominio filtro);

	List<TipoDocumentoDominio> consultarTodos();

	TipoDocumentoDominio consultarPorId(UUID id);
}
