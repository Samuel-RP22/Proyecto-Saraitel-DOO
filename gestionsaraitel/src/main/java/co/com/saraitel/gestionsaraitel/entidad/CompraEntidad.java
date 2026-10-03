package co.com.saraitel.gestionsaraitel.entidad;

import java.util.LocalDateTime;
import java.util.UUID;

public class CompraEntidad {

	private UUID id;
	private ProcesoCompraEntidad procesocompra;
	private Date fechacompra;
	private String estado;

	public CompraEntidad() {
		super();
	}

	public CompraEntidad(final UUID id, final ProcesoCompraEntidad procesocompra, final Date fechacompra, final String estado) {
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

	public Date getFechacompra() {
		return fechacompra;
	}

	public void setFechacompra(final Date fechacompra) {
		this.fechacompra = fechacompra;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}
}