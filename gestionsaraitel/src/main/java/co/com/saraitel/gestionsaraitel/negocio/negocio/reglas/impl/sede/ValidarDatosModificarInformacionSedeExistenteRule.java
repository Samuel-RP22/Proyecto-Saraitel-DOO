package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede;

import co.com.saraitel.gestionsaraitel.dominio.SedeDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;

public class ValidarDatosModificarInformacionSedeExistenteRule implements Rule<SedeDominio> {

	private static final Rule<SedeDominio> instancia = new ValidarDatosModificarInformacionSedeExistenteRule();

	private ValidarDatosModificarInformacionSedeExistenteRule() {
	}

	public static final Rule<SedeDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(SedeDominio... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var dominio = datos[0];

		AsegurarNombreSedeValidoRule.obtenerInstancia().ejecutar(dominio.getNombre());
		AsegurarNitSedeValidoRule.obtenerInstancia().ejecutar(dominio.getNit());
		AsegurarDireccionSedeValidaRule.obtenerInstancia().ejecutar(dominio.getDireccion());
		AsegurarEsActivaSedeValidaRule.obtenerInstancia().ejecutar(dominio.getEsActiva());
	}
}
