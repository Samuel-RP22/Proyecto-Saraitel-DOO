package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.SedeEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarNitNuevaSedeNoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarNitNuevaSedeNoExistaRule();

	private AsegurarNitNuevaSedeNoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var nitSede = (String) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var entidadFiltro = new SedeEntidad();
		entidadFiltro.setNit(nitSede);

		var resultados = daoFactory.obtenerSedeDao().consultarPorFiltro(entidadFiltro);

		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.SedeNegocioImpl.SEDE_YA_EXISTE_CON_EL_MISMO_NIT_DE_SEDE_A_CREAR;

			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
