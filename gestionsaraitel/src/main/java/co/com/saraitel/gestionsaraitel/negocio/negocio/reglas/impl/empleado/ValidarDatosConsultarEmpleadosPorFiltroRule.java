package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado;

import co.com.saraitel.gestionsaraitel.dominio.EmpleadoDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarApellidoPersonaValidoRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarCorreoPersonaValidoRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarNombrePersonaValidoRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarNumeroDocumentoPersonaValidoRule;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.persona.AsegurarTelefonoPersonaValidoRule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class ValidarDatosConsultarEmpleadosPorFiltroRule implements Rule<EmpleadoDominio> {

	private static final Rule<EmpleadoDominio> instancia = new ValidarDatosConsultarEmpleadosPorFiltroRule();

	private ValidarDatosConsultarEmpleadosPorFiltroRule() {
	}

	public static final Rule<EmpleadoDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(EmpleadoDominio... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var persona = datos[0].getPersona();

		if (!UtilTexto.esVacia(persona.getNumeroDocumento())) {
			AsegurarNumeroDocumentoPersonaValidoRule.obtenerInstancia().ejecutar(persona.getNumeroDocumento());
		}

		if (!UtilTexto.esVacia(persona.getNombre())) {
			AsegurarNombrePersonaValidoRule.obtenerInstancia().ejecutar(persona.getNombre());
		}

		if (!UtilTexto.esVacia(persona.getApellido())) {
			AsegurarApellidoPersonaValidoRule.obtenerInstancia().ejecutar(persona.getApellido());
		}

		if (!UtilTexto.esVacia(persona.getTelefono())) {
			AsegurarTelefonoPersonaValidoRule.obtenerInstancia().ejecutar(persona.getTelefono());
		}

		if (!UtilTexto.esVacia(persona.getCorreo())) {
			AsegurarCorreoPersonaValidoRule.obtenerInstancia().ejecutar(persona.getCorreo());
		}
	}
}
