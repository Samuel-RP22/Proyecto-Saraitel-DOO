package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.estadoprocesocompra;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.EstadoProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarCodigoNuevoEstadoProcesoCompraNoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarCodigoNuevoEstadoProcesoCompraNoExistaRule();

	private AsegurarCodigoNuevoEstadoProcesoCompraNoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var codigoEstadoProcesoCompra = (String) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var entidadFiltro = new EstadoProcesoCompraEntidad();
		entidadFiltro.setCodigo(codigoEstadoProcesoCompra);

		var resultados = daoFactory.obtenerEstadoProcesoCompraDao().consultarPorFiltro(entidadFiltro);

		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.EstadoProcesoCompraNegocioImpl.ESTADO_PROCESO_COMPRA_YA_EXISTE_CON_EL_MISMO_CODIGO_DE_ESTADO_A_CREAR;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
