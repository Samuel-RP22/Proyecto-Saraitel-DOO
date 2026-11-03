package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DepartamentoDominio {

	private final UUID id;
	private final String nombre;
	private final PaisDominio pais;

	public DepartamentoDominio(final UUID id, final String nombre, final PaisDominio pais) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
		this.pais = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pais, PaisDominio.obtenerValorDefecto());
	}

	public static DepartamentoDominio obtenerValorDefecto() {
		return new DepartamentoDominio(UtilUUID.obtenerUUIDDefecto(), UtilTexto.VACIA,
				PaisDominio.obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public PaisDominio getPais() {
		return pais;
	}
}