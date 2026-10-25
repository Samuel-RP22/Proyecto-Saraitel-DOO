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
			var filtroDominio = TipoDocumentoDTOAssembler.getInstance().convertirADominio(filtro);
			var listaTiposDocumento = tipoDocumentoNegocio.consultarPorFiltro(filtroDominio);
			return TipoDocumentoDTOAssembler.getInstance().convertirADTO(listaTiposDocumento);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
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
			var listaTiposDocumento = tipoDocumentoNegocio.consultarTodos();
			return TipoDocumentoDTOAssembler.getInstance().convertirADTO(listaTiposDocumento);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
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
			var tipoDocumentoDominio = tipoDocumentoNegocio.consultarPorid(id);
			return TipoDocumentoDTOAssembler.getInstance().convertirADTO(tipoDocumentoDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.TipoDocumentoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TIPO_DOCUMENTO_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
