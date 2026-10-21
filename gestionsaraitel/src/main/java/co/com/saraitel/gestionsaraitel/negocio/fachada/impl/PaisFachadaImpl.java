package co.com.saraitel.gestionsaraitel.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dto.PaisDTO;
import co.com.saraitel.gestionsaraitel.negocio.fachada.PaisFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.assembler.impl.PaisDTOAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.PaisNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.impl.PaisNegocioImpl;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelFachadaExcepcion;


public class PaisFachadaImpl implements PaisFachada {

	private DAOFactory daoFactory;
	private PaisNegocio paisNegocio;
	
	public PaisFachadaImpl() {
		daoFactory = DAOFactory.obtenerFactoria();
		paisNegocio = new PaisNegocioImpl(daoFactory);
	}
	
	@Override
	public void registrarInformacionNuevoPais(PaisDTO datos) {
	    daoFactory.iniciarTransaccion();
	    
	    try {
	        var paisDominio = PaisDTOAssembler.getInstance().convertirADominio(datos);
	        paisNegocio.registrarInformacionNuevoPais(paisDominio);
	        daoFactory.confirmarTransaccion();
	    } catch (GestionSaraitelExcepcion excepcion) {
	        daoFactory.cancelarTransaccion(); 
	        throw excepcion;
	    } catch (Exception excepcion) {
	        daoFactory.cancelarTransaccion();
	        var mensajeUsuario = "Se ha presentado un problema inesperado tratando de registrar la información del nuevo país, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	        throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
	    } finally {
	        daoFactory.cerrarConexion();
	    }   
	}

	@Override
	public void modificarInformacionPaisExistente(UUID id, PaisDTO datos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaInformacionPaisExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PaisDTO> consultarPorFiltro(PaisDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDTO> consultarTodos() {
	    try {
	        var listaPaises = paisNegocio.consultarTodos();
	        return PaisDTOAssembler.getInstance().convertirADTO(listaPaises);
	    } catch (GestionSaraitelExcepcion excepcion) {
	        throw excepcion;
	    } catch (Exception excepcion) {
	        var mensajeUsuario = "Se ha presentado un problema inesperado tratando de consultar la información de los países, por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación";
	        throw GestionSaraitelFachadaExcepcion.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
	    } finally {
	        daoFactory.cerrarConexion();
	    }
	}

	@Override
	public PaisDTO consultarPorid(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
