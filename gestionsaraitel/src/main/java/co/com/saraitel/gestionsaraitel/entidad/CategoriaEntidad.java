package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;
//holaas
public class CategoriaEntidad {

	private UUID id;
	private String nombre;
	private String categoriapadre;
	private int nivel;

	public CategoriaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
	    setNombre(UtilTexto.VACIA);
	    setCategoriapadre(UtilTexto.VACIA);
	    setNivel(UtilNumero.CERO);
	}

	public CategoriaEntidad(final UUID id, final String nombre, final String categoriapadre, final int nivel) {
		setId(id);
		setNombre(nombre);
		setCategoriapadre(categoriapadre);
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

	public String getCategoriapadre() {
		return categoriapadre;
	}

	public void setCategoriapadre(final String categoriapadre) {
		this.categoriapadre = UtilTexto.quitarEspaciosEnBlanco(categoriapadre);
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(final int nivel) {
		this.nivel = UtilNumero.obtenerValorDefecto(nivel).intValue();
	}
}