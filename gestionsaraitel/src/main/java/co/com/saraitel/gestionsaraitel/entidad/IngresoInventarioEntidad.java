package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class IngresoInventarioEntidad {

	private UUID id;
	private SedeEntidad sede;
	private LocalDateTime fechaLlegada;
	private BigDecimal total;
	private String estado;

	public IngresoInventarioEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setSede(new SedeEntidad());
		setFechaLlegada(UtilFecha.FECHA_HORA_DEFECTO);
		setTotal(UtilNumero.CERO_DECIMAL);
		setEstado(UtilTexto.VACIA);
	}

	public IngresoInventarioEntidad(final UUID id, final SedeEntidad sede, 
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

	public SedeEntidad getSede() {
		return sede;
	}

	public void setSede(final SedeEntidad sede) {
		this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(sede, new SedeEntidad());
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