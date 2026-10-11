package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PagoDominio {

	private UUID id;
	private CompraDominio compra;
	private BigDecimal montoPagado;
	private LocalDateTime fechaPago;

	private PagoDominio(Builder builder) {
		this.id = builder.id;
		this.compra = builder.compra;
		this.montoPagado = builder.montoPagado;
		this.fechaPago = builder.fechaPago;
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

	public static class Builder {

		private UUID id;
		private CompraDominio compra;
		private BigDecimal montoPagado;
		private LocalDateTime fechaPago;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			compra = new CompraDominio.Builder().build();
			montoPagado = UtilNumero.CERO_DECIMAL;
			fechaPago = UtilFecha.FECHA_HORA_DEFECTO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder compra(CompraDominio compra) {
			this.compra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
					compra, new CompraDominio.Builder().build());
			return this;
		}

		public Builder fechaPago(LocalDateTime fechaPago) {
			this.fechaPago = UtilFecha.obtenerValorDefecto(fechaPago);
			return this;
		}

		public PagoDominio build() {
			return new PagoDominio(this);
		}
	}
}