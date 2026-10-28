package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilBoolean;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class MarcaDominio {

	private final UUID id;
	private final String nombre;
	private final boolean esActivo;

	public MarcaDominio(final UUID id, final String nombre, final Boolean esActivo) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
		this.esActivo = UtilBoolean.obtenerValorDefectoVerdadero(esActivo);
	}

	public static MarcaDominio obtenerValorDefecto() {
		return new MarcaDominio(UtilUUID.obtenerUUIDDefecto(), UtilTexto.VACIA, true);
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
