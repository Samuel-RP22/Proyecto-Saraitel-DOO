package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class SaldoFavorDominio {

	private final UUID id;
	private final DevolucionDominio devolucion;
	private final EstadoSaldoFavorDominio estado;
	private final BigDecimal montoUsado;

	public SaldoFavorDominio() {
		this.id = UtilUUID.obtenerUUIDDefecto();
		this.devolucion = new DevolucionDominio();
		this.estado = new EstadoSaldoFavorDominio();
		this.montoUsado = UtilNumero.CERO_DECIMAL;
	}

	public SaldoFavorDominio(final UUID id, final DevolucionDominio devolucion,
			final EstadoSaldoFavorDominio estado, final BigDecimal montoUsado) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.devolucion = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(devolucion, new DevolucionDominio());
		this.estado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(estado, new EstadoSaldoFavorDominio());
		this.montoUsado = UtilNumero.obtenerValorDefecto(montoUsado);
	}

	public UUID getId() {
		return id;
	}

	public DevolucionDominio getDevolucion() {
		return devolucion;
	}

	public EstadoSaldoFavorDominio getEstado() {
		return estado;
	}

	public BigDecimal getMontoUsado() {
		return montoUsado;
	}
}