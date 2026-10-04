package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class SaldoFavorEntidad {

	private UUID id;
	private DevolucionEntidad devolucion;
	private BigDecimal montoUsado;
	private String estado;

	public SaldoFavorEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setDevolucion(new DevolucionEntidad());
		setMontoUsado(UtilNumero.CERO_DECIMAL);
		setEstado(UtilTexto.VACIA);
	}

	public SaldoFavorEntidad(final UUID id, final DevolucionEntidad devolucion,
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

	public DevolucionEntidad getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(final DevolucionEntidad devolucion) {
		this.devolucion = UtilObjeto.esNulo(devolucion) ? 
				new DevolucionEntidad() : devolucion;
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