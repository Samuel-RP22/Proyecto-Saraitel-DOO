package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class CiudadDominio {

	private final UUID id;
	private final String nombre;
	private final DepartamentoDominio departamento;

	public CiudadDominio(final UUID id, final String nombre, final DepartamentoDominio departamento) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
		this.departamento = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(departamento,
				DepartamentoDominio.obtenerValorDefecto());
	}

	public static CiudadDominio obtenerValorDefecto() {
		return new CiudadDominio(UtilUUID.obtenerUUIDDefecto(), UtilTexto.VACIA,
				DepartamentoDominio.obtenerValorDefecto());
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public DepartamentoDominio getDepartamento() {
		return departamento;
	}
}