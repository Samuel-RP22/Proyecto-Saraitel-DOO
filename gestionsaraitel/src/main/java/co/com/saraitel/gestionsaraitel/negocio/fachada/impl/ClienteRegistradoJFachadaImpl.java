package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.ClienteRegistradoJDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.ClienteRegistradoJFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.ClienteRegistradoJDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.ClienteRegistradoJNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class ClienteRegistradoJFachadaImpl implements ClienteRegistradoJFachada {

	@Override
	public void registrarInformacionNuevoClienteJuridico(ClienteRegistradoJDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var negocio = new ClienteRegistradoJNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var dominio = ClienteRegistradoJDTOAssembler.obtenerInstancia().convertirADominio(datos);
			negocio.registrarInformacionNuevoClienteJuridico(dominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_CLIENTE_JURIDICO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<ClienteRegistradoJDTO> consultarPorFiltro(ClienteRegistradoJDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var negocio = new ClienteRegistradoJNegocioImpl(daoFactory);

		try {
			var filtroDominio = ClienteRegistradoJDTOAssembler.obtenerInstancia().convertirADominio(filtro);
			return ClienteRegistradoJDTOAssembler.obtenerInstancia().convertirADTO(negocio.consultarPorFiltro(filtroDominio));
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTE_JURIDICOS;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<ClienteRegistradoJDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var negocio = new ClienteRegistradoJNegocioImpl(daoFactory);

		try {
			return ClienteRegistradoJDTOAssembler.obtenerInstancia().convertirADTO(negocio.consultarTodos());
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTE_JURIDICOS;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public ClienteRegistradoJDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var negocio = new ClienteRegistradoJNegocioImpl(daoFactory);

		try {
			return ClienteRegistradoJDTOAssembler.obtenerInstancia().convertirADTO(negocio.consultarPorId(id));
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTE_JURIDICOS;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
