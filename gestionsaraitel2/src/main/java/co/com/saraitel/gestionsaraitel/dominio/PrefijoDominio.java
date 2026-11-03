package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PrefijoDominio {

	private final UUID id;
	private final String codigo;

	public PrefijoDominio(final UUID id, final String codigo) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.codigo = UtilTexto.quitarEspaciosEnBlanco(codigo);
	}

	public static PrefijoDominio obtenerValorDefecto() {
		return new PrefijoDominio(UtilUUID.obtenerUUIDDefecto(), UtilTexto.VACIA);
	}

	public UUID getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}
}
