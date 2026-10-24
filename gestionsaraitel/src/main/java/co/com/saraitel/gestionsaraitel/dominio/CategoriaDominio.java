package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class CategoriaDominio {

	private final UUID id;
	private final String nombre;
	private final UUID categoriaPadre;
	private final int nivel;

	public CategoriaDominio(final UUID id, final String nombre, final UUID categoriaPadre, final int nivel) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
		this.categoriaPadre = categoriaPadre;
		this.nivel = nivel;
	}

	public static CategoriaDominio obtenerValorDefecto() {
		return new CategoriaDominio(UtilUUID.obtenerUUIDDefecto(), UtilTexto.VACIA, UtilUUID.obtenerUUIDDefecto(), 0);
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public UUID getIdCategoriaPadre() {
		return categoriaPadre;
	}

	public int getNivel() {
		return nivel;
	}
}