package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.PersonaDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.PersonaFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.PersonaDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.PersonaNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;

public class PersonaFachadaImpl implements PersonaFachada {

	@Override
	public void registrarInformacionNuevaPersona(PersonaDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var personaNegocio = new PersonaNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var personaDominio = PersonaDTOAssembler.getInstance().convertirADominio(datos);
			personaNegocio.registrarInformacionNuevaPersona(personaDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.PersonaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_PERSONA;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void modificarInformacionPersonaExistente(UUID id, PersonaDTO datos) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var personaNegocio = new PersonaNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			var personaDominio = PersonaDTOAssembler.getInstance().convertirADominio(datos);
			personaNegocio.modificarInformacionPersonaExistente(id, personaDominio);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.PersonaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_MODIFICANDO_PERSONA;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public void darBajaInformacionPersonaExistente(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var personaNegocio = new PersonaNegocioImpl(daoFactory);

		daoFactory.iniciarTransaccion();

		try {
			personaNegocio.darBajaInformacionPersonaExistente(id);
			daoFactory.confirmarTransaccion();
		} catch (GestionSaraitelExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			var mensajeUsuario = CatalogoMensajes.PersonaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_DANDO_DE_BAJA_PERSONA;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<PersonaDTO> consultarPorFiltro(PersonaDTO filtro) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var personaNegocio = new PersonaNegocioImpl(daoFactory);

		try {
			var filtroDominio = PersonaDTOAssembler.getInstance().convertirADominio(filtro);
			var listaPersonas = personaNegocio.consultarPorFiltro(filtroDominio);
			return PersonaDTOAssembler.getInstance().convertirADTO(listaPersonas);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PersonaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PERSONAS_CON_FILTRO;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public List<PersonaDTO> consultarTodos() {
		var daoFactory = DAOFactory.obtenerFactoria();
		var personaNegocio = new PersonaNegocioImpl(daoFactory);

		try {
			var listaPersonas = personaNegocio.consultarTodos();
			return PersonaDTOAssembler.getInstance().convertirADTO(listaPersonas);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PersonaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PERSONAS;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

	@Override
	public PersonaDTO consultarPorId(UUID id) {
		var daoFactory = DAOFactory.obtenerFactoria();
		var personaNegocio = new PersonaNegocioImpl(daoFactory);

		try {
			var personaDominio = personaNegocio.consultarPorid(id);
			return PersonaDTOAssembler.getInstance().convertirADTO(personaDominio);
		} catch (GestionSaraitelExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PersonaFachadaImpl.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PERSONA_POR_ID;
			throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}
}
