package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoNDominio;
import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.ClienteRegistradoNNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.ClienteRegistradoNEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.PersonaEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradon.AsegurarClienteNaturalExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradon.AsegurarClienteNaturalNoEsteSiendoUtilizadoRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradon.ValidarDatosConsultarClientesNaturalesPorFiltroRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradon.ValidarDatosRegistrarInformacionNuevoClienteNaturalRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoNNegocioImpl implements ClienteRegistradoNNegocio {

	private final DAOFactory daoFactory;

	public ClienteRegistradoNNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoClienteNatural(final ClienteRegistradoNDominio datos) {
		ValidarDatosRegistrarInformacionNuevoClienteNaturalRule.obtenerInstancia().ejecutar(datos, daoFactory);
		var clienteNatural = ClienteRegistradoNEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);
		clienteNatural.setId(
				UtilUUID.generarIdUnico(id -> daoFactory.obtenerClienteRegistradoNDao().consultarPorId(id).getId()));
		clienteNatural.setClienteRegistrado(registrarClienteRegistradoNatural());
		clienteNatural.setPersona(registrarPersonaClienteNaturalSiEsNueva(datos.getPersona()));
		daoFactory.obtenerClienteRegistradoNDao().crear(clienteNatural);
	}

	@Override
	public void darBajaInformacionClienteNaturalExistente(final UUID id) {
		AsegurarClienteNaturalExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		AsegurarClienteNaturalNoEsteSiendoUtilizadoRule.obtenerInstancia().ejecutar(id, daoFactory);
		var clienteRegistrado = daoFactory.obtenerClienteRegistradoNDao().consultarPorId(id).getClienteRegistrado();
		daoFactory.obtenerClienteRegistradoNDao().eliminar(id);
		eliminarClienteRegistradoNatural(clienteRegistrado);
	}

	@Override
	public List<ClienteRegistradoNDominio> consultarPorFiltro(final ClienteRegistradoNDominio filtro) {
		ValidarDatosConsultarClientesNaturalesPorFiltroRule.obtenerInstancia().ejecutar(filtro);
		var entidadFiltro = ClienteRegistradoNEntidadAssembler.obtenerInstancia().convertirAEntidad(filtro);
		return daoFactory.obtenerClienteRegistradoNDao().consultarPorFiltro(entidadFiltro).stream()
				.map(ClienteRegistradoNEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public List<ClienteRegistradoNDominio> consultarTodos() {
		return daoFactory.obtenerClienteRegistradoNDao().consultarTodos().stream()
				.map(ClienteRegistradoNEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public ClienteRegistradoNDominio consultarPorId(final UUID id) {
		AsegurarClienteNaturalExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		var entidad = daoFactory.obtenerClienteRegistradoNDao().consultarPorId(id);
		return ClienteRegistradoNEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}

	private ClienteRegistradoEntidad registrarClienteRegistradoNatural() {
		var cliente = new ClienteEntidad(
				UtilUUID.generarIdUnico(id -> daoFactory.obtenerClienteDao().consultarPorId(id).getId()), true);
		daoFactory.obtenerClienteDao().crear(cliente);
		var clienteRegistrado = new ClienteRegistradoEntidad(
				UtilUUID.generarIdUnico(id -> daoFactory.obtenerClienteRegistradoDao().consultarPorId(id).getId()),
				cliente, true);
		daoFactory.obtenerClienteRegistradoDao().crear(clienteRegistrado);
		return clienteRegistrado;
	}

	private PersonaEntidad registrarPersonaClienteNaturalSiEsNueva(final PersonaDominio persona) {
		var personaEntidad = PersonaEntidadAssembler.obtenerInstancia().convertirAEntidad(persona);
		if (UtilUUID.esValorDefecto(personaEntidad.getId())) {
			personaEntidad
					.setId(UtilUUID.generarIdUnico(id -> daoFactory.obtenerPersonaDao().consultarPorId(id).getId()));
			daoFactory.obtenerPersonaDao().crear(personaEntidad);
		}
		return personaEntidad;
	}

	private void eliminarClienteRegistradoNatural(final ClienteRegistradoEntidad clienteRegistrado) {
		daoFactory.obtenerClienteRegistradoDao().eliminar(clienteRegistrado.getId());
		daoFactory.obtenerClienteDao().eliminar(clienteRegistrado.getCliente().getId());
	}
}