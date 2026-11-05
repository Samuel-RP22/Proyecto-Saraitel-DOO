package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona;

import co.com.saraitel.gestionsaraitel.dominio.PersonaDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class ValidarDatosConsultarPersonasPorFiltroRule implements Rule<PersonaDominio> {

	private static final Rule<PersonaDominio> instancia = new ValidarDatosConsultarPersonasPorFiltroRule();

	private ValidarDatosConsultarPersonasPorFiltroRule() {
	}

	public static final Rule<PersonaDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(PersonaDominio... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var filtro = datos[0];

		if (!UtilTexto.esVacia(filtro.getNumeroDocumento())) {
			AsegurarNumeroDocumentoPersonaValidoRule.obtenerInstancia().ejecutar(filtro.getNumeroDocumento());
		}

		if (!UtilTexto.esVacia(filtro.getNombre())) {
			AsegurarNombrePersonaValidoRule.obtenerInstancia().ejecutar(filtro.getNombre());
		}

		if (!UtilTexto.esVacia(filtro.getApellido())) {
			AsegurarApellidoPersonaValidoRule.obtenerInstancia().ejecutar(filtro.getApellido());
		}

		if (!UtilTexto.esVacia(filtro.getTelefono())) {
			AsegurarTelefonoPersonaValidoRule.obtenerInstancia().ejecutar(filtro.getTelefono());
		}

		if (!UtilTexto.esVacia(filtro.getCorreo())) {
			AsegurarCorreoPersonaValidoRule.obtenerInstancia().ejecutar(filtro.getCorreo());
		}
	}
}
