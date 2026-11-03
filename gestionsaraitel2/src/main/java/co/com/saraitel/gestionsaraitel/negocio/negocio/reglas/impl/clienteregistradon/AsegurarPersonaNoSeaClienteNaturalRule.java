package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradon;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoNEntidad;
import co.com.saraitel.gestionsaraitel.entidad.PersonaEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarPersonaNoSeaClienteNaturalRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarPersonaNoSeaClienteNaturalRule();

	private AsegurarPersonaNoSeaClienteNaturalRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var idPersona = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var personaFiltro = new PersonaEntidad();
		personaFiltro.setId(idPersona);

		var entidadFiltro = new ClienteRegistradoNEntidad();
		entidadFiltro.setPersona(personaFiltro);

		if (!daoFactory.obtenerClienteRegistradoNDao().consultarPorFiltro(entidadFiltro).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNNegocioImpl.PERSONA_YA_ES_CLIENTE_NATURAL;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
