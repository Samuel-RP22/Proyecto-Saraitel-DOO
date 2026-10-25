package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoJDominio;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.ClienteRegistradoJNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.ClienteRegistradoJEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.AsegurarNitNuevoClienteJuridicoNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.AsegurarPrefijoClienteJuridicoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.AsegurarRazonSocialNuevoClienteJuridicoNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.ValidarDatosRegistrarInformacionNuevoClienteJuridicoRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoJNegocioImpl implements ClienteRegistradoJNegocio {

	private final DAOFactory daoFactory;

	public ClienteRegistradoJNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoClienteJuridico(final ClienteRegistradoJDominio datos) {
		ValidarDatosRegistrarInformacionNuevoClienteJuridicoRule.obtenerInstancia().ejecutar(datos);

		AsegurarPrefijoClienteJuridicoExistaRule.obtenerInstancia().ejecutar(datos.getPrefijo().getId(), daoFactory);
		AsegurarNitNuevoClienteJuridicoNoExistaRule.obtenerInstancia().ejecutar(datos.getNit(), daoFactory);
		AsegurarRazonSocialNuevoClienteJuridicoNoExistaRule.obtenerInstancia().ejecutar(datos.getRazonSocial(),
				daoFactory);

		var clienteRegistrado = registrarClienteRegistrado(false);

		var clienteJuridico = ClienteRegistradoJEntidadAssembler.getInstance().convertirAEntidad(datos);
		clienteJuridico.setId(generarIdUnico(id -> daoFactory.obtenerClienteRegistradoJDao().consultarPorId(id).getId()));
		clienteJuridico.setClienteRegistrado(clienteRegistrado);

		daoFactory.obtenerClienteRegistradoJDao().crear(clienteJuridico);
	}

	@Override
	public List<ClienteRegistradoJDominio> consultarPorFiltro(final ClienteRegistradoJDominio filtro) {
		var entidadFiltro = ClienteRegistradoJEntidadAssembler.getInstance().convertirAEntidad(filtro);

		return daoFactory.obtenerClienteRegistradoJDao().consultarPorFiltro(entidadFiltro).stream()
				.map(ClienteRegistradoJEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public List<ClienteRegistradoJDominio> consultarTodos() {
		return daoFactory.obtenerClienteRegistradoJDao().consultarTodos().stream()
				.map(ClienteRegistradoJEntidadAssembler.getInstance()::convertirADominio).toList();
	}

	@Override
	public ClienteRegistradoJDominio consultarPorid(final UUID id) {
		var entidad = daoFactory.obtenerClienteRegistradoJDao().consultarPorId(id);

		return ClienteRegistradoJEntidadAssembler.getInstance().convertirADominio(entidad);
	}

	private UUID generarIdUnico(final Function<UUID, UUID> consultarIdExistente) {
		UUID id;

		do {
			id = UUID.randomUUID();
		} while (!consultarIdExistente.apply(id).equals(UtilUUID.obtenerUUIDDefecto()));

		return id;
	}

	private ClienteRegistradoEntidad registrarClienteRegistrado(final boolean esNatural) {
		var cliente = new ClienteEntidad(generarIdUnico(id -> daoFactory.obtenerClienteDao().consultarPorId(id).getId()),
				true);
		daoFactory.obtenerClienteDao().crear(cliente);

		var clienteRegistrado = new ClienteRegistradoEntidad(
				generarIdUnico(id -> daoFactory.obtenerClienteRegistradoDao().consultarPorId(id).getId()), cliente,
				esNatural);
		daoFactory.obtenerClienteRegistradoDao().crear(clienteRegistrado);

		return clienteRegistrado;
	}
}
