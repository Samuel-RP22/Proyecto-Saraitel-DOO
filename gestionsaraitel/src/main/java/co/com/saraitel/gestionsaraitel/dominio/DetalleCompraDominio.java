package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DetalleCompraDominio {

	private final UUID id;
	private final ProcesoCompraDominio procesoCompra;
	private final ProductoSedeDominio productoSede;
	private final int cantidad;
	private final BigDecimal precioUnitario;
	private final BigDecimal subtotal;

	public DetalleCompraDominio(final UUID id, final ProcesoCompraDominio procesoCompra,
			final ProductoSedeDominio productoSede, final int cantidad, final BigDecimal precioUnitario,
			final BigDecimal subtotal) {
		this.id = UtilUUID.obtenerValorDefecto(id);
		this.procesoCompra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(procesoCompra,
				ProcesoCompraDominio.obtenerValorDefecto());
		this.productoSede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(productoSede,
				ProductoSedeDominio.obtenerValorDefecto());
		this.cantidad = cantidad;
		this.precioUnitario = UtilNumero.obtenerValorDefecto(precioUnitario);
		this.subtotal = UtilNumero.obtenerValorDefecto(subtotal);
	}

	public static DetalleCompraDominio obtenerValorDefecto() {
		return new DetalleCompraDominio(UtilUUID.obtenerUUIDDefecto(), ProcesoCompraDominio.obtenerValorDefecto(),
				ProductoSedeDominio.obtenerValorDefecto(), 1, UtilNumero.CERO_DECIMAL, UtilNumero.CERO_DECIMAL);
	}

	public UUID getId() {
		return id;
	}

	public ProcesoCompraDominio getProcesoCompra() {
		return procesoCompra;
	}

	public ProductoSedeDominio getProductoSede() {
		return productoSede;
	}

	public int getCantidad() {
		return cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}
}