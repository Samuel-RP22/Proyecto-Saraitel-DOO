package co.com.saraitel.gestionsaraitel.entidad;

import java.util.UUID;

public class DetalleIngresoEntidad {

	private UUID id;
	private IngresoInventarioEntidad ingresoInventario;
	private ProductoSedeEntidad productoSede;
	private int cantidad;
	private Double costoUnitario;
	private Double subtotal;

	public DetalleIngresoEntidad() {
		super();
	}

	public DetalleIngresoEntidad(final UUID id, final IngresoInventarioEntidad ingresoInventario,
			final ProductoSedeEntidad productoSede, final int cantidad, final Double costoUnitario,
			final Double subtotal) {
		super();
		setId(id);
		setIngresoInventario(ingresoInventario);
		setProductoSede(productoSede);
		setCantidad(cantidad);
		setCostoUnitario(costoUnitario);
		setSubtotal(subtotal);
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = id;
	}

	public IngresoInventarioEntidad getIngresoInventario() {
		return ingresoInventario;
	}

	public void setIngresoInventario(final IngresoInventarioEntidad ingresoInventario) {
		this.ingresoInventario = ingresoInventario;
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

	public Double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(final Double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(final Double subtotal) {
		this.subtotal = subtotal;
	}
}