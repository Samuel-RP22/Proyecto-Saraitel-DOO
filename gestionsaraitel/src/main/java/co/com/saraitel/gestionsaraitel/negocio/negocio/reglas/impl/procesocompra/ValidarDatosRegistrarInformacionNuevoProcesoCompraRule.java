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

		// El cliente no registrado se crea en el momento de la venta, por eso solo
		// se exige el id cuando se trata de un cliente registrado o de uno ya existente.
		var esClienteNoRegistradoNuevo = !cliente.getEsClienteRegistrado()
				&& cliente.getId().equals(UtilUUID.obtenerUUIDDefecto());

		if (!esClienteNoRegistradoNuevo) {
			AsegurarClienteProcesoCompraValidoRule.obtenerInstancia().ejecutar(cliente.getId());
		}

		AsegurarEmpleadoProcesoCompraValidoRule.obtenerInstancia().ejecutar(dominio.getEmpleado().getId());
	}
}
