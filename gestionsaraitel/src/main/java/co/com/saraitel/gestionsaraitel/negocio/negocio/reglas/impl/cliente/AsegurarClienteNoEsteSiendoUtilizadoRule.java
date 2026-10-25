package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.cliente;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteNoRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ClienteRegistradoEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarClienteNoEsteSiendoUtilizadoRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarClienteNoEsteSiendoUtilizadoRule();

	private AsegurarClienteNoEsteSiendoUtilizadoRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var idCliente = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var clienteFiltro = new ClienteEntidad();
		clienteFiltro.setId(idCliente);

		var filtroClienteRegistrado = new ClienteRegistradoEntidad();
		filtroClienteRegistrado.setCliente(clienteFiltro);

		if (!daoFactory.obtenerClienteRegistradoDao().consultarPorFiltro(filtroClienteRegistrado).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.CLIENTE_ESTA_SIENDO_UTILIZADO_POR_CLIENTE_REGISTRADO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}

		var filtroClienteNoRegistrado = new ClienteNoRegistradoEntidad();
		filtroClienteNoRegistrado.setCliente(clienteFiltro);

		if (!daoFactory.obtenerClienteNoRegistradoDao().consultarPorFiltro(filtroClienteNoRegistrado).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.CLIENTE_ESTA_SIENDO_UTILIZADO_POR_CLIENTE_NO_REGISTRADO;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}

		var filtroProcesoCompra = new ProcesoCompraEntidad();
		filtroProcesoCompra.setCliente(clienteFiltro);

		if (!daoFactory.obtenerProcesoCompraDao().consultarPorFiltro(filtroProcesoCompra).isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.CLIENTE_ESTA_SIENDO_UTILIZADO_POR_PROCESO_COMPRA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
