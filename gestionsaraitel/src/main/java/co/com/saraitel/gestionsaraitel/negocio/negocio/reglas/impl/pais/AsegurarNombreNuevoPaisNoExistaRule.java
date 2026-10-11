package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.pais;

import co.com.saraitel.gestionsaraitel.entidad.PaisEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioException;

public class AsegurarNombreNuevoPaisNoExistaRule implements Rule<Object> {
	
	private static final Rule<Object> instancia = new AsegurarNombreNuevoPaisNoExistaRule();
	
	private AsegurarNombreNuevoPaisNoExistaRule() {
	}
	
	public static final Rule<Object> obtenerInstancia(){
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		
		var nombrePais = (String) datos[0];
		var daoFactory = (String) datos[1];
		
		var entidadFiltro = new PaisEntidad();
		entidadFiltro.setNombre(nombrePais);
		var resultados = daoFactory.obtenerPaisDao().consultarPorFiltro(entidadFiltro);
		
		if(!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.PaisNegocioImpl.PAIS_YA_EXISTE_CON_EL_MISMO_NOMBRE_DE_PAIS_A_CREAR;
			throw GestionSaraitelNegocioException.crear(mensajeUsuario);
		}
	}

}
