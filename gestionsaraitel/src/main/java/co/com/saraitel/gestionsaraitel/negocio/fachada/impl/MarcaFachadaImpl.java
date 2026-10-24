package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.MarcaDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.MarcaFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.MarcaDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.MarcaNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.mensajes.CatalogoMensajes;

public class MarcaFachadaImpl implements MarcaFachada {

	@Override
	public void registrarInformacionNuevaMarca(MarcaDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var marcaNegocio = new MarcaNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var marcaDominio = MarcaDTOAssembler.getInstance().convertirADominio(datos);
			marcaNegocio.registrarInformacionNuevaMarca(marcaDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.MarcaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_MARCA;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<MarcaDTO> consultarPorFiltro(MarcaDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var marcaNegocio = new MarcaNegocioImpl(daoFactory);

		try {
			var filtroDominio = MarcaDTOAssembler.getInstance().convertirADominio(filtro);
			var listaMarcas = marcaNegocio.consultarPorFiltro(filtroDominio);
			return MarcaDTOAssembler.getInstance().convertirADTO(listaMarcas);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.MarcaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_MARCAS_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<MarcaDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var marcaNegocio = new MarcaNegocioImpl(daoFactory);

		try {
			var listaMarcas = marcaNegocio.consultarTodos();
			return MarcaDTOAssembler.getInstance().convertirADTO(listaMarcas);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.MarcaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_MARCAS;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public MarcaDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var marcaNegocio = new MarcaNegocioImpl(daoFactory);

		try {
			var marcaDominio = marcaNegocio.consultarPorId(id);
			return MarcaDTOAssembler.getInstance().convertirADTO(marcaDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.MarcaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_MARCA_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}