package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.CategoriaDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.CategoriaFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.CategoriaDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.CategoriaNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.mensajes.CatalogoMensajes;

public class CategoriaFachadaImpl implements CategoriaFachada {

	@Override
	public void registrarInformacionNuevaCategoria(CategoriaDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var categoriaNegocio = new CategoriaNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var categoriaDominio = CategoriaDTOAssembler.getInstance().convertirADominio(datos);
			categoriaNegocio.registrarInformacionNuevaCategoria(categoriaDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.CategoriaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_CATEGORIA;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarInformacionCategoriaExistente(UUID id, CategoriaDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var categoriaNegocio = new CategoriaNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var categoriaDominio = CategoriaDTOAssembler.getInstance().convertirADominio(datos);
			categoriaNegocio.modificarInformacionCategoriaExistente(id, categoriaDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.CategoriaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_MODIFICANDO_CATEGORIA;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaInformacionCategoriaExistente(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var categoriaNegocio = new CategoriaNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			categoriaNegocio.darBajaInformacionCategoriaExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.CategoriaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_DANDO_DE_BAJA_CATEGORIA;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<CategoriaDTO> consultarPorFiltro(CategoriaDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var categoriaNegocio = new CategoriaNegocioImpl(daoFactory);

		try {
			var filtroDominio = CategoriaDTOAssembler.getInstance().convertirADominio(filtro);
			var listaCategorias = categoriaNegocio.consultarPorFiltro(filtroDominio);
			return CategoriaDTOAssembler.getInstance().convertirADTO(listaCategorias);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.CategoriaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CATEGORIAS_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<CategoriaDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var categoriaNegocio = new CategoriaNegocioImpl(daoFactory);

		try {
			var listaCategorias = categoriaNegocio.consultarTodos();
			return CategoriaDTOAssembler.getInstance().convertirADTO(listaCategorias);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.CategoriaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CATEGORIAS;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public CategoriaDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var categoriaNegocio = new CategoriaNegocioImpl(daoFactory);

		try {
			var categoriaDominio = categoriaNegocio.consultarPorid(id);
			return CategoriaDTOAssembler.getInstance().convertirADTO(categoriaDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.CategoriaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CATEGORIA_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}