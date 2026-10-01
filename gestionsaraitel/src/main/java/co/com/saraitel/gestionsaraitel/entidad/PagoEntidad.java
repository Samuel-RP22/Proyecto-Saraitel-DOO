package co.com.saraitel.gestionsaraitel.entidad;

import java.util.Date;
import java.util.UUID;

public class PagoEntidad {

	private UUID id;
	private ProcesoCompraEntidad compra;
	private Double montopendiente;
	private Date fechapago;

	public PagoEntidad() {
		super();
	}

	public PagoEntidad(final UUID id, final ProcesoCompraEntidad compra, final Double montopendiente, final Date fechapago) {
		super();
		setId(id);
		setCompra(compra);
		setMontopendiente(montopendiente);
		setFechapago(fechapago);
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

	public Double getMontopendiente() {
		return montopendiente;
	}

	public void setMontopendiente(final Double montopendiente) {
		this.montopendiente = montopendiente;
	}

	public Date getFechapago() {
		return fechapago;
	}

	public void setFechapago(final Date fechapago) {
		this.fechapago = fechapago;
	}
}