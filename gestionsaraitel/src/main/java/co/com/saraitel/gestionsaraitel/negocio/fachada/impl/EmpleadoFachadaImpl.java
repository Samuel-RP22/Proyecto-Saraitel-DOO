package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.EmpleadoDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.EmpleadoFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.EmpleadoDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.EmpleadoNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class EmpleadoFachadaImpl implements EmpleadoFachada {

	@Override
	public void registrarInformacionNuevoEmpleado(EmpleadoDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var empleadoNegocio = new EmpleadoNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var empleadoDominio = EmpleadoDTOAssembler.getInstance().convertirADominio(datos);
			empleadoNegocio.registrarInformacionNuevoEmpleado(empleadoDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.EmpleadoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_EMPLEADO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarInformacionEmpleadoExistente(UUID id, EmpleadoDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var empleadoNegocio = new EmpleadoNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var empleadoDominio = EmpleadoDTOAssembler.getInstance().convertirADominio(datos);
			empleadoNegocio.modificarInformacionEmpleadoExistente(id, empleadoDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.EmpleadoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_MODIFICANDO_EMPLEADO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaInformacionEmpleadoExistente(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var empleadoNegocio = new EmpleadoNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			empleadoNegocio.darBajaInformacionEmpleadoExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.EmpleadoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_DANDO_DE_BAJA_EMPLEADO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<EmpleadoDTO> consultarPorFiltro(EmpleadoDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var empleadoNegocio = new EmpleadoNegocioImpl(daoFactory);

		try {
			var filtroDominio = EmpleadoDTOAssembler.getInstance().convertirADominio(filtro);
			var listaEmpleados = empleadoNegocio.consultarPorFiltro(filtroDominio);
			return EmpleadoDTOAssembler.getInstance().convertirADTO(listaEmpleados);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.EmpleadoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_EMPLEADOS_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<EmpleadoDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var empleadoNegocio = new EmpleadoNegocioImpl(daoFactory);

		try {
			var listaEmpleados = empleadoNegocio.consultarTodos();
			return EmpleadoDTOAssembler.getInstance().convertirADTO(listaEmpleados);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.EmpleadoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_EMPLEADOS;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public EmpleadoDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var empleadoNegocio = new EmpleadoNegocioImpl(daoFactory);

		try {
			var empleadoDominio = empleadoNegocio.consultarPorid(id);
			return EmpleadoDTOAssembler.getInstance().convertirADTO(empleadoDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.EmpleadoFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_EMPLEADO_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
