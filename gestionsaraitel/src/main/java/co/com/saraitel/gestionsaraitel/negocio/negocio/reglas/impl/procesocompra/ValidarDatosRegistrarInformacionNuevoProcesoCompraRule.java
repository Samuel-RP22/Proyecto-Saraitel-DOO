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

		// Si es cliente no registrado y no trae id, el negocio le asigna el cliente genérico
		// (Consumidor final) que ya existe en la base de datos; no se crea ningún cliente.
		// En cualquier otro caso el id del cliente es obligatorio.
		var usaClienteGenerico = !cliente.getEsClienteRegistrado()
				&& UtilUUID.esValorDefecto(cliente.getId());

		if (!usaClienteGenerico) {
			AsegurarClienteProcesoCompraValidoRule.obtenerInstancia().ejecutar(cliente.getId());
		}

		AsegurarEmpleadoProcesoCompraValidoRule.obtenerInstancia().ejecutar(dominio.getEmpleado().getId());
	}
}
