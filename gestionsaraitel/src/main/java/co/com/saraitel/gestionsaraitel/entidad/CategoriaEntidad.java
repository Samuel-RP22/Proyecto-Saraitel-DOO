package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class CategoriaEntidad {

	private UUID id;
	private String nombre;
	private CategoriaEntidad categoriapadre;
	private int nivel;

	public CategoriaEntidad() {
		super();
	}

	public CategoriaEntidad(final UUID id, final String nombre, final CategoriaEntidad categoriapadre, final int nivel) {
		super();
		setId(id);
		setNombre(nombre);
		setCategoriapadre(categoriapadre);
		setNivel(nivel);
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

	public CategoriaEntidad getCategoriapadre() {
		return categoriapadre;
	}

	public void setCategoriapadre(final CategoriaEntidad categoriapadre) {
		this.categoriapadre = categoriapadre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}
}