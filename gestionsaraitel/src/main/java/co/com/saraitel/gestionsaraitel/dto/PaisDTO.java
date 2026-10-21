package co.com.saraitel.gestionsaraitel.dto;

import java.util.UUID;

import org.springframework.web.bind.annotation.BindParam;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class PaisDTO {

	@BindParam("id")
	private UUID id;

	@BindParam("nombre")
	private String nombre;

	public PaisDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIA);
	}

	public PaisDTO(final UUID id, final String nombre) {
		setId(id);
		setNombre(nombre);
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
}