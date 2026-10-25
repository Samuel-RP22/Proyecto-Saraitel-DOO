package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.DepartamentoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.DepartamentoFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.DepartamentoDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.DepartamentoNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class DepartamentoFachadaImpl implements DepartamentoFachada {

	@Override
	public List<DepartamentoDTO> consultarPorFiltro(DepartamentoDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var departamentoNegocio = new DepartamentoNegocioImpl(daoFactory);

		try {
			var filtroDominio = DepartamentoDTOAssembler.getInstance().convertirADominio(filtro);
			var listaDepartamentos = departamentoNegocio.consultarPorFiltro(filtroDominio);
			return DepartamentoDTOAssembler.getInstance().convertirADTO(listaDepartamentos);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.DepartamentoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEPARTAMENTOS_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<DepartamentoDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var departamentoNegocio = new DepartamentoNegocioImpl(daoFactory);

		try {
			var listaDepartamentos = departamentoNegocio.consultarTodos();
			return DepartamentoDTOAssembler.getInstance().convertirADTO(listaDepartamentos);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.DepartamentoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEPARTAMENTOS;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public DepartamentoDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var departamentoNegocio = new DepartamentoNegocioImpl(daoFactory);

		try {
			var departamentoDominio = departamentoNegocio.consultarPorid(id);
			return DepartamentoDTOAssembler.getInstance().convertirADTO(departamentoDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.DepartamentoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEPARTAMENTO_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
