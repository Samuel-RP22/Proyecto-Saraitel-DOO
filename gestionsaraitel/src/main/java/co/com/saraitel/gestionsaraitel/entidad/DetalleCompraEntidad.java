package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DetalleCompraEntidad {

	private UUID id;
	private ProcesoCompraEntidad procesoCompra;
	private ProductoSedeEntidad productoSede;
	private int cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal subtotal;

	public DetalleCompraEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setProcesoCompra(new ProcesoCompraEntidad());
		setProductoSede(new ProductoSedeEntidad());
		setCantidad(1);
		setPrecioUnitario(UtilNumero.CERO_DECIMAL);
		setSubtotal(UtilNumero.CERO_DECIMAL);
	}

	public DetalleCompraEntidad(final UUID id, final ProcesoCompraEntidad procesoCompra,
			final ProductoSedeEntidad productoSede, final int cantidad, 
			final BigDecimal precioUnitario, final BigDecimal subtotal) {
		setId(id);
		setProcesoCompra(procesoCompra);
		setProductoSede(productoSede);
		setCantidad(cantidad);
		setPrecioUnitario(precioUnitario);
		setSubtotal(subtotal);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public ProcesoCompraEntidad getProcesoCompra() {
		return procesoCompra;
	}

	public void setProcesoCompra(final ProcesoCompraEntidad procesoCompra) {
		this.procesoCompra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(procesoCompra, new ProcesoCompraEntidad());
	}

	public ProductoSedeEntidad getProductoSede() {
		return productoSede;
	}

	public void setProductoSede(final ProductoSedeEntidad productoSede) {
		this.productoSede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(productoSede, new ProductoSedeEntidad());
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(final int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(final BigDecimal precioUnitario) {
		this.precioUnitario = UtilNumero.obtenerValorDefecto(precioUnitario);
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(final BigDecimal subtotal) {
		this.subtotal = UtilNumero.obtenerValorDefecto(subtotal);
	}
}