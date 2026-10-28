package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.ClienteDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.ClienteNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.ClienteEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.cliente.AsegurarClienteNoEsteSiendoUtilizadoRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteNegocioImpl implements ClienteNegocio {

	private final DAOFactory daoFactory;

	public ClienteNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoCliente(final ClienteDominio datos) {
		var clienteEntidad = ClienteEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);

		clienteEntidad.setId(UtilUUID.generarIdUnico(id -> daoFactory.obtenerClienteDao().consultarPorId(id).getId()));

		daoFactory.obtenerClienteDao().crear(clienteEntidad);
	}

	@Override
	public void darBajaInformacionClienteExistente(final UUID id) {
		var clienteExistente = daoFactory.obtenerClienteDao().consultarPorId(id);

		if (UtilUUID.esValorDefecto(clienteExistente.getId())) {
			return;
		}

		AsegurarClienteNoEsteSiendoUtilizadoRule.obtenerInstancia().ejecutar(id, daoFactory);

		daoFactory.obtenerClienteDao().eliminar(id);
	}

	@Override
	public List<ClienteDominio> consultarPorFiltro(final ClienteDominio filtro) {
		var entidadFiltro = ClienteEntidadAssembler.obtenerInstancia().convertirAEntidad(filtro);

		return daoFactory.obtenerClienteDao().consultarPorFiltro(entidadFiltro).stream()
				.map(ClienteEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public List<ClienteDominio> consultarTodos() {
		return daoFactory.obtenerClienteDao().consultarTodos().stream()
				.map(ClienteEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public ClienteDominio consultarPorId(final UUID id) {
		var entidad = daoFactory.obtenerClienteDao().consultarPorId(id);

		if (UtilUUID.esValorDefecto(entidad.getId())) {
			return ClienteDominio.obtenerValorDefecto();
		}

		return ClienteEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}
}
