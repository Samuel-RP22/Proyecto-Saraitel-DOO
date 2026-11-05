package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.clienteregistradon;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteNoRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoJEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarClienteNaturalNoEsteSiendoUtilizadoRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarClienteNaturalNoEsteSiendoUtilizadoRule();

	private AsegurarClienteNaturalNoEsteSiendoUtilizadoRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var idClienteNatural = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var clienteNaturalExistente = daoFactory.obtenerClienteRegistradoNDao().consultarPorId(idClienteNatural);

		var clienteRegistradoFiltro = new ClienteRegistradoEntidad();
		clienteRegistradoFiltro.setId(clienteNaturalExistente.getClienteRegistrado().getId());

		var clienteFiltro = new ClienteEntidad();
		clienteFiltro.setId(clienteNaturalExistente.getClienteRegistrado().getCliente().getId());

		var filtroClienteRegistradoJ = new ClienteRegistradoJEntidad();
		filtroClienteRegistradoJ.setClienteRegistrado(clienteRegistradoFiltro);

		if (!daoFactory.obtenerClienteRegistradoJDao().consultarPorFiltro(filtroClienteRegistradoJ).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNNegocioImpl.CLIENTE_NATURAL_ESTA_SIENDO_UTILIZADO_POR_CLIENTE_JURIDICO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}

		var filtroClienteNoRegistrado = new ClienteNoRegistradoEntidad();
		filtroClienteNoRegistrado.setCliente(clienteFiltro);

		if (!daoFactory.obtenerClienteNoRegistradoDao().consultarPorFiltro(filtroClienteNoRegistrado).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNNegocioImpl.CLIENTE_NATURAL_ESTA_SIENDO_UTILIZADO_POR_CLIENTE_NO_REGISTRADO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}

		var filtroProcesoCompra = new ProcesoCompraEntidad();
		filtroProcesoCompra.setCliente(clienteFiltro);

		if (!daoFactory.obtenerProcesoCompraDao().consultarPorFiltro(filtroProcesoCompra).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteRegistradoNNegocioImpl.CLIENTE_NATURAL_ESTA_SIENDO_UTILIZADO_POR_PROCESO_COMPRA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
