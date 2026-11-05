package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.TipoDocumentoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.TipoDocumentoFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.TipoDocumentoDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.TipoDocumentoNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class TipoDocumentoFachadaImpl implements TipoDocumentoFachada {

	@Override
	public List<TipoDocumentoDTO> consultarPorFiltro(TipoDocumentoDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var tipoDocumentoNegocio = new TipoDocumentoNegocioImpl(daoFactory);
		try {
			daoFactory.iniciarTransaccion();
			var filtroDominio = TipoDocumentoDTOAssembler.obtenerInstancia().convertirADominio(filtro);
			var listaTiposDocumento = tipoDocumentoNegocio.consultarPorFiltro(filtroDominio);
			var resultado = TipoDocumentoDTOAssembler.obtenerInstancia().convertirADTO(listaTiposDocumento);
			daoFactory.confirmarTransaccion();
			return resultado;
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.TipoDocumentoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TIPOS_DOCUMENTO_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<TipoDocumentoDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var tipoDocumentoNegocio = new TipoDocumentoNegocioImpl(daoFactory);
		try {
			daoFactory.iniciarTransaccion();
			var listaTiposDocumento = tipoDocumentoNegocio.consultarTodos();
			var resultado = TipoDocumentoDTOAssembler.obtenerInstancia().convertirADTO(listaTiposDocumento);
			daoFactory.confirmarTransaccion();
			return resultado;
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.TipoDocumentoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TIPOS_DOCUMENTO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public TipoDocumentoDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var tipoDocumentoNegocio = new TipoDocumentoNegocioImpl(daoFactory);
		try {
			daoFactory.iniciarTransaccion();
			var tipoDocumentoDominio = tipoDocumentoNegocio.consultarPorId(id);
			var resultado = TipoDocumentoDTOAssembler.obtenerInstancia().convertirADTO(tipoDocumentoDominio);
			daoFactory.confirmarTransaccion();
			return resultado;
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.TipoDocumentoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TIPO_DOCUMENTO_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
