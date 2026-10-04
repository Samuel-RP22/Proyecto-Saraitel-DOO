package co.com.saraitel.gestionsaraitel.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class IngresoInventarioDTO {

	private UUID id;
	private SedeDTO sede;
	private LocalDateTime fechaLlegada;
	private BigDecimal total;
	private String estado;

	public IngresoInventarioDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setSede(new SedeDTO());
		setFechaLlegada(UtilFecha.FECHA_HORA_DEFECTO);
		setTotal(UtilNumero.CERO_DECIMAL);
		setEstado(UtilTexto.VACIA);
	}

	public IngresoInventarioDTO(final UUID id, final SedeDTO sede, 
			final LocalDateTime fechaLlegada, final BigDecimal total, final String estado) {
		setId(id);
		setSede(sede);
		setFechaLlegada(fechaLlegada);
		setTotal(total);
		setEstado(estado);
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
		this.sede = UtilObjeto.esNulo(sede) ? new SedeDTO() : sede;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
	}
}