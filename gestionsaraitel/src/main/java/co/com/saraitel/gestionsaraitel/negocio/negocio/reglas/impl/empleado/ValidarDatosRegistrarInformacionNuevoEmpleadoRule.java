package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado;

import co.com.saraitel.gestionsaraitel.dominio.EmpleadoDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;

public class ValidarDatosRegistrarInformacionNuevoEmpleadoRule implements Rule<EmpleadoDominio> {

	private static final Rule<EmpleadoDominio> instancia = new ValidarDatosRegistrarInformacionNuevoEmpleadoRule();

	private ValidarDatosRegistrarInformacionNuevoEmpleadoRule() {
	}

	public static final Rule<EmpleadoDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(EmpleadoDominio... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var dominio = datos[0];

		AsegurarSedeEmpleadoValidaRule.obtenerInstancia().ejecutar(dominio.getSede().getId());
		AsegurarPersonaEmpleadoValidaRule.obtenerInstancia().ejecutar(dominio.getPersona().getId());
	}
}
