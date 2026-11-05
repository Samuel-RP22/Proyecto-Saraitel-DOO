package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradon;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.dominio.ClienteRegistradoNDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarCorreoNuevaPersonaNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarNumeroDocumentoNuevaPersonaNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarTelefonoNuevaPersonaNoExistaRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.ValidarDatosRegistrarInformacionNuevaPersonaRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ValidarDatosRegistrarInformacionNuevoClienteNaturalRule implements Rule<Object> {

	private static final Rule<Object> instancia = new ValidarDatosRegistrarInformacionNuevoClienteNaturalRule();

	private ValidarDatosRegistrarInformacionNuevoClienteNaturalRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var dominio = (ClienteRegistradoNDominio) datos[0];
		var daoFactory = (DAOFactory) datos[1];
		var persona = dominio.getPersona();

		if (UtilUUID.esValorDefecto(persona.getId())) {
			ValidarDatosRegistrarInformacionNuevaPersonaRule.obtenerInstancia().ejecutar(persona);
			AsegurarNumeroDocumentoNuevaPersonaNoExistaRule.obtenerInstancia().ejecutar(persona.getNumeroDocumento(),
					daoFactory);
			AsegurarTelefonoNuevaPersonaNoExistaRule.obtenerInstancia().ejecutar(persona.getTelefono(), daoFactory);
			AsegurarCorreoNuevaPersonaNoExistaRule.obtenerInstancia().ejecutar(persona.getCorreo(), daoFactory);
		} else {
			AsegurarPersonaClienteNaturalExistaRule.obtenerInstancia().ejecutar(persona.getId(), daoFactory);
			AsegurarPersonaNoSeaClienteNaturalRule.obtenerInstancia().ejecutar(persona.getId(), daoFactory);
		}
	}
}
