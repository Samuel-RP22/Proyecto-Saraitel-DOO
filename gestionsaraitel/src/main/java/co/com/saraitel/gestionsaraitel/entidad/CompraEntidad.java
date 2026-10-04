package co.com.saraitel.gestionsaraitel.entidad;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class CompraEntidad {

	private UUID id;
	private ProcesoCompraEntidad procesoCompra;
	private LocalDateTime fechaCompra;
	private String estado;

	public CompraEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setProcesoCompra(new ProcesoCompraEntidad());
		setFechaCompra(UtilFecha.FECHA_HORA_DEFECTO);
		setEstado(UtilTexto.VACIA);
	}

	public CompraEntidad(final UUID id, final ProcesoCompraEntidad procesoCompra,
			final LocalDateTime fechaCompra, final String estado) {
		setId(id);
		setProcesoCompra(procesoCompra);
		setFechaCompra(fechaCompra);
		setEstado(estado);
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
		this.procesoCompra = UtilObjeto.esNulo(procesoCompra) ?
				new ProcesoCompraEntidad() : procesoCompra;
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(final LocalDateTime fechaCompra) {
		this.fechaCompra = UtilFecha.obtenerValorDefecto(fechaCompra);
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
	}
}