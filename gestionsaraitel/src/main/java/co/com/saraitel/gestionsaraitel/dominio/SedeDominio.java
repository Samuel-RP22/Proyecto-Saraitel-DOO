package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class SedeDominio {

	private final UUID id;
	private final CiudadDominio ciudad;
	private final String nombre;
	private final String nit;
	private final String direccion;
	private final boolean esActiva;

	public SedeDominio(final UUID id, final CiudadDominio ciudad, final String nombre, final String nit,
			final String direccion, final Boolean esActiva) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.ciudad = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(ciudad, CiudadDominio.obtenerValorDefecto());
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
		this.nit = UtilTexto.quitarEspaciosEnBlanco(nit);
		this.direccion = UtilTexto.quitarEspaciosEnBlanco(direccion);
		this.esActiva = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(esActiva, true);
	}

	public static SedeDominio obtenerValorDefecto() {
		return new SedeDominio(UtilUUID.obtenerUUIDDefecto(), CiudadDominio.obtenerValorDefecto(), UtilTexto.VACIA,
				UtilTexto.VACIA, UtilTexto.VACIA, true);
	}

	public UUID getId() {
		return id;
	}

	public CiudadDominio getCiudad() {
		return ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getNit() {
		return nit;
	}

	public String getDireccion() {
		return direccion;
	}

	public boolean getEsActiva() {
		return esActiva;
	}
}
