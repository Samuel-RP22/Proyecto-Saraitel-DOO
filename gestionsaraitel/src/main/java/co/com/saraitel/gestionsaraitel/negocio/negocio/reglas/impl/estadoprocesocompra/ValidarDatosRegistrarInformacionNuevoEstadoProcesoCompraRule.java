package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.estadoprocesocompra;

import co.com.saraitel.gestionsaraitel.dominio.EstadoProcesoCompraDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;

public class ValidarDatosRegistrarInformacionNuevoEstadoProcesoCompraRule implements Rule<EstadoProcesoCompraDominio> {

	private static final Rule<EstadoProcesoCompraDominio> instancia = new ValidarDatosRegistrarInformacionNuevoEstadoProcesoCompraRule();

	private ValidarDatosRegistrarInformacionNuevoEstadoProcesoCompraRule() {
	}

	public static final Rule<EstadoProcesoCompraDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(EstadoProcesoCompraDominio... datos) {
		var dominio = datos[0];

		AsegurarCodigoEstadoProcesoCompraValidoRule.obtenerInstancia().ejecutar(dominio.getCodigo());
		AsegurarNombreEstadoProcesoCompraValidoRule.obtenerInstancia().ejecutar(dominio.getNombre());
	}
}
