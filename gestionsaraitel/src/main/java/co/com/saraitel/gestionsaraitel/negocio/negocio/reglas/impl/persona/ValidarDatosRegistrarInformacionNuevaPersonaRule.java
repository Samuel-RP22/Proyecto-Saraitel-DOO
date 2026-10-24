package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona;

import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;

public class ValidarDatosRegistrarInformacionNuevaPersonaRule implements Rule<PersonaDominio> {

	private static final Rule<PersonaDominio> instancia = new ValidarDatosRegistrarInformacionNuevaPersonaRule();

	private ValidarDatosRegistrarInformacionNuevaPersonaRule() {
	}

	public static final Rule<PersonaDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(PersonaDominio... datos) {
		var dominio = datos[0];

		AsegurarTipoDocumentoPersonaValidoRule.obtenerInstancia().ejecutar(dominio.getTipoDocumento().getId());
		AsegurarPrefijoPersonaValidoRule.obtenerInstancia().ejecutar(dominio.getPrefijo().getId());
		AsegurarNumeroDocumentoPersonaValidoRule.obtenerInstancia().ejecutar(dominio.getNumeroDocumento());
		AsegurarTelefonoPersonaValidoRule.obtenerInstancia().ejecutar(dominio.getTelefono());
		AsegurarNombrePersonaValidoRule.obtenerInstancia().ejecutar(dominio.getNombre());
		AsegurarApellidoPersonaValidoRule.obtenerInstancia().ejecutar(dominio.getApellido());
		AsegurarCorreoPersonaValidoRule.obtenerInstancia().ejecutar(dominio.getCorreo());
	}
}
