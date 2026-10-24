package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarCorreoNuevaPersonaNoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarCorreoNuevaPersonaNoExistaRule();

	private AsegurarCorreoNuevaPersonaNoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var correoPersona = (String) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var entidadFiltro = new PersonaEntidad();
		entidadFiltro.setCorreo(correoPersona);

		var resultados = daoFactory.obtenerPersonaDao().consultarPorFiltro(entidadFiltro);

		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.PERSONA_YA_EXISTE_CON_EL_MISMO_CORREO_DE_PERSONA_A_CREAR;

			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
