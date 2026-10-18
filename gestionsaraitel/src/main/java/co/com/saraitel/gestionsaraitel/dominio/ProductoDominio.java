package co.com.saraitel.gestionsaraitel.dominio;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class ProductoDominio {

	private final UUID id;
	private final MarcaDominio marca;
	private final CategoriaDominio categoria;
	private final String modelo;
	private final String nombre;
	private final String descripcion;

	public ProductoDominio(final UUID id, final MarcaDominio marca, final CategoriaDominio categoria,
			final String modelo, final String nombre, final String descripcion) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.marca = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(marca, MarcaDominio.obtenerValorDefecto());
		this.categoria = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(categoria,
				CategoriaDominio.obtenerValorDefecto());
		this.modelo = UtilTexto.quitarEspaciosEnBlanco(modelo);
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
		this.descripcion = UtilTexto.quitarEspaciosEnBlanco(descripcion);
	}

	public static ProductoDominio obtenerValorDefecto() {
		return new ProductoDominio(UtilUUID.obtenerUUIDDefecto(), MarcaDominio.obtenerValorDefecto(),
				CategoriaDominio.obtenerValorDefecto(), UtilTexto.VACIA, UtilTexto.VACIA, UtilTexto.VACIA);
	}

	public UUID getId() {
		return id;
	}

	public MarcaDominio getMarca() {
		return marca;
	}

	public CategoriaDominio getCategoria() {
		return categoria;
	}

	public String getModelo() {
		return modelo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
