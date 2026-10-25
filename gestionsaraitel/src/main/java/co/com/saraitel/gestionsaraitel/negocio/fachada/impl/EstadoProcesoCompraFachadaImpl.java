package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.EstadoProcesoCompraDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.EstadoProcesoCompraFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.EstadoProcesoCompraDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.EstadoProcesoCompraNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class EstadoProcesoCompraFachadaImpl implements EstadoProcesoCompraFachada {

	@Override
	public void registrarInformacionNuevoEstadoProcesoCompra(EstadoProcesoCompraDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var estadoProcesoCompraNegocio = new EstadoProcesoCompraNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var estadoProcesoCompraDominio = EstadoProcesoCompraDTOAssembler.getInstance().convertirADominio(datos);
			estadoProcesoCompraNegocio.registrarInformacionNuevoEstadoProcesoCompra(estadoProcesoCompraDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.EstadoProcesoCompraFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_ESTADO_PROCESO_COMPRA;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<EstadoProcesoCompraDTO> consultarPorFiltro(EstadoProcesoCompraDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var estadoProcesoCompraNegocio = new EstadoProcesoCompraNegocioImpl(daoFactory);

		try {
			var filtroDominio = EstadoProcesoCompraDTOAssembler.getInstance().convertirADominio(filtro);
			var listaEstadosProcesoCompra = estadoProcesoCompraNegocio.consultarPorFiltro(filtroDominio);
			return EstadoProcesoCompraDTOAssembler.getInstance().convertirADTO(listaEstadosProcesoCompra);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.EstadoProcesoCompraFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_PROCESO_COMPRA_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<EstadoProcesoCompraDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var estadoProcesoCompraNegocio = new EstadoProcesoCompraNegocioImpl(daoFactory);

		try {
			var listaEstadosProcesoCompra = estadoProcesoCompraNegocio.consultarTodos();
			return EstadoProcesoCompraDTOAssembler.getInstance().convertirADTO(listaEstadosProcesoCompra);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.EstadoProcesoCompraFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADOS_PROCESO_COMPRA;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public EstadoProcesoCompraDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var estadoProcesoCompraNegocio = new EstadoProcesoCompraNegocioImpl(daoFactory);

		try {
			var estadoProcesoCompraDominio = estadoProcesoCompraNegocio.consultarPorid(id);
			return EstadoProcesoCompraDTOAssembler.getInstance().convertirADTO(estadoProcesoCompraDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.EstadoProcesoCompraFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_ESTADO_PROCESO_COMPRA_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
