package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarProcesoCompraExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarProcesoCompraExistaRule();

	private AsegurarProcesoCompraExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 2);

		var idProcesoCompra = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var procesoCompraExistente = daoFactory.obtenerProcesoCompraDao().consultarPorId(idProcesoCompra);

		if (UtilUUID.esValorDefecto(procesoCompraExistente.getId())) {
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraNegocioImpl.PROCESO_COMPRA_NO_EXISTE;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
