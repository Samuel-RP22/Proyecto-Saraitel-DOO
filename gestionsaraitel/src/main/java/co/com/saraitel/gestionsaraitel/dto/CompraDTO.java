package co.com.saraitel.gestionsaraitel.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class CompraDTO {

	private UUID id;
	private ProcesoCompraDTO procesoCompra;
	private EstadoCompraDTO estado;
	private LocalDateTime fechaCompra;

	public CompraDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setProcesoCompra(new ProcesoCompraDTO());
		setEstado(new EstadoCompraDTO());
		setFechaCompra(UtilFecha.FECHA_HORA_DEFECTO);

	}

	public CompraDTO(final UUID id, final ProcesoCompraDTO procesoCompra, final EstadoCompraDTO estado,
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

	public ProcesoCompraDTO getProcesoCompra() {
		return procesoCompra;
	}

	public void setProcesoCompra(final ProcesoCompraDTO procesoCompra) {
		this.procesoCompra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(procesoCompra, new ProcesoCompraDTO());
	}

	public EstadoCompraDTO getEstado() {
		return estado;
	}

	public void setEstado(final EstadoCompraDTO estado) {
		this.estado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estado, new EstadoCompraDTO());
	}

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(final LocalDateTime fechaCompra) {
		this.fechaCompra = UtilFecha.obtenerValorDefecto(fechaCompra);
	}

}