package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarTelefonoPersonaNoExistaEnOtraPersonaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarTelefonoPersonaNoExistaEnOtraPersonaRule();

	private AsegurarTelefonoPersonaNoExistaEnOtraPersonaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 3);

		var idPersona = (UUID) datos[0];
		var telefonoPersona = (String) datos[1];
		var daoFactory = (DAOFactory) datos[2];

		var entidadFiltro = new PersonaEntidad();
		entidadFiltro.setTelefono(telefonoPersona);

		var resultados = daoFactory.obtenerPersonaDao().consultarPorFiltro(entidadFiltro);

		if (resultados.stream().anyMatch(persona -> !persona.getId().equals(idPersona))) {
			var mensajeUsuario = CatalogoMensajes.PersonaNegocioImpl.TELEFONO_PERSONA_YA_EXISTE_EN_OTRA_PERSONA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
