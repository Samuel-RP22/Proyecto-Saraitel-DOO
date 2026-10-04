package co.com.saraitel.gestionsaraitel.dto;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DetalleCompraDTO {

	private UUID id;
	private ProcesoCompraDTO procesoCompra;
	private ProductoSedeDTO productoSede;
	private int cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal subtotal;

	public DetalleCompraDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setProcesoCompra(new ProcesoCompraDTO());
		setProductoSede(new ProductoSedeDTO());
		setCantidad(1);
		setPrecioUnitario(UtilNumero.CERO_DECIMAL);
		setSubtotal(UtilNumero.CERO_DECIMAL);
	}

	public DetalleCompraDTO(final UUID id, final ProcesoCompraDTO procesoCompra,
			final ProductoSedeDTO productoSede, final int cantidad, 
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

	public ProcesoCompraDTO getProcesoCompra() {
		return procesoCompra;
	}

	public void setProcesoCompra(final ProcesoCompraDTO procesoCompra) {
		this.procesoCompra = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo
				(procesoCompra, new ProcesoCompraDTO());
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