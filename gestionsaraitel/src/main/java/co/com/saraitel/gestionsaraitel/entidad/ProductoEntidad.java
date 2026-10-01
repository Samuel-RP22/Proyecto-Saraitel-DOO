package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class ProductoEntidad {

	private UUID id;
	private MarcaEntidad marca;
	private CategoriaEntidad categoria;
	private String modelo;
	private String nombre;
	private String descripcion;

	public ProductoEntidad() {
		super();
	}

	public ProductoEntidad(final UUID id, final MarcaEntidad marca, final CategoriaEntidad categoria,
			final String modelo, final String nombre, final String descripcion) {
		super();
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
		this.id = id;
	}

	public MarcaEntidad getMarca() {
		return marca;
	}

	public void setMarca(final MarcaEntidad marca) {
		this.marca = marca;
	}

	public CategoriaEntidad getCategoria() {
		return categoria;
	}

	public void setCategoria(final CategoriaEntidad categoria) {
		this.categoria = categoria;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(final String modelo) {
		this.modelo = modelo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
}