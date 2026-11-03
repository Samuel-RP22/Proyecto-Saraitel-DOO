package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class EstadoCompraDominio {

	private final UUID id;
	private final String codigo;
	private final String nombre;

	public EstadoCompraDominio(final UUID id, final String codigo, final String nombre) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.codigo = UtilTexto.quitarEspaciosEnBlanco(codigo);
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
	}

	public static EstadoCompraDominio obtenerValorDefecto() {
		return new EstadoCompraDominio(UtilUUID.obtenerUUIDDefecto(), UtilTexto.VACIA, UtilTexto.VACIA);
	}

	public UUID getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}
}