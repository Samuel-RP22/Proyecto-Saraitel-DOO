package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarTelefonoNuevaPersonaNoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarTelefonoNuevaPersonaNoExistaRule();

	private AsegurarTelefonoNuevaPersonaNoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var telefonoPersona = (String) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var entidadFiltro = new PersonaEntidad();
		entidadFiltro.setTelefono(telefonoPersona);

		var resultados = daoFactory.obtenerPersonaDao().consultarPorFiltro(entidadFiltro);

		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.PERSONA_YA_EXISTE_CON_EL_MISMO_TELEFONO_DE_PERSONA_A_CREAR;

			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
