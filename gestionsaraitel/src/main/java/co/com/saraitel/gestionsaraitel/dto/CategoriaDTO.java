package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class CategoriaDTO {

	private UUID id;
	private String nombre;
	private UUID idCategoriaPadre;
	private int nivel;

	public CategoriaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIA);
		setIdCategoriaPadre(null);
		setNivel(1);
	}

	public CategoriaDTO(final UUID id, final String nombre,
			final UUID idCategoriaPadre, final int nivel) {
		setId(id);
		setNombre(nombre);
		setIdCategoriaPadre(idCategoriaPadre);
		setNivel(nivel);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
	}

	public UUID getIdCategoriaPadre() {
		return idCategoriaPadre;
	}

	public void setIdCategoriaPadre(final UUID idCategoriaPadre) {
		this.idCategoriaPadre = idCategoriaPadre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}
}