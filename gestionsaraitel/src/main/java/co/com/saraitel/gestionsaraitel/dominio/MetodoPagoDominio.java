package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class MetodoPagoDominio {

	private final UUID id;
	private final String nombre;
	private final boolean esActivo;

	public MetodoPagoDominio(final UUID id, final String nombre, final boolean esActivo) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
		this.esActivo = esActivo;
	}

	public static MetodoPagoDominio obtenerValorDefecto() {
		return new MetodoPagoDominio(UtilUUID.obtenerUUIDDefecto(), UtilTexto.VACIA, true);
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean getEsActivo() {
		return esActivo;
	}
}
