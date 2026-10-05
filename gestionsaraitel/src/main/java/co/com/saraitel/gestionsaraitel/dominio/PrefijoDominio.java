package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PrefijoDominio {

	private UUID id;
	private String codigo;

	private PrefijoDominio(Builder builder) {
		this.id = builder.id;
		this.codigo = builder.codigo;
	}

	public UUID getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public static class Builder {
		private UUID id;
		private String codigo;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			codigo = UtilTexto.VACIA;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder codigo(String codigo) {
			this.codigo = UtilTexto.quitarEspaciosEnBlanco(codigo);
			
			return this;
		}

		public PrefijoDominio build() {
			return new PrefijoDominio(this);
		}
	}
}