package co.com.saraitel.gestionsaraitel.entidad;

import java.util.Date;
import java.util.UUID;

public class FacturaEntidad {

	private UUID id;
	private ProcesoCompraEntidad compra;
	private Date fechaemision;

	public FacturaEntidad() {
		super();
	}

	public FacturaEntidad(final UUID id, final ProcesoCompraEntidad compra, final Date fechaemision) {
		super();
		setId(id);
		setCompra(compra);
		setFechaemision(fechaemision);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public ProcesoCompraEntidad getCompra() {
		return compra;
	}

	public void setCompra(final ProcesoCompraEntidad compra) {
		this.compra = compra;
	}

	public Date getFechaemision() {
		return fechaemision;
	}

	public void setFechaemision(final Date fechaemision) {
		this.fechaemision = fechaemision;
	}
}