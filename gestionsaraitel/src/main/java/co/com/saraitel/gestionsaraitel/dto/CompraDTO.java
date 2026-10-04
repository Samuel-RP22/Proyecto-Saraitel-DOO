package co.com.saraitel.gestionsaraitel.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class CompraDTO {

	private UUID id;
	private ProcesoCompraDTO procesoCompra;
	private LocalDateTime fechaCompra;
	private String estado;

	public CompraDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setProcesoCompra(new ProcesoCompraDTO());
		setFechaCompra(UtilFecha.FECHA_HORA_DEFECTO);
		setEstado(UtilTexto.VACIA);
	}

	public CompraDTO(final UUID id, final ProcesoCompraDTO procesoCompra,
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

	public ProcesoCompraDTO getProcesoCompra() {
		return procesoCompra;
	}

	public void setProcesoCompra(final ProcesoCompraDTO procesoCompra) {
		this.procesoCompra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(procesoCompra, new ProcesoCompraDTO());
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