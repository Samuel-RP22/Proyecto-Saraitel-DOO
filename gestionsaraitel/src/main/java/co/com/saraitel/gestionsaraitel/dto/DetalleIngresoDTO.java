package co.com.saraitel.gestionsaraitel.dto;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DetalleIngresoDTO {

	private UUID id;
	private IngresoInventarioDTO ingresoInventario;
	private ProductoSedeDTO productoSede;
	private int cantidad;
	private BigDecimal costoUnitario;
	private BigDecimal subtotal;

	public DetalleIngresoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setIngresoInventario(new IngresoInventarioDTO());
		setProductoSede(new ProductoSedeDTO());
		setCantidad(1);
		setCostoUnitario(UtilNumero.CERO_DECIMAL);
		setSubtotal(UtilNumero.CERO_DECIMAL);
	}

	public DetalleIngresoDTO(final UUID id, final IngresoInventarioDTO ingresoInventario,
			final ProductoSedeDTO productoSede, final int cantidad, 
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

	public IngresoInventarioDTO getIngresoInventario() {
		return ingresoInventario;
	}

	public void setIngresoInventario(final IngresoInventarioDTO ingresoInventario) {
		this.ingresoInventario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(ingresoInventario, new IngresoInventarioDTO());
	}

	public ProductoSedeDTO getProductoSede() {
		return productoSede;
	}

	public void setProductoSede(final ProductoSedeDTO productoSede) {
		this.productoSede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(productoSede, new ProductoSedeDTO());
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