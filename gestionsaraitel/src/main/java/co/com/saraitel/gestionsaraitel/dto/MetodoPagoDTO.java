package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class MetodoPagoDTO {

	private UUID id;
	private String nombre;
	private boolean esActivo;

	public MetodoPagoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIA);
		setEsActivo(true);
	}

	public MetodoPagoDTO(final UUID id, final String nombre, final boolean esActivo) {
		setId(id);
		setNombre(nombre);
		setEsActivo(esActivo);
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

	public boolean getEsActivo() {
		return esActivo;
	}

	public void setEsActivo(final boolean esActivo) {
		this.esActivo = esActivo;
	}
}