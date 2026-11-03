package co.com.saraitel.gestionsaraitel.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class CompraEntidad {

	private UUID id;
	private ProcesoCompraEntidad procesoCompra;
	private EstadoCompraEntidad estado;
	private LocalDateTime fechaCompra;

	public CompraEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setProcesoCompra(new ProcesoCompraEntidad());
		setEstado(new EstadoCompraEntidad());
		setFechaCompra(UtilFecha.FECHA_HORA_DEFECTO);

	}

	public CompraEntidad(final UUID id, final ProcesoCompraEntidad procesoCompra, final EstadoCompraEntidad estado,
			final LocalDateTime fechaCompra) {
		setId(id);
		setProcesoCompra(procesoCompra);
		setEstado(estado);
		setFechaCompra(fechaCompra);

	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ProcesoCompraEntidad getProcesoCompra() {
		return procesoCompra;
	}

	public void setProcesoCompra(final ProcesoCompraEntidad procesoCompra) {
		this.procesoCompra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(procesoCompra,
				new ProcesoCompraEntidad());
	}

	public EstadoCompraEntidad getEstado() {
		return estado;
	}

	public void setEstado(final EstadoCompraEntidad estado) {
		this.estado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estado, new EstadoCompraEntidad());
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(final LocalDateTime fechaCompra) {
		this.fechaCompra = UtilFecha.obtenerValorDefecto(fechaCompra);
	}

}