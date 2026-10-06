package co.com.saraitel.gestionsaraitel.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class FacturaDominio {

	private UUID id;
	private CompraDominio compra;
	private LocalDateTime fechaEmision;

	private FacturaDominio(Builder builder) {
		this.id = builder.id;
		this.compra = builder.compra;
		this.fechaEmision = builder.fechaEmision;
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

	public static class Builder {

		private UUID id;
		private CompraDominio compra;
		private LocalDateTime fechaEmision;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			compra = new CompraDominio.Builder().build();
			fechaEmision = UtilFecha.FECHA_HORA_DEFECTO;
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

		public Builder fechaEmision(LocalDateTime fechaEmision) {
			this.fechaEmision = UtilFecha.obtenerValorDefecto(fechaEmision);
			return this;
		}

		public FacturaDominio build() {
			return new FacturaDominio(this);
		}
	}
}