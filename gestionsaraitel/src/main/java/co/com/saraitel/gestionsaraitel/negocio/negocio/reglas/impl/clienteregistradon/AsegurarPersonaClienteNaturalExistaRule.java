package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradon;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarPersonaClienteNaturalExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarPersonaClienteNaturalExistaRule();

	private AsegurarPersonaClienteNaturalExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var idPersona = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var personaExistente = daoFactory.obtenerPersonaDao().consultarPorId(idPersona);

		if (personaExistente.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNNegocioImpl.PERSONA_CLIENTE_NATURAL_NO_EXISTE;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
