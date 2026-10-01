package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

public class SaldoFavorEntidad {

	private UUID id;
	private DevolucionEntidad devolucion;
	private BigDecimal montoDisponible;
	private String estado;

	public SaldoFavorEntidad() {
		super();
	}

	public SaldoFavorEntidad(final UUID id, final DevolucionEntidad devolucion, final BigDecimal montoDisponible,
			final String estado) {
		super();
		setId(id);
		setDevolucion(devolucion);
		setMontoDisponible(montoDisponible);
		setEstado(estado);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public DevolucionEntidad getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(final DevolucionEntidad devolucion) {
		this.devolucion = devolucion;
	}

	public BigDecimal getMontoDisponible() {
		return montoDisponible;
	}

	public void setMontoDisponible(final BigDecimal montoDisponible) {
		this.montoDisponible = montoDisponible;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}
}