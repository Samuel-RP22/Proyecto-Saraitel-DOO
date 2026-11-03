
package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.DepartamentoDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.DepartamentoNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.DepartamentoEntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DepartamentoNegocioImpl implements DepartamentoNegocio {

	private final DAOFactory daoFactory;
	
	public DepartamentoNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}


	@Override
	public List<DepartamentoDominio> consultarPorFiltro(final DepartamentoDominio filtro) {
		var entidadFiltro = DepartamentoEntidadAssembler.obtenerInstancia().convertirAEntidad(filtro);

		return daoFactory.obtenerDepartamentoDao().consultarPorFiltro(entidadFiltro).stream()
				.map(DepartamentoEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public List<DepartamentoDominio> consultarTodos() {
		return daoFactory.obtenerDepartamentoDao().consultarTodos().stream()
				.map(DepartamentoEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public DepartamentoDominio consultarPorId(final UUID id) {
		var entidad = daoFactory.obtenerDepartamentoDao().consultarPorId(id);

		if (UtilUUID.esValorDefecto(entidad.getId())) {
			return DepartamentoDominio.obtenerValorDefecto();
		}

		return DepartamentoEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}
}
