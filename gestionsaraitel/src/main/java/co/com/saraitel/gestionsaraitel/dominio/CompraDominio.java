package co.com.saraitel.gestionsaraitel.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class CompraDominio {

	private final UUID id;
	private final ProcesoCompraDominio procesoCompra;
	private final EstadoCompraDominio estado;
	private final LocalDateTime fechaCompra;

	public CompraDominio(final UUID id, final ProcesoCompraDominio procesoCompra, final EstadoCompraDominio estado,
			final LocalDateTime fechaCompra) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.procesoCompra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(procesoCompra,
				ProcesoCompraDominio.obtenerValorDefecto());
		this.estado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estado,
				EstadoCompraDominio.obtenerValorDefecto());
		this.fechaCompra = UtilFecha.obtenerValorDefecto(fechaCompra);
	}

	public static CompraDominio obtenerValorDefecto() {
		return new CompraDominio(UtilUUID.obtenerUUIDDefecto(), ProcesoCompraDominio.obtenerValorDefecto(),
				EstadoCompraDominio.obtenerValorDefecto(), UtilFecha.FECHA_HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public ProcesoCompraDominio getProcesoCompra() {
		return procesoCompra;
	}

	public EstadoCompraDominio getEstado() {
		return estado;
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}
}