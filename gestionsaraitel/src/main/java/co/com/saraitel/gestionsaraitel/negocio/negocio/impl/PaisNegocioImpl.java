package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DaoFactory;
import co.com.saraitel.gestionsaraitel.dominio.PaisDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.PaisNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.PaisEntidadAssembler;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.pais.AsegurarNombreNuevoPaisNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.pais.ValidarDatosRegistrarInformacionNuevoPaisRule;

public class PaisNegocioImpl implements PaisNegocio {
	
	private DaoFactory daoFactory;

	protected PaisNegocioImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void registrarInformacionNuevoPais(PaisDominio datos) {
		ValidarDatosRegistrarInformacionNuevoPaisRule.obtenerInstancia().ejecutar(datos);
		AsegurarNombreNuevoPaisNoExistaRule.obtenerInstancia().ejecutar(datos.getNombre(), daoFactory);
		var paisEntidad = PaisEntidadAssembler.getInstance().convertirAEntidad(datos);
		paisEntidad.setId(generarIdPaisUnico());
		daoFactory.obtenerPaisDao().crear(paisEntidad);
	}
	
	
	private UUID generarIdPaisUnico() {
	    UUID id;
	    do {
	        id = UUID.randomUUID();
	    } while (!daoFactory.obtenerPaisDao().consultarPorId(id).equals(id));
	    return id;
	}



	@Override
	public void modificarInformacionPaisExistente(UUID id, PaisDominio datos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void darBajaInformacionPaisExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PaisDominio> consultarPorFiltro(PaisDominio filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDominio> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaisDominio consultarPorid(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
