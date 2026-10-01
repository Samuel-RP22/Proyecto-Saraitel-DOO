package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class MotivoEntidad {

	private UUID id;
	private String nombre;

	public MotivoEntidad() {
		super();
	}

	public MotivoEntidad(final UUID id, final String nombre) {
		super();
		setId(id);
		setNombre(nombre);
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
}