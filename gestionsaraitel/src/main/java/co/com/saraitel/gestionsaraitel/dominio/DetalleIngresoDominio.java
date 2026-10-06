package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;

public class DetalleIngresoDominio {

	private UUID id;
	private IngresoInventarioDominio ingresoInventario;
	private ProductoSedeDominio productoSede;
	private int cantidad;
	private BigDecimal costoUnitario;
	private BigDecimal subtotal;

	private DetalleIngresoDominio(Builder builder) {
		this.id = builder.id;
		this.ingresoInventario = builder.ingresoInventario;
		this.productoSede = builder.productoSede;
		this.cantidad = builder.cantidad;
		this.costoUnitario = builder.costoUnitario;
		this.subtotal = builder.subtotal;
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

	public static class Builder {

		private UUID id;
		private IngresoInventarioDominio ingresoInventario;
		private ProductoSedeDominio productoSede;
		private int cantidad;
		private BigDecimal costoUnitario;
		private BigDecimal subtotal;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			ingresoInventario = new IngresoInventarioDominio.Builder().build();
			productoSede = new ProductoSedeDominio.Builder().build();
			cantidad = 1;
			costoUnitario = UtilNumero.CERO_DECIMAL;
			subtotal = UtilNumero.CERO_DECIMAL;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder ingresoInventario(IngresoInventarioDominio ingresoInventario) {
			this.ingresoInventario = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
					ingresoInventario, new IngresoInventarioDominio.Builder().build());
			return this;
		}

		public Builder productoSede(ProductoSedeDominio productoSede) {
			this.productoSede = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
					productoSede, new ProductoSedeDominio.Builder().build());
			return this;
		}

		public Builder cantidad(int cantidad) {
			this.cantidad = cantidad;
			return this;
		}

		public Builder costoUnitario(BigDecimal costoUnitario) {
			this.costoUnitario = UtilNumero.obtenerValorDefecto(costoUnitario);
			return this;
		}

		public DetalleIngresoDominio build() {
			return new DetalleIngresoDominio(this);
		}
	}
}