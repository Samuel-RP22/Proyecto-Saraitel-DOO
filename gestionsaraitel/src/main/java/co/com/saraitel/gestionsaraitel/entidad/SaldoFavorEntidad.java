package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class SaldoFavorEntidad {

	private UUID id;
	private DevolucionEntidad devolucion;
	private EstadoSaldoFavorEntidad estado;
	private BigDecimal montoUsado;
	

	public SaldoFavorEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setDevolucion(new DevolucionEntidad());
		setEstado(new EstadoSaldoFavorEntidad());
		setMontoUsado(UtilNumero.CERO_DECIMAL);
	}

	public SaldoFavorEntidad(final UUID id, final DevolucionEntidad devolucion,
			final EstadoSaldoFavorEntidad estado, final BigDecimal montoUsado) {
		setId(id);
		setDevolucion(devolucion);
		setEstado(estado);
		setMontoUsado(montoUsado);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public DevolucionEntidad getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(final DevolucionEntidad devolucion) {
		this.devolucion = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(devolucion, new DevolucionEntidad());
	}
	
	public EstadoSaldoFavorEntidad getEstado() {
		return estado;
	}

	public void setEstado(final EstadoSaldoFavorEntidad estado) {
		this.estado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(estado, new EstadoSaldoFavorEntidad());
	}

	public BigDecimal getMontoUsado() {
		return montoUsado;
	}

	public void setMontoUsado(final BigDecimal montoUsado) {
		this.montoUsado = UtilNumero.obtenerValorDefecto(montoUsado);
	}
}