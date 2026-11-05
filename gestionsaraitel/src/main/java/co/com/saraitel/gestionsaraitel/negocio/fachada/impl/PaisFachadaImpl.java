package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.PaisDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.PaisFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.PaisDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.PaisNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class PaisFachadaImpl implements PaisFachada {

	@Override
	public List<PaisDTO> consultarPorFiltro(PaisDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var paisNegocio = new PaisNegocioImpl(daoFactory);
		try {
			daoFactory.iniciarTransaccion();
			var filtroDominio = PaisDTOAssembler.obtenerInstancia().convertirADominio(filtro);
			var listaPaises = paisNegocio.consultarPorFiltro(filtroDominio);
			var resultado = PaisDTOAssembler.obtenerInstancia().convertirADTO(listaPaises);
			daoFactory.confirmarTransaccion();
			return resultado;
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.PaisFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAISES_CON_FILTRO;
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
			daoFactory.iniciarTransaccion();
			var listaPaises = paisNegocio.consultarTodos();
			var resultado = PaisDTOAssembler.obtenerInstancia().convertirADTO(listaPaises);
			daoFactory.confirmarTransaccion();
			return resultado;
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.PaisFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAISES;
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
			daoFactory.iniciarTransaccion();
			var paisDominio = paisNegocio.consultarPorId(id);
			var resultado = PaisDTOAssembler.obtenerInstancia().convertirADTO(paisDominio);
			daoFactory.confirmarTransaccion();
			return resultado;
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.PaisFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAIS_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
