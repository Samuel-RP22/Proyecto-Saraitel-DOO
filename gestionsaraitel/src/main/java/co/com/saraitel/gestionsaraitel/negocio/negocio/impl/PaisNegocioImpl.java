package co.com.saraitel.gestionsaraitel.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;
import co.com.saraitel.gestionsaraitel.dao.factoria.DaoFactory;
import co.com.saraitel.gestionsaraitel.dominio.PaisDominio;
import co.com.saraitel.gestionsaraitel.entidad.PaisEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.PaisNegocio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.assembler.impl.PaisEntidadAssembler;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;

public class PaisNegocioImpl implements PaisNegocio {
	
	private DaoFactory daoFactory;

	protected PaisNegocioImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public void registrarInformacionNuevoPais(PaisDominio datos) {
		asegurarDatosRegistroNuevoPaisValidos(datos);
		asegurarNombreNuevoPaisNoExista(datos.getNombre());
		
		var paisEntidad = PaisEntidadAssembler.getInstance().convertirAEntidad(datos);
		paisEntidad.setId(generarIdPaisUnico());
		
		
		daoFactory.obtenerPaisDao().crear(paisEntidad);
	}
	
	private void asegurarDatosRegistroNuevoPaisValidos(PaisDominio datos) {
		
	}
	
	private void asegurarNombreNuevoPaisNoExista(String nombrePais) {
		var entidadFiltro = new PaisEntidad();
		entidadFiltro.setNombre(nombrePais);
		
		var resultados = daoFactory.obtenerPaisDao().consultarPorFiltro(entidadFiltro);
		
		if(!resultados.isEmpty()) {
			var mensajeUsuario =  CatalogoMensajes.PaisNegocioImpl.PAIS_EXISTE_CON_EL_MISMO_NOMBRE_PAIS_CREAR;
		}
	}

	private void generarIdPaisUnico() {
		UUID.randomUUID();
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
