package co.com.saraitel.gestionsaraitel.dto;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class SaldoFavorDTO {

	private UUID id;
	private DevolucionDTO devolucion;
	private EstadoSaldoFavorDTO estado;
	private BigDecimal montoUsado;
	

	public SaldoFavorDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setDevolucion(new DevolucionDTO());
		setEstado(new EstadoSaldoFavorDTO());
		setMontoUsado(UtilNumero.CERO_DECIMAL);
	}

	public SaldoFavorDTO(final UUID id, final DevolucionDTO devolucion,
			final EstadoSaldoFavorDTO estado, final BigDecimal montoUsado) {
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

	public DevolucionDTO getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(final DevolucionDTO devolucion) {
		this.devolucion = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(devolucion, new DevolucionDTO());
	}
	
	public EstadoSaldoFavorDTO getEstado() {
		return estado;
	}

	public void setEstado(final EstadoSaldoFavorDTO estado) {
		this.estado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(estado, new EstadoSaldoFavorDTO());
	}

	public BigDecimal getMontoUsado() {
		return montoUsado;
	}

	public void setMontoUsado(final BigDecimal montoUsado) {
		this.montoUsado = UtilNumero.obtenerValorDefecto(montoUsado);
	}
}