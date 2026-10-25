package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.ProcesoCompraDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.ProcesoCompraFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.ProcesoCompraDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.ProcesoCompraNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class ProcesoCompraFachadaImpl implements ProcesoCompraFachada {

	@Override
	public void registrarInformacionNuevoProcesoCompra(ProcesoCompraDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var procesoCompraNegocio = new ProcesoCompraNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var procesoCompraDominio = ProcesoCompraDTOAssembler.getInstance().convertirADominio(datos);
			procesoCompraNegocio.registrarInformacionNuevoProcesoCompra(procesoCompraDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_PROCESO_COMPRA;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<ProcesoCompraDTO> consultarPorFiltro(ProcesoCompraDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var procesoCompraNegocio = new ProcesoCompraNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var filtroDominio = ProcesoCompraDTOAssembler.getInstance().convertirADominio(filtro);
			var listaProcesosCompra = procesoCompraNegocio.consultarPorFiltro(filtroDominio);
			var resultado = ProcesoCompraDTOAssembler.getInstance().convertirADTO(listaProcesosCompra);
			daoFactory.confirmarTransaccion();
			return resultado;
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PROCESOS_COMPRA_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<ProcesoCompraDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var procesoCompraNegocio = new ProcesoCompraNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var listaProcesosCompra = procesoCompraNegocio.consultarTodos();
			var resultado = ProcesoCompraDTOAssembler.getInstance().convertirADTO(listaProcesosCompra);
			daoFactory.confirmarTransaccion();
			return resultado;
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PROCESOS_COMPRA;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public ProcesoCompraDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var procesoCompraNegocio = new ProcesoCompraNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var procesoCompraDominio = procesoCompraNegocio.consultarPorid(id);
			var resultado = ProcesoCompraDTOAssembler.getInstance().convertirADTO(procesoCompraDominio);
			daoFactory.confirmarTransaccion();
			return resultado;
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PROCESO_COMPRA_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
