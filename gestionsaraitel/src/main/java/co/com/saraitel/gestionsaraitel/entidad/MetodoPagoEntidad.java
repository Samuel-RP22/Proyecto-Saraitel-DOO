package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class MetodoPagoEntidad {

	private UUID id;
	private String nombre;
	private Boolean esactivo;

	public MetodoPagoEntidad() {
		super();
	}

	public MetodoPagoEntidad(final UUID id, final String nombre, final boolean esactivo) {
		super();
		setId(id);
		setNombre(nombre);
		setEsActivo(esactivo);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public boolean isEsActivo() {
		return esactivo;
	}

	public void setEsActivo(final Boolean esactivo) {
		this.esactivo = esactivo;
	}
}