package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.SedeDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.SedeFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.SedeDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.SedeNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class SedeFachadaImpl implements SedeFachada {

	@Override
	public void registrarInformacionNuevaSede(SedeDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var sedeNegocio = new SedeNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var sedeDominio = SedeDTOAssembler.getInstance().convertirADominio(datos);
			sedeNegocio.registrarInformacionNuevaSede(sedeDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.SedeFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_SEDE;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarInformacionSedeExistente(UUID id, SedeDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var sedeNegocio = new SedeNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var sedeDominio = SedeDTOAssembler.getInstance().convertirADominio(datos);
			sedeNegocio.modificarInformacionSedeExistente(id, sedeDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.SedeFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_MODIFICANDO_SEDE;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<SedeDTO> consultarPorFiltro(SedeDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var sedeNegocio = new SedeNegocioImpl(daoFactory);

		try {
			var filtroDominio = SedeDTOAssembler.getInstance().convertirADominio(filtro);
			var listaSedes = sedeNegocio.consultarPorFiltro(filtroDominio);
			return SedeDTOAssembler.getInstance().convertirADTO(listaSedes);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.SedeFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SEDES_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<SedeDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var sedeNegocio = new SedeNegocioImpl(daoFactory);

		try {
			var listaSedes = sedeNegocio.consultarTodos();
			return SedeDTOAssembler.getInstance().convertirADTO(listaSedes);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.SedeFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SEDES;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public SedeDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var sedeNegocio = new SedeNegocioImpl(daoFactory);

		try {
			var sedeDominio = sedeNegocio.consultarPorid(id);
			return SedeDTOAssembler.getInstance().convertirADTO(sedeDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.SedeFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_SEDE_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
