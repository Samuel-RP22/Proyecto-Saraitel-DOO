package co.com.saraitel.gestionsaraitel.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class FacturaDominio {

	private final UUID id;
	private final CompraDominio compra;
	private final LocalDateTime fechaEmision;

	public FacturaDominio(final UUID id, final CompraDominio compra, final LocalDateTime fechaEmision) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.compra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(compra, CompraDominio.obtenerValorDefecto());
		this.fechaEmision = UtilFecha.obtenerValorDefecto(fechaEmision);
	}

	public static FacturaDominio obtenerValorDefecto() {
		return new FacturaDominio(UtilUUID.obtenerUUIDDefecto(), CompraDominio.obtenerValorDefecto(),
				UtilFecha.FECHA_HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public CompraDominio getCompra() {
		return compra;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}
}