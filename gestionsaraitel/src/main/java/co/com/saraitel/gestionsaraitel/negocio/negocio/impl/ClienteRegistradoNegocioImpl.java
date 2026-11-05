package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.ClienteRegistradoNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.ClienteRegistradoEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.cliente.AsegurarClienteExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistrado.AsegurarClienteNaturalDefectoValidoRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistrado.AsegurarClienteRegistradoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistrado.AsegurarClienteRegistradoNoEsteSiendoUtilizadoRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ClienteRegistradoNegocioImpl implements ClienteRegistradoNegocio {

	private final DAOFactory daoFactory;

	public ClienteRegistradoNegocioImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoClienteRegistrado(final ClienteRegistradoDominio datos) {
		AsegurarClienteNaturalDefectoValidoRule.obtenerInstancia().ejecutar(datos.getClienteNaturalDefecto());
		AsegurarClienteExistaRule.obtenerInstancia().ejecutar(datos.getCliente().getId(), daoFactory);
		var clienteRegistradoEntidad = ClienteRegistradoEntidadAssembler.obtenerInstancia().convertirAEntidad(datos);
		clienteRegistradoEntidad.setId(
				UtilUUID.generarIdUnico(id -> daoFactory.obtenerClienteRegistradoDao().consultarPorId(id).getId()));
		daoFactory.obtenerClienteRegistradoDao().crear(clienteRegistradoEntidad);
	}

	@Override
	public void darBajaInformacionClienteRegistradoExistente(final UUID id) {
		AsegurarClienteRegistradoExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		AsegurarClienteRegistradoNoEsteSiendoUtilizadoRule.obtenerInstancia().ejecutar(id, daoFactory);
		daoFactory.obtenerClienteRegistradoDao().eliminar(id);
	}

	@Override
	public List<ClienteRegistradoDominio> consultarPorFiltro(final ClienteRegistradoDominio filtro) {
		AsegurarClienteNaturalDefectoValidoRule.obtenerInstancia().ejecutar(filtro.getClienteNaturalDefecto());
		var entidadFiltro = ClienteRegistradoEntidadAssembler.obtenerInstancia().convertirAEntidad(filtro);
		return daoFactory.obtenerClienteRegistradoDao().consultarPorFiltro(entidadFiltro).stream()
				.map(ClienteRegistradoEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public List<ClienteRegistradoDominio> consultarTodos() {
		return daoFactory.obtenerClienteRegistradoDao().consultarTodos().stream()
				.map(ClienteRegistradoEntidadAssembler.obtenerInstancia()::convertirADominio).toList();
	}

	@Override
	public ClienteRegistradoDominio consultarPorId(final UUID id) {
		AsegurarClienteRegistradoExistaRule.obtenerInstancia().ejecutar(id, daoFactory);
		var entidad = daoFactory.obtenerClienteRegistradoDao().consultarPorId(id);
		return ClienteRegistradoEntidadAssembler.obtenerInstancia().convertirADominio(entidad);
	}
}