package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistrado;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoJEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoNEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarClienteRegistradoNoEsteSiendoUtilizadoRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarClienteRegistradoNoEsteSiendoUtilizadoRule();

	private AsegurarClienteRegistradoNoEsteSiendoUtilizadoRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var idClienteRegistrado = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var clienteRegistradoFiltro = new ClienteRegistradoEntidad();
		clienteRegistradoFiltro.setId(idClienteRegistrado);

		var filtroClienteRegistradoN = new ClienteRegistradoNEntidad();
		filtroClienteRegistradoN.setClienteRegistrado(clienteRegistradoFiltro);

		if (!daoFactory.obtenerClienteRegistradoNDao().consultarPorFiltro(filtroClienteRegistradoN).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNegocioImpl.CLIENTE_REGISTRADO_ESTA_SIENDO_UTILIZADO_POR_CLIENTE_NATURAL;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}

		var filtroClienteRegistradoJ = new ClienteRegistradoJEntidad();
		filtroClienteRegistradoJ.setClienteRegistrado(clienteRegistradoFiltro);

		if (!daoFactory.obtenerClienteRegistradoJDao().consultarPorFiltro(filtroClienteRegistradoJ).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNegocioImpl.CLIENTE_REGISTRADO_ESTA_SIENDO_UTILIZADO_POR_CLIENTE_JURIDICO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}

		var clienteRegistradoExistente = daoFactory.obtenerClienteRegistradoDao().consultarPorId(idClienteRegistrado);

		var clienteFiltro = new ClienteEntidad();
		clienteFiltro.setId(clienteRegistradoExistente.getCliente().getId());

		var filtroProcesoCompra = new ProcesoCompraEntidad();
		filtroProcesoCompra.setCliente(clienteFiltro);

		if (!daoFactory.obtenerProcesoCompraDao().consultarPorFiltro(filtroProcesoCompra).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNegocioImpl.CLIENTE_REGISTRADO_ESTA_SIENDO_UTILIZADO_POR_PROCESO_COMPRA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}