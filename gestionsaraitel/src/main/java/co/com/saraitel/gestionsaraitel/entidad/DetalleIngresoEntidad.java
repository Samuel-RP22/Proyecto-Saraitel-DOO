package co.com.saraitel.gestionsaraitel.entidad;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DetalleIngresoEntidad {

	private UUID id;
	private IngresoInventarioEntidad ingresoInventario;
	private ProductoSedeEntidad productoSede;
	private int cantidad;
	private BigDecimal costoUnitario;
	private BigDecimal subtotal;

	public DetalleIngresoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setIngresoInventario(new IngresoInventarioEntidad());
		setProductoSede(new ProductoSedeEntidad());
		setCantidad(1);
		setCostoUnitario(UtilNumero.CERO_DECIMAL);
		setSubtotal(UtilNumero.CERO_DECIMAL);
	}

	public DetalleIngresoEntidad(final UUID id, final IngresoInventarioEntidad ingresoInventario,
			final ProductoSedeEntidad productoSede, final int cantidad, 
			final BigDecimal costoUnitario, final BigDecimal subtotal) {
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
		this.id = UtilUUID.obtenerValorDefecto(id);
	}

	public IngresoInventarioEntidad getIngresoInventario() {
		return ingresoInventario;
	}

	public void setIngresoInventario(final IngresoInventarioEntidad ingresoInventario) {
		this.ingresoInventario = UtilObjeto.esNulo(ingresoInventario) ?
				new IngresoInventarioEntidad() : ingresoInventario;
	}

	public ProductoSedeEntidad getProductoSede() {
		return productoSede;
	}

	public void setProductoSede(final ProductoSedeEntidad productoSede) {
		this.productoSede = UtilObjeto.esNulo(productoSede) ?
				new ProductoSedeEntidad() : productoSede;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(final int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(final BigDecimal costoUnitario) {
		this.costoUnitario = UtilNumero.obtenerValorDefecto(costoUnitario);
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(final BigDecimal subtotal) {
		this.subtotal = UtilNumero.obtenerValorDefecto(subtotal);
	}
}