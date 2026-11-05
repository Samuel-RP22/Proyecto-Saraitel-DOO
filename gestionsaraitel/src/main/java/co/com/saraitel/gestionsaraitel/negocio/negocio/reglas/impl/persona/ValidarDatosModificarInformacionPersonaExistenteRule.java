package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona;

import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;

public class ValidarDatosModificarInformacionPersonaExistenteRule implements Rule<PersonaDominio> {

	private static final Rule<PersonaDominio> instancia = new ValidarDatosModificarInformacionPersonaExistenteRule();

	private ValidarDatosModificarInformacionPersonaExistenteRule() {
	}

	public static final Rule<PersonaDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(PersonaDominio... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var dominio = datos[0];

		AsegurarNumeroDocumentoPersonaValidoRule.obtenerInstancia().ejecutar(dominio.getNumeroDocumento());
		AsegurarPrefijoPersonaValidoRule.obtenerInstancia().ejecutar(dominio.getPrefijo().getId());
		AsegurarTelefonoPersonaValidoRule.obtenerInstancia().ejecutar(dominio.getTelefono());
		AsegurarNombrePersonaValidoRule.obtenerInstancia().ejecutar(dominio.getNombre());
		AsegurarApellidoPersonaValidoRule.obtenerInstancia().ejecutar(dominio.getApellido());
		AsegurarCorreoPersonaValidoRule.obtenerInstancia().ejecutar(dominio.getCorreo());
	}
}
