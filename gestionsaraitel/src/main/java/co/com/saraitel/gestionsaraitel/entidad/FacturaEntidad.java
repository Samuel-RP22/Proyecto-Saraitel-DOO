package co.com.saraitel.gestionsaraitel.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class FacturaEntidad {

	private UUID id;
	private CompraEntidad compra;
	private LocalDateTime fechaEmision;

	public FacturaEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCompra(new CompraEntidad());
		setFechaEmision(UtilFecha.FECHA_HORA_DEFECTO);
	}

	public FacturaEntidad(final UUID id, final CompraEntidad compra,
			final LocalDateTime fechaEmision) {
		setId(id);
		setCompra(compra);
		setFechaEmision(fechaEmision);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public CompraEntidad getCompra() {
		return compra;
	}

	public void setCompra(final CompraEntidad compra) {
		this.compra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(compra, new CompraEntidad());
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(final LocalDateTime fechaEmision) {
		this.fechaEmision = UtilFecha.obtenerValorDefecto(fechaEmision);
	}
}