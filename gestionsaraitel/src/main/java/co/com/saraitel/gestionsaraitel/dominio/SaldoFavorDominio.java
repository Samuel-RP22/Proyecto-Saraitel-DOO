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

	public SaldoFavorDominio(final UUID id, final DevolucionDominio devolucion, final EstadoSaldoFavorDominio estado,
			final BigDecimal montoUsado) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.devolucion = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(devolucion,
				DevolucionDominio.obtenerValorDefecto());
		this.estado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estado,
				EstadoSaldoFavorDominio.obtenerValorDefecto());
		this.montoUsado = UtilNumero.obtenerValorDefecto(montoUsado);
	}

	public static SaldoFavorDominio obtenerValorDefecto() {
		return new SaldoFavorDominio(UtilUUID.obtenerUUIDDefecto(), DevolucionDominio.obtenerValorDefecto(),
				EstadoSaldoFavorDominio.obtenerValorDefecto(), UtilNumero.CERO_DECIMAL);
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