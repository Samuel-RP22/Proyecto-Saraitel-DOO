package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProductoDTO {

	private UUID id;
	private MarcaDTO marca;
	private CategoriaDTO categoria;
	private String modelo;
	private String nombre;
	private String descripcion;

	public ProductoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setMarca(new MarcaDTO());
		setCategoria(new CategoriaDTO());
		setModelo(UtilTexto.VACIA);
		setNombre(UtilTexto.VACIA);
		setDescripcion(UtilTexto.VACIA);
	}

	public ProductoDTO(final UUID id, final MarcaDTO marca, 
			final CategoriaDTO categoria, final String modelo, 
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

	public MarcaDTO getMarca() {
		return marca;
	}

	public void setMarca(final MarcaDTO marca) {
		this.marca = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(marca, new MarcaDTO());
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(final CategoriaDTO categoria) {
		this.categoria = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(categoria, new CategoriaDTO());
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