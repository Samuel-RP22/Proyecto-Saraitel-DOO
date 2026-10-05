package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class TipoDocumentoDominio {

	private UUID id;
	private String tipo;

	private TipoDocumentoDominio(Builder builder) {
		this.id = builder.id;
		this.tipo = builder.tipo;
	}

	public UUID getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}

	public static class Builder {
		private UUID id;
		private String tipo;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			tipo = UtilTexto.VACIA;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String tipo) {
			this.tipo = UtilTexto.quitarEspaciosEnBlanco(tipo);
			return this;
		}

		public TipoDocumentoDominio build() {
			return new TipoDocumentoDominio(this);
		}
	}
}