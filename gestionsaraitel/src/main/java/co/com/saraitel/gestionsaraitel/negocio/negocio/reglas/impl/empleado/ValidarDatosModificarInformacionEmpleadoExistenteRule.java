package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.empleado;

import co.com.saraitel.gestionsaraitel.dominio.EmpleadoDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;

public class ValidarDatosModificarInformacionEmpleadoExistenteRule implements Rule<EmpleadoDominio> {

	private static final Rule<EmpleadoDominio> instancia = new ValidarDatosModificarInformacionEmpleadoExistenteRule();

	private ValidarDatosModificarInformacionEmpleadoExistenteRule() {
	}

	public static final Rule<EmpleadoDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(EmpleadoDominio... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var dominio = datos[0];

		AsegurarSedeEmpleadoValidaRule.obtenerInstancia().ejecutar(dominio.getSede().getId());
		AsegurarEsActivoEmpleadoValidoRule.obtenerInstancia().ejecutar(dominio.getEsActivo());
	}
}
