package co.com.saraitel.gestionsaraitel.dominio;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;

public class CompraDominio {

	private UUID id;
	private ProcesoCompraDominio procesoCompra;
	private LocalDateTime fechaCompra;
	private String estado;

	private CompraDominio(Builder builder) {
		this.id = builder.id;
		this.procesoCompra = builder.procesoCompra;
		this.fechaCompra = builder.fechaCompra;
		this.estado = builder.estado;
	}

	public UUID getId() {
		return id;
	}

	public ProcesoCompraDominio getProcesoCompra() {
		return procesoCompra;
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

	public String getEstado() {
		return estado;
	}

	public static class Builder {

		private UUID id;
		private ProcesoCompraDominio procesoCompra;
		private LocalDateTime fechaCompra;
		private String estado;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			procesoCompra = new ProcesoCompraDominio.Builder().build();
			fechaCompra = UtilFecha.FECHA_HORA_DEFECTO;
			estado = UtilTexto.VACIA;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder procesoCompra(ProcesoCompraDominio procesoCompra) {
			this.procesoCompra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(procesoCompra, new ProcesoCompraDominio.Builder().build());
			return this;
		}

		public Builder fechaCompra(LocalDateTime fechaCompra) {
			this.fechaCompra = UtilFecha.obtenerValorDefecto(fechaCompra);
			return this;
		}

		public Builder estado(String estado) {
			this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
			return this;
		}

		public CompraDominio build() {
			return new CompraDominio(this);
		}
	}
}