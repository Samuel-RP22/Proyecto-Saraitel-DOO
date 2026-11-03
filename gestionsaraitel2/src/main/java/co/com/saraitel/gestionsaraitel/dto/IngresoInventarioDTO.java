package co.com.saraitel.gestionsaraitel.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class IngresoInventarioDTO {

	private UUID id;
	private SedeDTO sede;
	private EstadoInventarioDTO estado;
	private LocalDateTime fechaLlegada;
	private BigDecimal total;

	public IngresoInventarioDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setSede(new SedeDTO());
		setEstado(new EstadoInventarioDTO());
		setFechaLlegada(UtilFecha.FECHA_HORA_DEFECTO);
		setTotal(UtilNumero.CERO_DECIMAL);
	}

	public IngresoInventarioDTO(final UUID id, final SedeDTO sede, final EstadoInventarioDTO estado,
			final LocalDateTime fechaLlegada, final BigDecimal total) {
		setId(id);
		setSede(sede);
		setEstado(estado);
		setFechaLlegada(fechaLlegada);
		setTotal(total);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public SedeDTO getSede() {
		return sede;
	}

	public void setSede(final SedeDTO sede) {
		this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(sede, new SedeDTO());
	}

	public EstadoInventarioDTO getEstado() {
		return estado;
	}

	public void setEstado(final EstadoInventarioDTO estado) {
		this.estado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estado, new EstadoInventarioDTO());
	}

	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(final LocalDateTime fechaLlegada) {
		this.fechaLlegada = UtilFecha.obtenerValorDefecto(fechaLlegada);
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(final BigDecimal total) {
		this.total = UtilNumero.obtenerValorDefecto(total);
	}
}