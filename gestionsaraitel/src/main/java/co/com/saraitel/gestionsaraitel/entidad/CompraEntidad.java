package co.com.saraitel.gestionsaraitel.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompraEntidad {

	private UUID id;
	private ProcesoCompraEntidad procesocompra;
	private LocalDateTime fechacompra;
	private String estado;

	public CompraEntidad() {
		super();
	}

	public CompraEntidad(final UUID id, final ProcesoCompraEntidad procesocompra, final LocalDateTime fechacompra, final String estado) {
		super();
		setId(id);
		setProcesocompra(procesocompra);
		setFechacompra(fechacompra);
		setEstado(estado);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public ProcesoCompraEntidad getProcesocompra() {
		return procesocompra;
	}

	public void setProcesocompra(final ProcesoCompraEntidad procesocompra) {
		this.procesocompra = procesocompra;
	}

	public LocalDateTime getFechacompra() {
		return fechacompra;
	}

	public void setFechacompra(final LocalDateTime fechacompra) {
		this.fechacompra = fechacompra;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}
}