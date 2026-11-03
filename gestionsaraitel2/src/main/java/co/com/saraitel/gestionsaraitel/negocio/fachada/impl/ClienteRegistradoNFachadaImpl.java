package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.ClienteRegistradoNDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.ClienteRegistradoNFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.ClienteRegistradoNDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.ClienteRegistradoNNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class ClienteRegistradoNFachadaImpl implements ClienteRegistradoNFachada {

	@Override
	public void registrarInformacionNuevoClienteNatural(ClienteRegistradoNDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var negocio = new ClienteRegistradoNNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var dominio = ClienteRegistradoNDTOAssembler.obtenerInstancia().convertirADominio(datos);
			negocio.registrarInformacionNuevoClienteNatural(dominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_CLIENTE_NATURAL;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<ClienteRegistradoNDTO> consultarPorFiltro(ClienteRegistradoNDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var negocio = new ClienteRegistradoNNegocioImpl(daoFactory);

		try {
			var filtroDominio = ClienteRegistradoNDTOAssembler.obtenerInstancia().convertirADominio(filtro);
			return ClienteRegistradoNDTOAssembler.obtenerInstancia().convertirADTO(negocio.consultarPorFiltro(filtroDominio));
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTE_NATURALS;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<ClienteRegistradoNDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var negocio = new ClienteRegistradoNNegocioImpl(daoFactory);

		try {
			return ClienteRegistradoNDTOAssembler.obtenerInstancia().convertirADTO(negocio.consultarTodos());
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTE_NATURALS;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public ClienteRegistradoNDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var negocio = new ClienteRegistradoNNegocioImpl(daoFactory);

		try {
			return ClienteRegistradoNDTOAssembler.obtenerInstancia().convertirADTO(negocio.consultarPorId(id));
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTE_NATURALS;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
