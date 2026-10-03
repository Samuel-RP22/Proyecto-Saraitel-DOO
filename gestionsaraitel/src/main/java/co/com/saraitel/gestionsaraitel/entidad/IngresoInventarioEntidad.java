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
	private String estado;
	private SedeEntidad sede;
	private LocalDateTime fechallegada;
	private BigDecimal total;

	public IngresoInventarioEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setEstado(UtilTexto.VACIA);
		setSede(new SedeEntidad());
		setFechallegada(UtilFecha.FECHA_DEFECTO);
		setTotal(UtilNumero.);
	}

	public IngresoInventarioEntidad(final UUID id, final String estado, final SedeEntidad sede, final LocalDateTime fechallegada, final Double total) {
		setId(id);
		setEstado(estado);
		setSede(sede);
		setFechallegada(fechallegada);
		setTotal(total);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
	}

	public SedeEntidad getSede() {
		return sede;
	}

	public void setSede(final SedeEntidad sede) {
		this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(sede, new SedeEntidad());
	}

	public LocalDateTime getFechallegada() {
		return fechallegada;
	}

	public void setFechallegada(final LocalDateTime fechallegada) {
		this.fechallegada = UtilFecha.;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(final Double total) {
		this.total = UtilNumero.;
	}
}