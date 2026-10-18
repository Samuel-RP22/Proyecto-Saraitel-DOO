package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class EstadoCompraEntidad {

	private UUID id;
	private String codigo;
	private String nombre;

	public EstadoCompraEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCodigo(UtilTexto.VACIA);
		setNombre(UtilTexto.VACIA);
	}

	public EstadoCompraEntidad(final UUID id, final String codigo, final String nombre) {
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(final String codigo) {
		this.codigo = UtilTexto.quitarEspaciosEnBlanco(codigo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = UtilTexto.quitarEspaciosEnBlanco(nombre);
	}
}