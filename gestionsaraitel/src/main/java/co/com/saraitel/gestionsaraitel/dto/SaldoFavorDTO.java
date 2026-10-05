package co.com.saraitel.gestionsaraitel.dto;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class SaldoFavorDTO {

	private UUID id;
	private DevolucionDTO devolucion;
	private BigDecimal montoUsado;
	private String estado;

	public SaldoFavorDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setDevolucion(new DevolucionDTO());
		setMontoUsado(UtilNumero.CERO_DECIMAL);
		setEstado(UtilTexto.VACIA);
	}

	public SaldoFavorDTO(final UUID id, final DevolucionDTO devolucion,
			final BigDecimal montoUsado, final String estado) {
		setId(id);
		setDevolucion(devolucion);
		setMontoUsado(montoUsado);
		setEstado(estado);
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

	public BigDecimal getMontoUsado() {
		return montoUsado;
	}

	public void setMontoUsado(final BigDecimal montoUsado) {
		this.montoUsado = UtilNumero.obtenerValorDefecto(montoUsado);
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
	}
}