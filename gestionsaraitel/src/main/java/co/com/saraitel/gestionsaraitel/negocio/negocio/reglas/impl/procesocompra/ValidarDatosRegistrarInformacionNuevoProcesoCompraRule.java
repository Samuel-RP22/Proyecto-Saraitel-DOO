package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import co.com.saraitel.gestionsaraitel.dominio.ProcesoCompraDominio;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

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
		var cliente = dominio.getCliente();
		var usaClienteGenerico = !cliente.getEsClienteRegistrado()
				&& UtilUUID.esValorDefecto(cliente.getId());
		if (!usaClienteGenerico) {
			AsegurarClienteProcesoCompraValidoRule.obtenerInstancia().ejecutar(cliente.getId());
		}
		AsegurarEmpleadoProcesoCompraValidoRule.obtenerInstancia().ejecutar(dominio.getEmpleado().getId());
	}
}
