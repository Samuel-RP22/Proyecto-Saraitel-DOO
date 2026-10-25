package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import co.com.saraitel.gestionsaraitel.dominio.ProcesoCompraDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;

public class ValidarDatosRegistrarInformacionNuevoProcesoCompraRule implements Rule<ProcesoCompraDominio> {

	private static final Rule<ProcesoCompraDominio> instancia = new ValidarDatosRegistrarInformacionNuevoProcesoCompraRule();

	private ValidarDatosRegistrarInformacionNuevoProcesoCompraRule() {
	}

	public static final Rule<ProcesoCompraDominio> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(ProcesoCompraDominio... datos) {
		var dominio = datos[0];

		AsegurarClienteProcesoCompraValidoRule.obtenerInstancia().ejecutar(dominio.getCliente().getId());
		AsegurarEmpleadoProcesoCompraValidoRule.obtenerInstancia().ejecutar(dominio.getEmpleado().getId());
		AsegurarEstadoDelProcesoCompraValidoRule.obtenerInstancia().ejecutar(dominio.getEstado().getId());
		AsegurarFechaInicioProcesoCompraValidaRule.obtenerInstancia().ejecutar(dominio.getFechaInicio());
		AsegurarFechaActualizacionProcesoCompraValidaRule.obtenerInstancia()
				.ejecutar(dominio.getFechaActualizacion(), dominio.getFechaInicio());
		AsegurarTotalProcesoCompraValidoRule.obtenerInstancia().ejecutar(dominio.getTotal());
	}
}
