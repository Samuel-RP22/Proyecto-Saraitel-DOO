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

	public IngresoInventarioDominio(final UUID id, final SedeDominio sede, final EstadoInventarioDominio estado,
			final LocalDateTime fechaLlegada, final BigDecimal total) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.sede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(sede, SedeDominio.obtenerValorDefecto());
		this.estado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estado,
				EstadoInventarioDominio.obtenerValorDefecto());
		this.fechaLlegada = UtilFecha.obtenerValorDefecto(fechaLlegada);
		this.total = UtilNumero.obtenerValorDefecto(total);
	}

	public static IngresoInventarioDominio obtenerValorDefecto() {
		return new IngresoInventarioDominio(UtilUUID.obtenerUUIDDefecto(), SedeDominio.obtenerValorDefecto(),
				EstadoInventarioDominio.obtenerValorDefecto(), UtilFecha.FECHA_HORA_DEFECTO, UtilNumero.CERO_DECIMAL);
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