package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProductoEntidad {

	private UUID id;
	private MarcaEntidad marca;
	private CategoriaEntidad categoria;
	private String modelo;
	private String nombre;
	private String descripcion;

	public ProductoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setMarca(new MarcaEntidad());
		setCategoria(new CategoriaEntidad());
		setModelo(UtilTexto.VACIA);
		setNombre(UtilTexto.VACIA);
		setDescripcion(UtilTexto.VACIA);
	}

	public ProductoEntidad(final UUID id, final MarcaEntidad marca, 
			final CategoriaEntidad categoria, final String modelo, 
			final String nombre, final String descripcion) {
		setId(id);
		setMarca(marca);
		setCategoria(categoria);
		setModelo(modelo);
		setNombre(nombre);
		setDescripcion(descripcion);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public MarcaEntidad getMarca() {
		return marca;
	}

	public void setMarca(final MarcaEntidad marca) {
		this.marca = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(marca, new MarcaEntidad());
	}

	public CategoriaEntidad getCategoria() {
		return categoria;
	}

	public void setCategoria(final CategoriaEntidad categoria) {
		this.categoria = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(categoria, new CategoriaEntidad());
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(final String modelo) {
		this.modelo = UtilTexto.quitarEspaciosEnBlanco(modelo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = UtilTexto.quitarEspaciosEnBlanco(descripcion);
	}
}