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
			var filtroDominio = CiudadDTOAssembler.getInstance().convertirADominio(filtro);
			var listaCiudades = ciudadNegocio.consultarPorFiltro(filtroDominio);
			return CiudadDTOAssembler.getInstance().convertirADTO(listaCiudades);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
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
			var listaCiudades = ciudadNegocio.consultarTodos();
			return CiudadDTOAssembler.getInstance().convertirADTO(listaCiudades);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
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
			var ciudadDominio = ciudadNegocio.consultarPorid(id);
			return CiudadDTOAssembler.getInstance().convertirADTO(ciudadDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.CiudadFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDAD_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
