package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradoj;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarClienteJuridicoNoEsteSiendoUtilizadoRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarClienteJuridicoNoEsteSiendoUtilizadoRule();

	private AsegurarClienteJuridicoNoEsteSiendoUtilizadoRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var idClienteJuridico = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var clienteJuridicoExistente = daoFactory.obtenerClienteRegistradoJDao().consultarPorId(idClienteJuridico);

		var clienteFiltro = new ClienteEntidad();
		clienteFiltro.setId(clienteJuridicoExistente.getClienteRegistrado().getCliente().getId());

		var filtroProcesoCompra = new ProcesoCompraEntidad();
		filtroProcesoCompra.setCliente(clienteFiltro);

		if (!daoFactory.obtenerProcesoCompraDao().consultarPorFiltro(filtroProcesoCompra).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoJNegocioImpl.CLIENTE_JURIDICO_ESTA_SIENDO_UTILIZADO_POR_PROCESO_COMPRA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
