package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class IngresoInventarioDominio {

	private final UUID id;
	private final SedeDominio sede;
	private final EstadoInventarioDominio estado;
	private final LocalDateTime fechaLlegada;
	private final BigDecimal total;

	public IngresoInventarioDominio() {
		this.id = UtilUUID.obtenerUUIDDefecto();
		this.sede = new SedeDominio();
		this.estado = new EstadoInventarioDominio();
		this.fechaLlegada = UtilFecha.FECHA_HORA_DEFECTO;
		this.total = UtilNumero.CERO_DECIMAL;
	}

	public IngresoInventarioDominio(final UUID id, final SedeDominio sede,
			final EstadoInventarioDominio estado,
			final LocalDateTime fechaLlegada, final BigDecimal total) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(sede, new SedeDominio());
		this.estado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(estado, new EstadoInventarioDominio());
		this.fechaLlegada = UtilFecha.obtenerValorDefecto(fechaLlegada);
		this.total = UtilNumero.obtenerValorDefecto(total);
	}

	public UUID getId() {
		return id;
	}

	public SedeDominio getSede() {
		return sede;
	}

	public EstadoInventarioDominio getEstado() {
		return estado;
	}

	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}

	public BigDecimal getTotal() {
		return total;
	}
}