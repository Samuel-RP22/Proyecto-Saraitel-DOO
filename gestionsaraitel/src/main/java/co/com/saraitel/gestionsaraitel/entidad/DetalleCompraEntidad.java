package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

public class DetalleCompraEntidad {

	private UUID id;
	private ProcesoCompraEntidad procesoCompra;
	private ProductoSedeEntidad productoSede;
	private int cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal subtotal;

	public DetalleCompraEntidad() {
		super();
	}

	public DetalleCompraEntidad(final UUID id, final ProcesoCompraEntidad procesoCompra,
			final ProductoSedeEntidad productoSede, final int cantidad, final BigDecimal precioUnitario,
			final BigDecimal subtotal) {
		super();
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
		this.id = id;
	}

	public ProcesoCompraEntidad getProcesoCompra() {
		return procesoCompra;
	}

	public void setProcesoCompra(final ProcesoCompraEntidad procesoCompra) {
		this.procesoCompra = procesoCompra;
	}

	public ProductoSedeEntidad getProductoSede() {
		return productoSede;
	}

	public void setProductoSede(final ProductoSedeEntidad productoSede) {
		this.productoSede = productoSede;
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
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(final BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
}