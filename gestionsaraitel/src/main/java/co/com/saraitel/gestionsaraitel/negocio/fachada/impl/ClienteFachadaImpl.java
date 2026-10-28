package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.ClienteDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.ClienteFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.ClienteDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.ClienteNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class ClienteFachadaImpl implements ClienteFachada {

	@Override
	public void registrarInformacionNuevoCliente(ClienteDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var clienteNegocio = new ClienteNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var clienteDominio = ClienteDTOAssembler.obtenerInstancia().convertirADominio(datos);
			clienteNegocio.registrarInformacionNuevoCliente(clienteDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.ClienteFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_CLIENTE;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaInformacionClienteExistente(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var clienteNegocio = new ClienteNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			clienteNegocio.darBajaInformacionClienteExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.ClienteFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_DANDO_DE_BAJA_CLIENTE;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<ClienteDTO> consultarPorFiltro(ClienteDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var clienteNegocio = new ClienteNegocioImpl(daoFactory);

		try {
			var filtroDominio = ClienteDTOAssembler.obtenerInstancia().convertirADominio(filtro);
			var listaClientes = clienteNegocio.consultarPorFiltro(filtroDominio);
			return ClienteDTOAssembler.obtenerInstancia().convertirADTO(listaClientes);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClienteFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<ClienteDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var clienteNegocio = new ClienteNegocioImpl(daoFactory);

		try {
			var listaClientes = clienteNegocio.consultarTodos();
			return ClienteDTOAssembler.obtenerInstancia().convertirADTO(listaClientes);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClienteFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public ClienteDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var clienteNegocio = new ClienteNegocioImpl(daoFactory);

		try {
			var clienteDominio = clienteNegocio.consultarPorId(id);
			return ClienteDTOAssembler.obtenerInstancia().convertirADTO(clienteDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClienteFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTE_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
