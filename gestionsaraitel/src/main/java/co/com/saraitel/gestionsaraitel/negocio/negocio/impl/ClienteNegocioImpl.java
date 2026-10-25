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
		var clienteEntidad = ClienteEntidadAssembler.getInstance().convertirAEntidad(datos);

		clienteEntidad.setId(generarIdClienteUnico());

		daoFactory.obtenerClienteDao().crear(clienteEntidad);
	}

	private UUID generarIdClienteUnico() {
		UUID id;
		boolean existe;

		do {
			id = UUID.randomUUID();
			var clienteExistente = daoFactory.obtenerClienteDao().consultarPorId(id);
			existe = !clienteExistente.getId().equals(UtilUUID.obtenerUUIDDefecto());
		} while (existe);

		return id;
	}

	@Override
	public void darBajaInformacionClienteExistente(final UUID id) {
		var clienteExistente = daoFactory.obtenerClienteDao().consultarPorId(id);

		if (clienteExistente.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return;
		}

		AsegurarClienteNoEsteSiendoUtilizadoRule.obtenerInstancia().ejecutar(id, daoFactory);

		daoFactory.obtenerClienteDao().eliminar(id);
	}

	@Override
	public List<ClienteDominio> consultarPorFiltro(final ClienteDominio filtro) {
		var entidadFiltro = ClienteEntidadAssembler.getInstance().convertirAEntidad(filtro);

		return daoFactory.obtenerClienteDao().consultarPorFiltro(entidadFiltro).stream()
				.map(ClienteEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public List<ClienteDominio> consultarTodos() {
		return daoFactory.obtenerClienteDao().consultarTodos().stream()
				.map(ClienteEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public ClienteDominio consultarPorid(final UUID id) {
		var entidad = daoFactory.obtenerClienteDao().consultarPorId(id);

		if (entidad.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			return ClienteDominio.obtenerValorDefecto();
		}

		return ClienteEntidadAssembler.getInstance().convertirADominio(entidad);
	}
}
