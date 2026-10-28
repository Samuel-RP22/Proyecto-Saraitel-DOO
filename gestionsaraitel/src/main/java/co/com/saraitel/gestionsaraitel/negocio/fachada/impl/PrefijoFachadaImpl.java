package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.PrefijoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.PrefijoFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.PrefijoDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.PrefijoNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class PrefijoFachadaImpl implements PrefijoFachada {

	@Override
	public List<PrefijoDTO> consultarPorFiltro(PrefijoDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var prefijoNegocio = new PrefijoNegocioImpl(daoFactory);

		try {
			var filtroDominio = PrefijoDTOAssembler.obtenerInstancia().convertirADominio(filtro);
			var listaPrefijos = prefijoNegocio.consultarPorFiltro(filtroDominio);
			return PrefijoDTOAssembler.obtenerInstancia().convertirADTO(listaPrefijos);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PrefijoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PREFIJOS_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<PrefijoDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var prefijoNegocio = new PrefijoNegocioImpl(daoFactory);

		try {
			var listaPrefijos = prefijoNegocio.consultarTodos();
			return PrefijoDTOAssembler.obtenerInstancia().convertirADTO(listaPrefijos);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PrefijoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PREFIJOS;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public PrefijoDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var prefijoNegocio = new PrefijoNegocioImpl(daoFactory);

		try {
			var prefijoDominio = prefijoNegocio.consultarPorId(id);
			return PrefijoDTOAssembler.obtenerInstancia().convertirADTO(prefijoDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PrefijoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PREFIJO_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
