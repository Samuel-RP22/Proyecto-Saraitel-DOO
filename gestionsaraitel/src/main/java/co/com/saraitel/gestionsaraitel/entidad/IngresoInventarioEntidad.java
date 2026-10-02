package co.com.saraitel.gestionsaraitel.entidad;

import java.time.*;
import java.util.UUID;

public class IngresoInventarioEntidad {

	private UUID id;
	private String estado;
	private SedeEntidad sede;
	private LocalDateTime fechallegada;
	private Double total;

	public IngresoInventarioEntidad() {
		super();
	}

	public IngresoInventarioEntidad(final UUID id, final String estado, final SedeEntidad sede, final LocalDateTime fechallegada, final Double total) {
		super();
		setId(id);
		setEstado(estado);
		setSede(sede);
		setFechallegada(fechallegada);
		setTotal(total);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}

	public SedeEntidad getSede() {
		return sede;
	}

	public void setSede(final SedeEntidad sede) {
		this.sede = sede;
	}

	public LocalDateTime getFechallegada() {
		return fechallegada;
	}

	public void setFechallegada(final LocalDateTime fechallegada) {
		this.fechallegada = fechallegada;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(final Double total) {
		this.total = total;
	}
}