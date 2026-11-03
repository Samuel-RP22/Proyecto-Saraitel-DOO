package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PagoDominio {

	private final UUID id;
	private final CompraDominio compra;
	private final BigDecimal montoPagado;
	private final LocalDateTime fechaPago;

	public PagoDominio(final UUID id, final CompraDominio compra, final BigDecimal montoPagado,
			final LocalDateTime fechaPago) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.compra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(compra, CompraDominio.obtenerValorDefecto());
		this.montoPagado = UtilNumero.obtenerValorDefecto(montoPagado);
		this.fechaPago = UtilFecha.obtenerValorDefecto(fechaPago);
	}

	public static PagoDominio obtenerValorDefecto() {
		return new PagoDominio(UtilUUID.obtenerUUIDDefecto(), CompraDominio.obtenerValorDefecto(),
				UtilNumero.CERO_DECIMAL, UtilFecha.FECHA_HORA_DEFECTO);
	}

	public UUID getId() {
		return id;
	}

	public CompraDominio getCompra() {
		return compra;
	}

	public BigDecimal getMontoPagado() {
		return montoPagado;
	}

	public LocalDateTime getFechaPago() {
		return fechaPago;
	}
}
