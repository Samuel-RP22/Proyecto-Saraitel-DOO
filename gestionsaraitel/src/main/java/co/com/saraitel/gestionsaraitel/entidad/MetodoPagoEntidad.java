package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class MetodoPagoEntidad {

	private UUID id;
	private String nombre;
	private boolean esactivo;

	public MetodoPagoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIA);
		setEsActivo(false);

	}

	public MetodoPagoEntidad(final UUID id, final String nombre, final boolean esactivo) {
		setId(id);
		setNombre(nombre);
		setEsActivo(esactivo);
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
		return esactivo;
	}

	public void setEsActivo(final boolean esactivo) {
		this.esactivo = esactivo;
	}
}