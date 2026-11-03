package co.com.saraitel.gestionsaraitel.tareaprogramada;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import co.com.saraitel.gestionsaraitel.negocio.fachada.ProcesoCompraFachada;
import co.com.saraitel.gestionsaraitel.negocio.fachada.impl.ProcesoCompraFachadaImpl;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.logger.GestionSaraitelLogger;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

@Component
public class ProcesoCompraTareaProgramada {

	private static final long INTERVALO_REVISION_MILISEGUNDOS = 15_000L;
	private static final GestionSaraitelLogger LOGGER = GestionSaraitelLogger
			.obtener(ProcesoCompraTareaProgramada.class);
	private final ProcesoCompraFachada fachada = new ProcesoCompraFachadaImpl();

	@Scheduled(fixedDelay = INTERVALO_REVISION_MILISEGUNDOS)
	public void anularProcesosCompraVencidos() {
		try {
			LOGGER.info(CatalogoMensajes.ProcesoCompraTareaProgramada.INICIO_EXITOSO_DE_EJECUCION);
			fachada.anularProcesosCompraVencidos();
			LOGGER.info(CatalogoMensajes.ProcesoCompraTareaProgramada.FIN_EXITOSO_DE_EJECUCION);
		} catch (Exception excepcion) {
			LOGGER.registrarExcepcion(UtilUUID.generarComoTexto(), excepcion);
		}
	}
}
