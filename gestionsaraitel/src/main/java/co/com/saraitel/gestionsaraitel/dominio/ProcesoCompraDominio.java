package co.com.saraitel.gestionsaraitel.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilNumero;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilUUID;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilFecha;

public class ProcesoCompraDominio {

	private UUID id;
	private ClienteDominio cliente;
	private EmpleadoDominio empleado;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaActualizacion;
	private BigDecimal totalCompra;
	private String estado;

	private ProcesoCompraDominio(Builder builder) {
		this.id = builder.id;
		this.cliente = builder.cliente;
		this.empleado = builder.empleado;
		this.fechaInicio = builder.fechaInicio;
		this.fechaActualizacion = builder.fechaActualizacion;
		this.totalCompra = builder.totalCompra;
		this.estado = builder.estado;
	}

	public UUID getId() {
		return id;
	}

	public ClienteDominio getCliente() {
		return cliente;
	}

	public EmpleadoDominio getEmpleado() {
		return empleado;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public BigDecimal getTotalCompra() {
		return totalCompra;
	}

	public String getEstado() {
		return estado;
	}

	public static class Builder {

		private UUID id;
		private ClienteDominio cliente;
		private EmpleadoDominio empleado;
		private LocalDateTime fechaInicio;
		private LocalDateTime fechaActualizacion;
		private BigDecimal totalCompra;
		private String estado;

		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			cliente = new ClienteDominio.Builder().build();
			empleado = new EmpleadoDominio.Builder().build();
			fechaInicio = UtilFecha.FECHA_HORA_DEFECTO;
			fechaActualizacion = UtilFecha.FECHA_HORA_DEFECTO;
			totalCompra = UtilNumero.CERO_DECIMAL;
			estado = UtilTexto.VACIA;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder cliente(ClienteDominio cliente) {
			this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
					cliente, new ClienteDominio.Builder().build());
			return this;
		}

		public Builder empleado(EmpleadoDominio empleado) {
			this.empleado = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(
					empleado, new EmpleadoDominio.Builder().build());
			return this;
		}

		public Builder fechaInicio(LocalDateTime fechaInicio) {
			this.fechaInicio = UtilFecha.obtenerValorDefecto(fechaInicio);
			return this;
		}

		public Builder fechaActualizacion(LocalDateTime fechaActualizacion) {
			this.fechaActualizacion = UtilFecha.obtenerValorDefecto(fechaActualizacion);
			return this;
		}

		public Builder estado(String estado) {
			this.estado = UtilTexto.quitarEspaciosEnBlanco(estado);
			return this;
		}

		public ProcesoCompraDominio build() {
			return new ProcesoCompraDominio(this);
		}
	}
}