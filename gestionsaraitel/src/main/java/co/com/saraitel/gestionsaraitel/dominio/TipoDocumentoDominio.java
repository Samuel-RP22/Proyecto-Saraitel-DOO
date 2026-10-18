package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class TipoDocumentoDominio {

	private final UUID id;
	private final String tipo;

	public TipoDocumentoDominio(final UUID id, final String tipo) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.tipo = UtilTexto.quitarEspaciosEnBlanco(tipo);
	}

	public static TipoDocumentoDominio obtenerValorDefecto() {
		return new TipoDocumentoDominio(UtilUUID.obtenerUUIDDefecto(), UtilTexto.VACIA);
	}

	public UUID getId() {
		return id;
	}

	public String getTipo() {
		return tipo;
	}
}
