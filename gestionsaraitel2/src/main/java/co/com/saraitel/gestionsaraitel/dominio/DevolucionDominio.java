package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DevolucionDominio {

	private final UUID id;
	private final DetalleCompraDominio detalleCompra;
	private final MotivoDominio motivo;
	private final LocalDateTime fechaDevolucion;
	private final int cantidad;
	private final BigDecimal montoDevolucion;
	private final String estado;

	public DevolucionDominio(final UUID id, final DetalleCompraDominio detalleCompra, final MotivoDominio motivo,
			final LocalDateTime fechaDevolucion, final Integer cantidad, final BigDecimal montoDevolucion,
			final String estado) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.detalleCompra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(detalleCompra,
				DetalleCompraDominio.obtenerValorDefecto());
		this.motivo = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(motivo, MotivoDominio.obtenerValorDefecto());
		this.fechaDevolucion = UtilFecha.obtenerValorDefecto(fechaDevolucion);
		this.cantidad = UtilNumero.obtenerValorDefecto(cantidad, 1);
		this.montoDevolucion = UtilNumero.obtenerValorDefecto(montoDevolucion);
		this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
	}

	public static DevolucionDominio obtenerValorDefecto() {
		return new DevolucionDominio(UtilUUID.obtenerUUIDDefecto(), DetalleCompraDominio.obtenerValorDefecto(),
				MotivoDominio.obtenerValorDefecto(), UtilFecha.FECHA_HORA_DEFECTO, 1, UtilNumero.CERO_DECIMAL,
				UtilTexto.VACIA);
	}

	public UUID getId() {
		return id;
	}

	public DetalleCompraDominio getDetalleCompra() {
		return detalleCompra;
	}

	public MotivoDominio getMotivo() {
		return motivo;
	}

	public LocalDateTime getFechaDevolucion() {
		return fechaDevolucion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public BigDecimal getMontoDevolucion() {
		return montoDevolucion;
	}

	public String getEstado() {
		return estado;
	}
}