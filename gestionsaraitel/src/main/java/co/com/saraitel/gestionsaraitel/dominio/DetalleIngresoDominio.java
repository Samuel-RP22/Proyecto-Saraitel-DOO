package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DetalleIngresoDominio {

	private final UUID id;
	private final IngresoInventarioDominio ingresoInventario;
	private final ProductoSedeDominio productoSede;
	private final int cantidad;
	private final BigDecimal costoUnitario;
	private final BigDecimal subtotal;

	public DetalleIngresoDominio(final UUID id, final IngresoInventarioDominio ingresoInventario,
			final ProductoSedeDominio productoSede, final Integer cantidad, final BigDecimal costoUnitario,
			final BigDecimal subtotal) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.ingresoInventario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(ingresoInventario,
				IngresoInventarioDominio.obtenerValorDefecto());
		this.productoSede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(productoSede,
				ProductoSedeDominio.obtenerValorDefecto());
		this.cantidad = UtilNumero.obtenerValorDefecto(cantidad, 1);
		this.costoUnitario = UtilNumero.obtenerValorDefecto(costoUnitario);
		this.subtotal = UtilNumero.obtenerValorDefecto(subtotal);
	}
	
	public static DetalleIngresoDominio obtenerValorDefecto() {
	    return new DetalleIngresoDominio(
	            UtilUUID.obtenerUUIDDefecto(),
	            IngresoInventarioDominio.obtenerValorDefecto(),
	            ProductoSedeDominio.obtenerValorDefecto(),
	            0,
	            UtilNumero.CERO_DECIMAL,
	            UtilNumero.CERO_DECIMAL);
	}

	public UUID getId() {
		return id;
	}

	public IngresoInventarioDominio getIngresoInventario() {
		return ingresoInventario;
	}

	public ProductoSedeDominio getProductoSede() {
		return productoSede;
	}

	public int getCantidad() {
		return cantidad;
	}

	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}
}