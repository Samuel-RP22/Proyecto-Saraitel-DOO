package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.procesocompra;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.ClienteEntidad;
import co.com.saraitel.gestionsaraitel.entidad.ProcesoCompraEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarClienteNoTengaProcesoCompraConMismaFechaActualizacionRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarClienteNoTengaProcesoCompraConMismaFechaActualizacionRule();

	private AsegurarClienteNoTengaProcesoCompraConMismaFechaActualizacionRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		var idCliente = (UUID) datos[0];
		var fecha = (LocalDateTime) datos[1];
		var daoFactory = (DAOFactory) datos[2];

		var clienteFiltro = new ClienteEntidad();
		clienteFiltro.setId(idCliente);

		var entidadFiltro = new ProcesoCompraEntidad();
		entidadFiltro.setCliente(clienteFiltro);
		entidadFiltro.setFechaActualizacion(fecha);

		var resultados = daoFactory.obtenerProcesoCompraDao().consultarPorFiltro(entidadFiltro);

		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ProcesoCompraNegocioImpl.CLIENTE_YA_TIENE_PROCESO_COMPRA_CON_LA_MISMA_FECHA_ACTUALIZACION;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
