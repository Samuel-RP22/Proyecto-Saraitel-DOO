package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.PaisDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.PaisFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.PaisDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.PaisNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class PaisFachadaImpl implements PaisFachada {

	@Override
	public void registrarInformacionNuevoPais(PaisDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var paisNegocio = new PaisNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var paisDominio = PaisDTOAssembler.getInstance().convertirADominio(datos);
			paisNegocio.registrarInformacionNuevoPais(paisDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo país, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarInformacionPaisExistente(UUID id, PaisDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var paisNegocio = new PaisNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var paisDominio = PaisDTOAssembler.getInstance().convertirADominio(datos);
			paisNegocio.modificarInformacionPaisExistente(id, paisDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de modificar la información del país, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaInformacionPaisExistente(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var paisNegocio = new PaisNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			paisNegocio.darBajaInformacionPaisExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de dar de baja la información del país, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<PaisDTO> consultarPorFiltro(PaisDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var paisNegocio = new PaisNegocioImpl(daoFactory);

		try {
			var filtroDominio = PaisDTOAssembler.getInstance().convertirADominio(filtro);
			var listaPaises = paisNegocio.consultarPorFiltro(filtroDominio);
			return PaisDTOAssembler.getInstance().convertirADTO(listaPaises);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de consultar la información de los países con el filtro deseado, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<PaisDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var paisNegocio = new PaisNegocioImpl(daoFactory);

		try {
			var listaPaises = paisNegocio.consultarTodos();
			return PaisDTOAssembler.getInstance().convertirADTO(listaPaises);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de consultar la información de los países, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public PaisDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var paisNegocio = new PaisNegocioImpl(daoFactory);

		try {
			var paisDominio = paisNegocio.consultarPorid(id);
			return PaisDTOAssembler.getInstance().convertirADTO(paisDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = "Se ha presentado un problema inesperado tratando de consultar la información del país, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}