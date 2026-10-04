package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class SedeDTO {

	private UUID id;
	private CiudadDTO ciudad;
	private String nombre;
	private String nit;
	private String direccion;
	private boolean esActiva;

	public SedeDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCiudad(new CiudadDTO());
		setNombre(UtilTexto.VACIA);
		setNit(UtilTexto.VACIA);
		setDireccion(UtilTexto.VACIA);
		setEsActiva(true);
	}

	public SedeDTO(final UUID id, final CiudadDTO ciudad, final String nombre,
			final String nit, final String direccion, final boolean esActiva) {
		setId(id);
		setCiudad(ciudad);
		setNombre(nombre);
		setNit(nit);
		setDireccion(direccion);
		setEsActiva(esActiva);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public void setCiudad(final CiudadDTO ciudad) {
		this.ciudad = UtilObjeto.esNulo(ciudad) ?
				new CiudadDTO() : ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
	}

	public String getNit() {
		return nit;
	}

	public void setNit(final String nit) {
		this.nit = UtilTexto.quitarEspaciosEnBlanco(nit);
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(final String direccion) {
		this.direccion = UtilTexto.quitarEspaciosEnBlanco(direccion);
	}

	public boolean getEsActiva() {
		return esActiva;
	}

	public void setEsActiva(final boolean esActiva) {
		this.esActiva = esActiva;
	}
}