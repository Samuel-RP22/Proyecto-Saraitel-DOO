package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede;

import co.com.saraitel.gestionsaraitel.dominio.SedeDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class ValidarDatosConsultarSedesPorFiltroRule implements Rule<SedeDominio> {

	private static final Rule<SedeDominio> instancia = new ValidarDatosConsultarSedesPorFiltroRule();

	private ValidarDatosConsultarSedesPorFiltroRule() {
	}

	public static final Rule<SedeDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(SedeDominio... datos) {
		Rule.asegurarCantidadDatos(datos, 1);

		var filtro = datos[0];

		if (!UtilTexto.esVacia(filtro.getNombre())) {
			AsegurarNombreSedeValidoRule.obtenerInstancia().ejecutar(filtro.getNombre());
		}

		if (!UtilTexto.esVacia(filtro.getNit())) {
			AsegurarNitSedeValidoRule.obtenerInstancia().ejecutar(filtro.getNit());
		}

		if (!UtilTexto.esVacia(filtro.getDireccion())) {
			AsegurarDireccionSedeValidaRule.obtenerInstancia().ejecutar(filtro.getDireccion());
		}
	}
}
