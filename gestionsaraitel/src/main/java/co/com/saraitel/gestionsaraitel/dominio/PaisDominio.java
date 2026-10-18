package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PaisDominio {

	private final UUID id;
	private final String nombre;

	public PaisDominio(final UUID id, final String nombre) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
	}

	public static PaisDominio obtenerValorDefecto() {
		return new PaisDominio(UtilUUID.obtenerUUIDDefecto(), UtilTexto.VACIA);
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
}
