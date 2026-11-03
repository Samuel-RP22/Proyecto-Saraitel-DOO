
package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.TipoDocumentoDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.TipoDocumentoNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.TipoDocumentoEntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class TipoDocumentoNegocioImpl implements TipoDocumentoNegocio {

	private final DAOFactory daoFactory;

	public TipoDocumentoNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoDocumentoDominio> consultarPorFiltro(final TipoDocumentoDominio filtro) {
		var entidadFiltro = TipoDocumentoEntidadAssembler.obtenerInstancia().convertirAEntidad(filtro);

		return daoFactory.obtenerTipoDocumentoDao().consultarPorFiltro(entidadFiltro).stream()
				.map(TipoDocumentoEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public List<TipoDocumentoDominio> consultarTodos() {
		return daoFactory.obtenerTipoDocumentoDao().consultarTodos().stream()
				.map(TipoDocumentoEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public TipoDocumentoDominio consultarPorId(final UUID id) {
		var entidad = daoFactory.obtenerTipoDocumentoDao().consultarPorId(id);

		if (UtilUUID.esValorDefecto(entidad.getId())) {
			return TipoDocumentoDominio.obtenerValorDefecto();
		}

		return TipoDocumentoEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}
}
