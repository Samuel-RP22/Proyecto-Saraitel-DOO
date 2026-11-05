package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoJDominio;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.ClienteRegistradoJNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.ClienteRegistradoJEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.AsegurarClienteJuridicoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.AsegurarClienteJuridicoNoEsteSiendoUtilizadoRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.AsegurarCorreoClienteJuridicoNoExistaEnOtroClienteJuridicoRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.AsegurarCorreoNuevoClienteJuridicoNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.AsegurarNitNuevoClienteJuridicoNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.AsegurarRazonSocialClienteJuridicoNoExistaEnOtroClienteJuridicoRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.AsegurarRazonSocialNuevoClienteJuridicoNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.AsegurarTelefonoClienteJuridicoNoExistaEnOtroClienteJuridicoRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.AsegurarTelefonoNuevoClienteJuridicoNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.ValidarDatosConsultarClientesJuridicosPorFiltroRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj.ValidarDatosModificarInformacionClienteJuridicoExistenteRule;
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
		AsegurarNitNuevoClienteJuridicoNoExistaRule.obtenerInstancia().ejecutar(datos.getNit(), daoFactory);
		AsegurarRazonSocialNuevoClienteJuridicoNoExistaRule.obtenerInstancia().ejecutar(datos.getRazonSocial(),
				daoFactory);
		AsegurarTelefonoNuevoClienteJuridicoNoExistaRule.obtenerInstancia().ejecutar(datos.getPrefijo().getId(),
				datos.getTelefono(), daoFactory);
		AsegurarCorreoNuevoClienteJuridicoNoExistaRule.obtenerInstancia().ejecutar(datos.getCorreo(), daoFactory);
		var clienteJuridico = ClienteRegistradoJEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);
		clienteJuridico.setId(
				UtilUUID.generarIdUnico(id -> daoFactory.obtenerClienteRegistradoJDao().consultarPorId(id).getId()));
		clienteJuridico.setClienteRegistrado(registrarClienteRegistradoJuridico());
		daoFactory.obtenerClienteRegistradoJDao().crear(clienteJuridico);
	}

	@Override
	public void modificarInformacionClienteJuridicoExistente(final UUID id, final ClienteRegistradoJDominio datos) {
		AsegurarClienteJuridicoExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		ValidarDatosModificarInformacionClienteJuridicoExistenteRule.obtenerInstancia().ejecutar(datos);
		AsegurarRazonSocialClienteJuridicoNoExistaEnOtroClienteJuridicoRule.obtenerInstancia().ejecutar(id,
				datos.getRazonSocial(), daoFactory);
		AsegurarTelefonoClienteJuridicoNoExistaEnOtroClienteJuridicoRule.obtenerInstancia().ejecutar(id,
				datos.getPrefijo().getId(), datos.getTelefono(), daoFactory);
		AsegurarCorreoClienteJuridicoNoExistaEnOtroClienteJuridicoRule.obtenerInstancia().ejecutar(id,
				datos.getCorreo(), daoFactory);
		var clienteJuridico = ClienteRegistradoJEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);
		daoFactory.obtenerClienteRegistradoJDao().actualizar(id, clienteJuridico);
	}

	@Override
	public void darBajaInformacionClienteJuridicoExistente(final UUID id) {
		AsegurarClienteJuridicoExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		AsegurarClienteJuridicoNoEsteSiendoUtilizadoRule.obtenerInstancia().ejecutar(id, daoFactory);
		var clienteRegistrado = daoFactory.obtenerClienteRegistradoJDao().consultarPorId(id).getClienteRegistrado();
		daoFactory.obtenerClienteRegistradoJDao().eliminar(id);
		eliminarClienteRegistradoJuridico(clienteRegistrado);
	}

	@Override
	public List<ClienteRegistradoJDominio> consultarPorFiltro(final ClienteRegistradoJDominio filtro) {
		ValidarDatosConsultarClientesJuridicosPorFiltroRule.obtenerInstancia().ejecutar(filtro);
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
		AsegurarClienteJuridicoExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		var entidad = daoFactory.obtenerClienteRegistradoJDao().consultarPorId(id);
		return ClienteRegistradoJEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}

	private ClienteRegistradoEntidad registrarClienteRegistradoJuridico() {
		var cliente = new ClienteEntidad(
				UtilUUID.generarIdUnico(id -> daoFactory.obtenerClienteDao().consultarPorId(id).getId()), true);
		daoFactory.obtenerClienteDao().crear(cliente);
		var clienteRegistrado = new ClienteRegistradoEntidad(
				UtilUUID.generarIdUnico(id -> daoFactory.obtenerClienteRegistradoDao().consultarPorId(id).getId()),
				cliente, false);
		daoFactory.obtenerClienteRegistradoDao().crear(clienteRegistrado);
		return clienteRegistrado;
	}

	private void eliminarClienteRegistradoJuridico(final ClienteRegistradoEntidad clienteRegistrado) {
		daoFactory.obtenerClienteRegistradoDao().eliminar(clienteRegistrado.getId());
		daoFactory.obtenerClienteDao().eliminar(clienteRegistrado.getCliente().getId());
	}
}
