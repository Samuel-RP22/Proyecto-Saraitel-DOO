package co.com.saraitel.gestionsaraitel.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class FacturaDTO {

	private UUID id;
	private CompraDTO compra;
	private LocalDateTime fechaEmision;

	public FacturaDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCompra(new CompraDTO());
		setFechaEmision(UtilFecha.FECHA_HORA_DEFECTO);
	}

	public FacturaDTO(final UUID id, final CompraDTO compra,
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

	public CompraDTO getCompra() {
		return compra;
	}

	public void setCompra(final CompraDTO compra) {
		this.compra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(compra, new CompraDTO());
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(final LocalDateTime fechaEmision) {
		this.fechaEmision = UtilFecha.obtenerValorDefecto(fechaEmision);
	}
}