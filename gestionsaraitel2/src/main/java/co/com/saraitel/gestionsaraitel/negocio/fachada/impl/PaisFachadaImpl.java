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
			var filtroDominio = PaisDTOAssembler.obtenerInstancia().convertirADominio(filtro);
			var listaPaises = paisNegocio.consultarPorFiltro(filtroDominio);
			return PaisDTOAssembler.obtenerInstancia().convertirADTO(listaPaises);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
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
			var listaPaises = paisNegocio.consultarTodos();
			return PaisDTOAssembler.obtenerInstancia().convertirADTO(listaPaises);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
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
			var paisDominio = paisNegocio.consultarPorId(id);
			return PaisDTOAssembler.obtenerInstancia().convertirADTO(paisDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAIS_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
