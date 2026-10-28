package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

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

		var clienteJuridico = ClienteRegistradoJEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);
		clienteJuridico.setId(UtilUUID.generarIdUnico(id -> daoFactory.obtenerClienteRegistradoJDao().consultarPorId(id).getId()));
		clienteJuridico.setClienteRegistrado(clienteRegistrado);

		daoFactory.obtenerClienteRegistradoJDao().crear(clienteJuridico);
	}

	@Override
	public List<ClienteRegistradoJDominio> consultarPorFiltro(final ClienteRegistradoJDominio filtro) {
		var entidadFiltro = ClienteRegistradoJEntidadAssembler.obtenerInstancia().convertirAEntidad(filtro);

		return daoFactory.obtenerClienteRegistradoJDao().consultarPorFiltro(entidadFiltro).stream()
				.map(ClienteRegistradoJEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public List<ClienteRegistradoJDominio> consultarTodos() {
		return daoFactory.obtenerClienteRegistradoJDao().consultarTodos().stream()
				.map(ClienteRegistradoJEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public ClienteRegistradoJDominio consultarPorId(final UUID id) {
		var entidad = daoFactory.obtenerClienteRegistradoJDao().consultarPorId(id);

		if (UtilUUID.esValorDefecto(entidad.getId())) {
			return ClienteRegistradoJDominio.obtenerValorDefecto();
		}

		return ClienteRegistradoJEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}

	private ClienteRegistradoEntidad registrarClienteRegistrado(final boolean esNatural) {
		var cliente = new ClienteEntidad(UtilUUID.generarIdUnico(id -> daoFactory.obtenerClienteDao().consultarPorId(id).getId()),
				true);
		daoFactory.obtenerClienteDao().crear(cliente);

		var clienteRegistrado = new ClienteRegistradoEntidad(
				UtilUUID.generarIdUnico(id -> daoFactory.obtenerClienteRegistradoDao().consultarPorId(id).getId()), cliente,
				esNatural);
		daoFactory.obtenerClienteRegistradoDao().crear(clienteRegistrado);

		return clienteRegistrado;
	}
}
