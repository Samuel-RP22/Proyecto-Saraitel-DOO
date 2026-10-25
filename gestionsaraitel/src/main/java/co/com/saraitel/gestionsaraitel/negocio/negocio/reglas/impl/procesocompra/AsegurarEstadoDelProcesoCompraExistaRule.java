package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class AsegurarEstadoDelProcesoCompraExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarEstadoDelProcesoCompraExistaRule();

	private AsegurarEstadoDelProcesoCompraExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var idEstado = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var estadoExistente = daoFactory.obtenerEstadoProcesoCompraDao().consultarPorId(idEstado);

		if (estadoExistente.getId().equals(UtilUUID.obtenerUUIDDefecto())) {
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraNegocioImpl.ESTADO_PROCESO_COMPRA_NO_EXISTE;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
