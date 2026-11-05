package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.CiudadDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.CiudadFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.CiudadDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.CiudadNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class CiudadFachadaImpl implements CiudadFachada {

	@Override
	public List<CiudadDTO> consultarPorFiltro(CiudadDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var ciudadNegocio = new CiudadNegocioImpl(daoFactory);
		try {
			daoFactory.iniciarTransaccion();
			var filtroDominio = CiudadDTOAssembler.obtenerInstancia().convertirADominio(filtro);
			var listaCiudades = ciudadNegocio.consultarPorFiltro(filtroDominio);
			var resultado = CiudadDTOAssembler.obtenerInstancia().convertirADTO(listaCiudades);
			daoFactory.confirmarTransaccion();
			return resultado;
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.CiudadFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDADES_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<CiudadDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var ciudadNegocio = new CiudadNegocioImpl(daoFactory);
		try {
			daoFactory.iniciarTransaccion();
			var listaCiudades = ciudadNegocio.consultarTodos();
			var resultado = CiudadDTOAssembler.obtenerInstancia().convertirADTO(listaCiudades);
			daoFactory.confirmarTransaccion();
			return resultado;
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.CiudadFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDADES;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public CiudadDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var ciudadNegocio = new CiudadNegocioImpl(daoFactory);
		try {
			daoFactory.iniciarTransaccion();
			var ciudadDominio = ciudadNegocio.consultarPorId(id);
			var resultado = CiudadDTOAssembler.obtenerInstancia().convertirADTO(ciudadDominio);
			daoFactory.confirmarTransaccion();
			return resultado;
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.CiudadFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDAD_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
